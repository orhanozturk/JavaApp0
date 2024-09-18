package com.orhn.app.io.file.copy;

import com.orhn.app.io.util.IOUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.orhn.util.console.CommandLineUtil.checkLengthEquals;
import static com.orhn.util.console.Console.writeErrLine;
import static com.orhn.util.console.Console.writeLine;

public class CopyFileViaBlockApp {
    private static void copy(String src, String dest, int blockSize)
    {
        try {
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);

            IOUtil.copy(fis, fos, blockSize);
        }
        catch (FileNotFoundException ignore) {
            writeErrLine("'%s' not found", src);
        }
        catch (IOException ex) {
            writeErrLine("IO Problem occurred:%s", ex.getMessage());
        }
    }

    public static void run(String[] args)
    {
        checkLengthEquals(3, args.length, "usage: java org.csystem.app.io.file.copy.CopyFileViaBlockApp <src> <dest> <block size>");

        try {
            copy(args[0], args[1], Integer.parseInt(args[2]));
            writeLine("File copied successfully");
        }
        catch (NumberFormatException ignore) {
            writeErrLine("Invalid block size format!...");
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
