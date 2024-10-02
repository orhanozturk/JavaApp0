package com.orhn.app.io.file.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

import static com.orhn.util.console.CommandLineUtil.checkLengthEquals;
import static com.orhn.util.console.Console.*;

public class ReadIntsApp {
    private static void readFile(String path)
    {
        try (FileInputStream fis = new FileInputStream(path)) {
            byte [] data = new byte[Integer.BYTES];
            int n;

            while ((n = fis.read(data)) > 0) {
                if (n != Integer.BYTES)
                    throw new IOException("Invalid file format!...");

                int val = ByteBuffer.wrap(data).getInt();

                write("%d ", val);
            }

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
        checkLengthEquals(1, args.length, "wrong number of arguments");

        try  {
            readFile(args[0]);
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
