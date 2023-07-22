package org.example.task2;

public interface EncryptionAlgorithm {
    byte[] encrypt(byte[] data);
    byte[] decrypt(byte[] encryptedData);

    byte encrypt(byte data);
    byte decrypt(byte encryptedData);
}
