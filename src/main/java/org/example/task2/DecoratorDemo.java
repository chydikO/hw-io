package org.example.task2;

import java.io.*;

public class DecoratorDemo {
    public static final String SEP = System.getProperty("file.separator");
    public static final String FILE_DIR = System.getProperty("user.dir") + SEP + "files";

    public static void main(String[] args) {
        // Пример использования декоратора на шифрование
        try (
                InputStream fileInputStream = new FileInputStream(FILE_DIR + SEP + "input.txt");
                OutputStream fileOutputStream = new FileOutputStream(FILE_DIR + SEP + "outputEncrypt.txt");) {

            EncryptionAlgorithm encryptionAlgorithm = new XorEncoder((byte) 15);
            try (
                    InputStream encryptedInputStream = new EncryptingInputStreamDecorator(fileInputStream, encryptionAlgorithm);
                    ) {

                int data;
                while ((data = encryptedInputStream.read()) != -1) {
                    fileOutputStream.write(data);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Пример использования декоратора на дешифрование
        try (
                InputStream fileInputStream = new FileInputStream(FILE_DIR + SEP + "outputEncrypt.txt");
                OutputStream fileOutputStream = new FileOutputStream(FILE_DIR + SEP + "outputDecrypt.txt");) {

            EncryptionAlgorithm encryptionAlgorithm = new XorEncoder((byte) 15);
            try (OutputStream decryptedOutputStream = new DecryptingOutputStreamDecorator(fileOutputStream, encryptionAlgorithm);) {

                int data;
                while ((data = fileInputStream.read()) != -1) {
                    decryptedOutputStream.write(data);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
