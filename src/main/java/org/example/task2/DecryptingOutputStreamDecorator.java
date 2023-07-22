package org.example.task2;


import java.io.IOException;
import java.io.OutputStream;

public class DecryptingOutputStreamDecorator extends OutputStream {
    private final OutputStream out;
    private final EncryptionAlgorithm encryptionAlgorithm;

    public DecryptingOutputStreamDecorator(OutputStream out, EncryptionAlgorithm encryptionAlgorithm) {
        this.out = out;
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    @Override
    public void write(int b) throws IOException {
        // Decrypt the byte using the encryption algorithm
        b = encryptionAlgorithm.decrypt((byte) b);
        out.write(b);
    }

    @Override
    public void close() throws IOException {
        out.close();
    }
}
