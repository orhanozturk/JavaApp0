package com.orhn.app.io.file.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.orhn.util.console.CommandLineUtil.checkLengthEquals;
import static com.orhn.util.console.Console.*;
import static com.orhn.util.console.Console.writeErrLine;

public class ReadBytesApp {
    public static void run(String[] args)
    {
        checkLengthEquals(1, args.length, "wrong number of arguments");

        try (FileInputStream fis = new FileInputStream(args[0])) {
            int b;

            while ((b = fis.read()) != -1) {
                byte val = (byte)b;
                write("%d ", val);
            }

            writeLine();
        }
        catch (FileNotFoundException ignore) {
            writeErrLine("%s not found", args[0]);
        }
        catch (IOException ex) {
            writeErrLine("IO error occurred:%s",ex.getMessage());
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