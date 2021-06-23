package org.example.school.infrastructure.Cipher;

import org.example.school.domain.student.services.PasswordCipherStrategy;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordCipherMD5 implements PasswordCipherStrategy {
    @Override
    public String parse(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte aByte : bytes) {
                stringBuilder.append(aByte);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Can't execute password parse");
        }
    }

    @Override
    public boolean correspondsTo(String password, String encryptedPassword) {
        return encryptedPassword.equals(parse(password));
    }
}
