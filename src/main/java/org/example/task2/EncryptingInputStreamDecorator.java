package org.example.task2;

import java.io.IOException;
import java.io.InputStream;

public class EncryptingInputStreamDecorator extends InputStream {
    private final InputStream in;
    private final EncryptionAlgorithm encryptionAlgorithm;

    public EncryptingInputStreamDecorator(InputStream in, EncryptionAlgorithm encryptionAlgorithm) {
        this.in = in;
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    @Override
    public int read() throws IOException {
        int b = in.read();
        if (b != -1) {
            // Encrypt the byte using the encryption algorithm
            b = encryptionAlgorithm.encrypt((byte) b);
        }
        return b;
    }

    @Override
    public void close() throws IOException {
        in.close();
    }
}
