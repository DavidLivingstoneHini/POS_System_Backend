package com.kamakz.kamakzbackend.util;

import java.io.Serial;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HashPassword implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public String encrypt(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passByte = pass.getBytes(StandardCharsets.UTF_8); // Ensure consistent character encoding
            md.reset();
            byte[] digested = md.digest(passByte);
            StringBuilder sb = new StringBuilder();
            for (byte b : digested) {
                sb.append(String.format("%02x", b)); // Ensure two-digit hex values
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error hashing passwords: " + e.getLocalizedMessage());
        }
        return null;
    }

    public String encryptSha256(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pass.getBytes(StandardCharsets.UTF_8)); // Ensure consistent character encoding
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b)); // Ensure two-digit hex values
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HashPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean matches(String rawPassword, String hashedPassword) {
        return encrypt(rawPassword).equals(hashedPassword);
    }
}
