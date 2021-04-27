package com.leetcode.hsm;

import com.cavium.cfm2.LoginManager;
import com.cavium.cfm2.Util;
import com.cavium.key.CaviumKey;
import com.cavium.key.parameter.CaviumRSAKeyGenParameterSpec;
import com.cavium.key.store.CaviumKeyStore;
import com.cavium.provider.CaviumProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;

/**
 * @Author: wangwu
 * @Date: Created in 18:14 2021/04/06
 * @Description:
 */
public class RsaKeyPersistWithLabelLinux {
	private static final Logger logger = LogManager.getLogger("RsaKeyPersistWithLabel");
	private static final String TRANSFORMATION = "RSA/ECB/OAEPPADDING";
	private static final String SIGN_ALGORITHM = "SHA256WithRSA/PSS";
	private static final String PUBLIC_KEY_LABEL = "rsa_test_publickey";
	private static final String PRIVATE_KEY_LABEL = "rsa_test_privatekey";

	public static void main(String[] args) {
		try{
			Security.addProvider(new CaviumProvider("Cavium", 1L, "The Cavium LiquidSecurity(tm) JCA Provider"));
			logger.info("**** Add Provider ****");
			LoginManager lm = LoginManager.getInstance();
			lm.login();
			logger.info("**** Login Success ****");
			generateRSAKeyPair();
			CaviumKeyStore keyStore = new CaviumKeyStore();
			Key pk = keyStore.engineGetKey(PRIVATE_KEY_LABEL,null);
			logger.info("**** RSA Primary Key****"+new String(pk.getEncoded()));
			KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.engineGetEntry(PRIVATE_KEY_LABEL, null);
			PublicKey puk = privateKeyEntry.getCertificate().getPublicKey();
			if (pk == null || puk == null) {
				logger.error("**** RSA Key Generate failed ****");
			}
			logger.info("**** RSA Key Generated ****");
			byte[] plaintext = "test".getBytes();
			byte[] encryptResult = encrypt(TRANSFORMATION, puk, plaintext);
			if (encryptResult != null) {
				logger.info("**** RSA Encrypt Success ****");
			}else{
				logger.error("**** RSA Encrypt Failed ****");
				return;
			}
			byte[] decryptResult = decrypt(TRANSFORMATION, pk,encryptResult);
			if (decryptResult != null && Arrays.equals(decryptResult,
					plaintext)) {
				logger.info("**** RSA Decrypt Success ****");
			}else{
				logger.error("**** RSA Decrypt Failed ****");
				return;
			}
			byte[] signResult = sign(plaintext, (PrivateKey) pk, SIGN_ALGORITHM);
			boolean verify = verify(plaintext, signResult, puk, SIGN_ALGORITHM);
			if (verify) {
				logger.info("**** Signature verified ****");
			}else{
				logger.error("**** Signature is invalid! ****");
			}
			Util.deleteKey((CaviumKey) pk);
			Util.deleteKey((CaviumKey) puk);
			KeyStore.Entry entry = keyStore.engineGetEntry(PRIVATE_KEY_LABEL, null);
			if (entry != null) {
				logger.error("**** Delete Failed ****");
			}else{
				logger.info("**** Key Deleted ****");
			}
			lm.logout();
			logger.info("**** Logout ****");
		}catch (Exception e){
            e.printStackTrace();
		}
	}
	public static byte[] encrypt(String transformation, Key key, byte[] plainText) {
		logger.info("**** RSA Key Encrypt ****");
		try {
			logger.info("**** RSA Key Sign ****");

			Cipher encCipher = Cipher.getInstance(transformation, "Cavium");
					encCipher.init(Cipher.ENCRYPT_MODE, key);
			return encCipher.doFinal(plainText);
		} catch (NoSuchAlgorithmException | NoSuchProviderException
				| NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static byte[] decrypt(String transformation, Key key, byte[] cipherText){
		logger.info("**** RSA Key Decrypt ****");
		try{
			Cipher decCipher = Cipher.getInstance(transformation, "Cavium");
			decCipher.init(Cipher.DECRYPT_MODE, key);
			return decCipher.doFinal(cipherText);
		}catch (NoSuchAlgorithmException | NoSuchProviderException
				| NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e){
			e.printStackTrace();
		}
		return null;
	}
	public static byte[] sign(byte[] message, PrivateKey key, String signingAlgorithm){
		logger.info("**** RSA Key Sign ****");
		try{
			Signature sig = Signature.getInstance(signingAlgorithm, "Cavium");
			sig.initSign(key);
			sig.update(message);
			return sig.sign();
		}catch (NoSuchAlgorithmException | NoSuchProviderException
				| InvalidKeyException | SignatureException e){
			e.printStackTrace();
		}
		return null;
	}
	public static boolean verify(byte[] message, byte[] signature, PublicKey publicKey, String signingAlgorithm){
		logger.info("**** RSA Key Verify ****");
		try{
			Signature sig = Signature.getInstance(signingAlgorithm, "Cavium");
			sig.initVerify(publicKey);
			sig.update(message);
			return sig.verify(signature);
		}catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeyException | SignatureException e){
			e.printStackTrace();
		}
		return false;
	}
	private static KeyPair generateRSAKeyPair() throws Exception {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA","Cavium");
		kpg.initialize(new CaviumRSAKeyGenParameterSpec(2048, new BigInteger("65537"),
				PUBLIC_KEY_LABEL, PRIVATE_KEY_LABEL, true, true));
		return kpg.generateKeyPair();
	}




}
