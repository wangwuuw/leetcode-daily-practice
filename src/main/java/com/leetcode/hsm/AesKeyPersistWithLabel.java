package com.leetcode.hsm;


import com.cavium.cfm2.CFM2Exception;
import com.cavium.cfm2.LoginManager;
import com.cavium.cfm2.Util;
import com.cavium.key.CaviumKey;
import com.cavium.key.parameter.CaviumAESKeyGenParameterSpec;
import com.cavium.key.store.CaviumKeyStore;
import com.cavium.provider.CaviumProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class AesKeyPersistWithLabel {
	private static final String AES_KEY_LABEL = "aes_key_test";
	private static final String PLAIN_TEXT = "test_example";
	private static final int AES_KEY_SIZE = 256;
	private static final Logger logger = LogManager.getLogger("AesKeyPersistWithLabel");

	public static void main(String[] args) {
		try {
			Security.addProvider(new CaviumProvider("Cavium", 1L, "The Cavium LiquidSecurity(tm) JCA Provider"));
			logger.info("**** Add Provider ****");
			LoginManager lm = LoginManager.getInstance();
			lm.login();
			logger.info("**** Login Success ****");
			Key key = generateAesKeyAndPersist(AES_KEY_LABEL);
			Optional.ofNullable(key).orElseThrow(() -> new RuntimeException("generate key failed. "));
			Key keyWithLabel = getKeyWithLabel(AES_KEY_LABEL);
			Optional.ofNullable(keyWithLabel).orElseThrow(() -> new RuntimeException("get key failed. label: " + keyWithLabel));
			encDecGcm((SecretKey) keyWithLabel);
			boolean b = deleteKeyWithLabel(AES_KEY_LABEL);
			logger.info("**** Key has been deleted? : " + b + " ****");
			lm.logout();
			logger.info("**** Logout ****");
		} catch (IOException | CFM2Exception e) {
			e.printStackTrace();
		}
	}

	private static Key getKeyWithLabel(String label) {
		logger.info("**** Get Key With Label ****");
		try {
			CaviumKeyStore keyStore = new CaviumKeyStore();
			return keyStore.engineGetKey(label, null);
		} catch (NoSuchAlgorithmException | UnrecoverableKeyException
				e) {
			e.printStackTrace();
		}
		return null;
	}

	private static boolean deleteKeyWithLabel(String label) {
		logger.info("**** Delete Key With Label ****");
		try {
			logger.info("**** Encrypt ****");
			Key keyWithLabel = getKeyWithLabel(label);
			Util.deleteKey((CaviumKey) keyWithLabel);
			return true;
		} catch (CFM2Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static Key generateAesKeyAndPersist(String label) {
		try {
			KeyGenerator kg = KeyGenerator.getInstance("AES", "Cavium");
			kg.init(new CaviumAESKeyGenParameterSpec(AES_KEY_SIZE, AES_KEY_LABEL, true, true));
			SecretKey secretKey = kg.generateKey();
			logger.info("**** Generate Aes Key And Persist Success ****");
			return secretKey;
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void encDecGcm(SecretKey k) {
		try {
			Cipher cp = Cipher.getInstance("AES/GCM/NoPadding", "Cavium");
			byte[] iv = new byte[12];
			Random r = new Random();
			r.nextBytes(iv);
			byte[] p = new byte[]{1};
			byte[] aad = new byte[]{2};
			logger.info("**** Encrypt ****");
			cp.init(Cipher.ENCRYPT_MODE, k, new GCMParameterSpec(128, iv));
			cp.updateAAD(aad);
			byte[] c = cp.doFinal(p);
			logger.info("**** Decrypt ****");
			byte[] newiv = cp.getIV();
			cp.init(Cipher.DECRYPT_MODE, k, new GCMParameterSpec(128, newiv));
			cp.updateAAD(aad);
			byte[] v = cp.doFinal(c);
			if (Arrays.equals(p, v)) {
				logger.info("**** Encrypt And Decrypt Success ****");
			} else {
				logger.error("**** Encrypt And Decrypt Failed ****");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
