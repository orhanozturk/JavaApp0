package com.orhn.app.io.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IOUtil {
    private IOUtil()
    {

    }

    public static void copy(InputStream inputStream, OutputStream outputStream, int blockSize) throws IOException
    {
        byte [] buf = new byte[blockSize];
        int result;

        while((result = inputStream.read(buf)) > 0)
            outputStream.write(buf, 0, result);
    }

    public static void copyAndClose(InputStream inputStream, OutputStream outputStream, int blockSize) throws IOException
    {
        try(inputStream ; outputStream) {
            copy(inputStream, outputStream, blockSize);
        }
    }
}
