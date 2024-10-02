package com.orhn.app.io.file.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Random;

import static com.orhn.util.console.CommandLineUtil.checkLengthEquals;
import static com.orhn.util.console.Console.*;

public class AppendRandomDoublesApp {
    private static void writeFile(String path, int count, double min, double bound)
    {
        try (FileOutputStream fos = new FileOutputStream(path, true)) {
            Random random = new Random();

            for (int i = 0; i < count; ++i) {
                double val = random.nextDouble(min, bound);

                write("%f ", val);
                byte [] buf = ByteBuffer.allocate(Double.BYTES).putDouble(val).array();

                fos.write(buf);
            }

            writeLine();
        }
        catch (FileNotFoundException ignore) {
            writeErrLine("%s is directory", path);
        }
        catch (IOException ex) {
            writeErrLine("IO error occurred:%s",ex.getMessage());
        }
    }

    public static void run(String[] args)
    {
        checkLengthEquals(4, args.length, "wrong number of arguments");

        try {
            int count = Integer.parseInt(args[1]);
            double min = Double.parseDouble(args[2]);
            double bound = Double.parseDouble(args[3]);

            writeFile(args[0], count, min, bound);
        }
        catch (NumberFormatException ignore) {
            writeErrLine("Invalid count value!...");
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
