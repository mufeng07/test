package com.mufeng.utils;

import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DataEncrypt {

	private static final int ITERATIONS = 1000;

	/***************************************************************************
	 * MD5加密方法
	 * 
	 * @param str
	 * @return
	 */
	public static String encrypt(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i & 0xff));
			}
			return buf.toString(); // 32位
			// return buf.toString().substring(8,24); //16位
		} catch (NoSuchAlgorithmException e) {
			return "";
		}
	}

	public static String checkSum(String checkStr) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");

		md.update(checkStr.getBytes("UTF-8"));
		byte b[] = md.digest();
		int i;
		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				buf.append("0");
			}
			buf.append(Integer.toHexString(i));
		}
		return buf.toString();
	}

	public static String encryptCheckSum(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			md.update(str.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			return buf.toString(); // 32位
			// return buf.toString().substring(8,24); //16位
		} catch (NoSuchAlgorithmException e) {
			return "";
		}
	}

	public static String pbeEncrypt(String password, String str) throws Exception {
		return pbeEncrypt(password, str.getBytes());
	}

	/****
	 * PBE算法加密，加入8位随机码,重复计算次数为1000
	 * 
	 * @param password
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String pbeEncrypt(String password, byte[] byteIn) throws Exception {
		// password = new String(password.getBytes("ISO8859-1"),"GBK");
		// 创建一个8位的盐
		byte[] salt = new byte[8];
		SecureRandom random = new SecureRandom();
		random.nextBytes(salt);

		// 使用传递进来的密码创建PBEKeySpec实例
		PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
		// 获取使用特定算法的密钥工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		// 使用密钥工厂根据PBEKeySpec创建密钥
		SecretKey key = keyFactory.generateSecret(keySpec);
		// 创建参数封装类PBEParameterSpec封装盐和重复计算次数这两个参数
		PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, ITERATIONS);
		// 创建使用特定算法的用来加密/解密的Cipher对象
		Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
		// 使用密钥和parameterSpec参数初始化
		cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
		// 加密数据
		byte[] encryptText = cipher.doFinal(byteIn);
		// 使用BASE64Encoder 对盐和加密后的原始数据进行编码
		// BASE64Encoder encoder = new BASE64Encoder();
		String saltStr = Base64Utils.encodeToString(salt); // Base64.encodeBase64String(salt);
		String encryptTextStr = Base64Utils.encodeToString(encryptText);// Base64.encodeBase64String(encryptText);
		return saltStr + encryptTextStr;
	}

	/****
	 * PBE算法解密，解加密时加入8位随机码的字符加密串,重复计算次数为1000
	 * 
	 * @param password
	 * @param text
	 * @return
	 * @throws Exception
	 */
	public static String pbeDecrypt(String password, String text) throws Exception {
		// password = new String(password.getBytes("ISO8859-1"),"GBK");
		// 首先将盐和加密后的原始数据分开
		String salt = text.substring(0, 12);
		String encryptText = text.substring(12, text.length());
		// 使用BASE64Decoder 解码盐和加密原始数据
		// BASE64Decoder decoder = new BASE64Decoder();
		// byte[] saltArray = decoder.decodeBuffer(salt);
		// byte[] encryptTextArray = decoder.decodeBuffer(encryptText);
		byte[] saltArray = Base64Utils.decodeFromString(salt);// Base64.decodeBase64(salt);
		byte[] encryptTextArray = Base64Utils.decodeFromString(encryptText);// Base64.decodeBase64(encryptText);

		// 使用传递进来的密码创建PBEKeySpec实例
		PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
		// 获取使用特定算法的密钥工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		// 使用密钥工厂根据PBEKeySpec创建密钥
		SecretKey key = keyFactory.generateSecret(keySpec);
		// 创建参数封装类PBEParameterSpec封装盐和重复计算次数这两个参数
		PBEParameterSpec parameterSpec = new PBEParameterSpec(saltArray, ITERATIONS);
		// 创建使用特定算法的用来加密/解密的Cipher对象
		Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
		// 使用密钥和parameterSpec参数初始化
		cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
		// 解密数据
		byte[] decryptText = cipher.doFinal(encryptTextArray);
		return new String(decryptText);
	}

	/****
	 * 文件内容通过PBE加密
	 * 
	 * @param password
	 * @param file
	 * @throws Exception
	 */
	public static void fileEncrypt(String password, File file) throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int fileLen = (int) file.length();
		if (fileLen > 0) {
			try {
				fis = new FileInputStream(file);
				byte[] byteIn = new byte[fileLen];
				for (int i = 0; i < file.length(); i++) {
					byteIn[i] = (byte) fis.read();
				}
				String encryptStr = pbeEncrypt(password, byteIn);
				String fileOut = file.getPath();
				fos = new FileOutputStream(fileOut);
				fos.write(encryptStr.getBytes());
				fos.flush();
			} catch (Exception e) {
				throw new Exception("file Encrypt throw an exception == " + e.toString());
			} finally {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			}
		}
	}

	/****
	 * 文件解密，通过password使用PBE算法进行解密操作
	 * 
	 * @param password
	 * @param file
	 * @throws Exception
	 */
	public static void fileDecrypt(String password, File file) throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int fileLen = (int) file.length();
		if (fileLen > 0) {
			try {
				fis = new FileInputStream(file);
				byte[] byteIn = new byte[fileLen];
				for (int i = 0; i < file.length(); i++) {
					byteIn[i] = (byte) fis.read();
				}
				String encryptStr = pbeDecrypt(password, new String(byteIn));
				String fileOut = file.getPath();
				fos = new FileOutputStream(fileOut);
				fos.write(encryptStr.getBytes());
				fos.flush();
			} catch (Exception e) {
				throw new Exception("file decrypt throw an exception == " + e.toString());
			} finally {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			}
		}
	}
}
