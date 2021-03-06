package com.leetcode.secret;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;

/**
 * @Author: wangwu
 * @Date: Created in 10:50 2021/03/25
 * @Description:
 */
public class SecretTest {
//	public static void main(String[] args) throws Exception {
//		// 创建一个MessageDigest实例:
//		MessageDigest md = MessageDigest.getInstance("SHA-1");
//		// 反复调用update输入数据:
//		md.update("Hello".getBytes("UTF-8"));
//		md.update("World".getBytes("UTF-8"));
//		byte[] result = md.digest(); // 20 bytes: db8ac1c259eb89d4a131b253bacfca5f319d54f2
//		System.out.println(new BigInteger(1, result).toString(16));
//	}
	public static void main(String[] args) throws Exception {
		// 明文:
		byte[] plain = "Hello, encrypt use RSA".getBytes("UTF-8");
		// 创建公钥／私钥对:
		Person alice = new Person("Alice");
		// 用Alice的公钥加密:
		byte[] pk = alice.getPublicKey();
		System.out.println(String.format("public key: %x", new BigInteger(1, pk)));
		byte[] encrypted = alice.encrypt(plain);
		System.out.println(String.format("encrypted: %x", new BigInteger(1, encrypted)));
		// 用Alice的私钥解密:
		byte[] sk = alice.getPrivateKey();
		System.out.println(String.format("private key: %x", new BigInteger(1, sk)));
		byte[] decrypted = alice.decrypt(encrypted);
		System.out.println(new String(decrypted, "UTF-8"));
	}
	static class Person {
		String name;
		// 私钥:
		PrivateKey sk;
		// 公钥:
		PublicKey pk;

		public Person(String name) throws GeneralSecurityException {
			this.name = name;
			// 生成公钥／私钥对:
			KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
			kpGen.initialize(1024);
			KeyPair kp = kpGen.generateKeyPair();
			this.sk = kp.getPrivate();
			this.pk = kp.getPublic();
		}

		// 把私钥导出为字节
		public byte[] getPrivateKey() {
			return this.sk.getEncoded();
		}

		// 把公钥导出为字节
		public byte[] getPublicKey() {
			return this.pk.getEncoded();
		}

		// 用公钥加密:
		public byte[] encrypt(byte[] message) throws GeneralSecurityException {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, this.pk);
			return cipher.doFinal(message);
		}

		// 用私钥解密:
		public byte[] decrypt(byte[] input) throws GeneralSecurityException {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, this.sk);
			return cipher.doFinal(input);
		}
	}
}

