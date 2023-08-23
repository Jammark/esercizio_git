package com.esercizio7_spring;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import jakarta.persistence.AttributeConverter;

public class PasswordConverter implements AttributeConverter<String, String> {

	private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
	private static final byte[] KEY = "mysupersecretprova ssupersecret4".getBytes();

	@Override
	public String convertToDatabaseColumn(String attribute) {
		Key key = new SecretKeySpec(KEY, "AES");
		try {
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.ENCRYPT_MODE, key);
			return Base64.getEncoder().encodeToString(c.doFinal(attribute.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		Key key = new SecretKeySpec(KEY, "AES");
		try {
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.DECRYPT_MODE, key);
			return new String(c.doFinal(Base64.getDecoder().decode(dbData)));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
