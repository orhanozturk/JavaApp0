package com.orhn.app.io.file.copy;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static com.orhn.util.console.CommandLineUtil.checkLengthGreaterOrEqual;
import static com.orhn.util.console.Console.writeErrLine;
import static com.orhn.util.console.Console.writeLine;

public class CopyExistFilesApp {
    private static void copyFiles(Path dest, String [] args) throws IOException
    {
        for (int i = 1; i < args.length; i++) {
            Path path = Path.of(args[i]);

            if (Files.notExists(path)) {
                writeErrLine("'%s' not found", args[i]);
                continue;
            }

            Path destFilePath = dest.resolve(path.getFileName());

            if (Files.exists(destFilePath))
                writeLine("'%s' found and will be overwritten", destFilePath.getFileName());

            Files.copy(path, destFilePath, StandardCopyOption.REPLACE_EXISTING);
            writeLine("'%s' copied successfully", destFilePath.getFileName());
        }
    }

    private static void checkAndCopy(String [] args) throws IOException
    {
        try {
            copyFiles(Files.createDirectories(Path.of(args[0])), args);
        }
        catch (FileAlreadyExistsException ex) {
            writeErrLine("'%s' is not a directory", ex.getFile());
        }
    }

    public static void run(String[] args)
    {
        checkLengthGreaterOrEqual(2, args.length, "usage: java org.csystem.app.io.file.copy.CopyExistFilesApp <dest directory> <file path1> <file path2> ... <file pathN>");

        try {
            checkAndCopy(args);
        }
        catch (IOException ex) {
            writeErrLine("IO Problem occurred:%s", ex.getMessage());
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