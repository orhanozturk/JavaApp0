package com.orhn.app.io.file.input;

import com.orhn.util.console.Console;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.orhn.util.console.CommandLineUtil.checkLengthEquals;
import static com.orhn.util.console.Console.*;

public class ReadSkipNBytesApp {
    private static void writeBytes(byte[] data, int count)
    {
        for (int i = 0; i < count; ++i)
            write("%d ", data[i]);
    }

    private static void readFile(String path, int blockSize, int skip)
    {
        try (FileInputStream fis = new FileInputStream(path)) {
            long skipped = fis.skip(skip);

            Console.writeLine("%d bytes skipped", skipped);

            byte [] data = new byte[blockSize];
            int n;

            while ((n = fis.read(data)) > 0)
                writeBytes(data, n);

            writeLine();
        }
        catch (FileNotFoundException ignore) {
            writeErrLine("%s not found", path);
        }
        catch (IOException ex) {
            writeErrLine("IO error occurred:%s",ex.getMessage());
        }
    }

    public static void run(String[] args)
    {
        checkLengthEquals(3, args.length, "wrong number of arguments");

        try  {
            readFile(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        }
        catch (NumberFormatException ignore) {
            writeErrLine("Invalid block size value!...");
        }
        catch (Throwable ex) {
            writeErrLine("Problem occurred:%s", ex.getMessage());
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
