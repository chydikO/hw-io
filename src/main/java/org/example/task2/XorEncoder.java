package org.example.task2;

import java.util.Arrays;

public class XorEncoder implements EncryptionAlgorithm {
    private final byte key;

    public XorEncoder(byte key) {
        this.key = key;
    }

    public byte[] encrypt(byte[] bytes) {
        byte[] encoded = Arrays.copyOf(bytes, bytes.length);
        for (int i = 0; i < encoded.length; i++) {
            encoded[i] ^= key;
        }
        return encoded;
    }

    public byte[] decrypt(byte[] bytes) {
        return encrypt(bytes);
    }

    @Override
    public byte encrypt(byte data) {
        return (byte)(data ^ key);
    }

    @Override
    public byte decrypt(byte encryptedData) {
        return encrypt(encryptedData);
    }

}
