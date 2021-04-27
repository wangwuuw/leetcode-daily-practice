package com.leetcode.hsm;

import com.cavium.cfm2.LoginManager;
import com.cavium.cfm2.Util;
import com.cavium.key.CaviumKey;
import com.cavium.key.CaviumRSAPrivateKey;
import com.cavium.key.parameter.CaviumRSAKeyGenParameterSpec;
import com.cavium.key.store.CaviumKeyStore;
import com.cavium.provider.CaviumProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

public class GetPublicKeyByPrivateKey {
	private static final Logger logger = LogManager.getLogger("GetPublicKeyByPrivateKey");
	private static final String TRANSFORMATION = "RSA/ECB/OAEPPADDING";
	private static final String SIGN_ALGORITHM = "SHA256WithRSA/PSS";
	private static final String PUBLIC_KEY_LABEL = "rsa_test_publickey";
	private static final String PRIVATE_KEY_LABEL = "rsa_test_privatekey";
	public static void main(String[] args) throws Exception {
		Security.addProvider(new CaviumProvider("Cavium", 1L, "The Cavium LiquidSecurity(tm) JCA Provider"));
		logger.info("**** Add Provider ****");
		LoginManager lm = LoginManager.getInstance();
		lm.login();
		logger.info("**** Login Success ****");
		// Generate a Rsa key.
		KeyPair keyPair = generateRSAKeyPair();
		PrivateKey pk = keyPair.getPrivate();
		PublicKey puk = keyPair.getPublic();
		if (pk == null || puk == null) {
			logger.error("**** RSA Key Generate failed ****");
		}
		logger.info("**** RSA Key Generated ****");
		// get privateKey by label
		CaviumKeyStore keyStore = new CaviumKeyStore();
		CaviumRSAPrivateKey privateKey = (CaviumRSAPrivateKey)keyStore.engineGetKey(PRIVATE_KEY_LABEL, null);
		BigInteger modulus = privateKey.getModulus();
		BigInteger publicExponent = privateKey.getPublicExponent();
		// get publicKey by privateKey
		logger.info("**** Get PublicKey By PrivateKey ****");
		RSAPublicKey rsaPublicKey = generateRSAPublicKey(modulus, publicExponent);
		byte[] plaintext = "test".getBytes();

//		// sign
//		byte[] signResult = sign(plaintext, (PrivateKey) privateKey, SIGN_ALGORITHM);
//		// verify
//		boolean verify = verify(plaintext, signResult, rsaPublicKey, SIGN_ALGORITHM);
//		if (verify) {
//			logger.info("**** Signature verified ****");
//		} else {
//			logger.error("**** Signature is invalid! ****");
//		}
		// delete key
		Util.deleteKey((CaviumKey) privateKey);
		Util.deleteKey((CaviumKey) puk);
		KeyStore.Entry entry = keyStore.engineGetEntry(PRIVATE_KEY_LABEL, null);
		if (entry != null) {
			logger.error("**** Delete Failed ****");
		} else {
			logger.info("**** Key Deleted ****");
		}
		lm.logout();
		logger.info("**** Logout ****");

	}
	private static KeyPair generateRSAKeyPair() throws
			Exception {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", "Cavium");
		kpg.initialize(new CaviumRSAKeyGenParameterSpec(2048, new
				BigInteger("65537"), PUBLIC_KEY_LABEL, PRIVATE_KEY_LABEL, true, true));
		return kpg.generateKeyPair();
	}
	public static RSAPublicKey generateRSAPublicKey(BigInteger modulus, BigInteger publicExponent) throws NoSuchProviderException, NoSuchAlgorithmException {
		KeyFactory keyFac = KeyFactory.getInstance("RSA", "Cavium");
		RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(modulus, publicExponent);
		try {
			return (RSAPublicKey) keyFac.generatePublic(pubKeySpec);
		} catch (InvalidKeySpecException ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	public static byte[] sign(byte[] message, PrivateKey key, String signingAlgorithm) {
		logger.info("**** RSA Key Sign ****");
		try {
			Signature sig = Signature.getInstance(signingAlgorithm, "Cavium");
			sig.initSign(key);
			sig.update(message);
			return sig.sign();
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeyException | SignatureException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean verify(byte[] message, byte[] signature, PublicKey publicKey, String signingAlgorithm) {
		logger.info("**** RSA Key Verify ****");
		try {
			Signature sig = Signature.getInstance(signingAlgorithm, "Cavium");
			sig.initVerify(publicKey);
			sig.update(message);
			return sig.verify(signature);
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeyException | SignatureException e) {
			e.printStackTrace();
		}
		return false;
	}
}