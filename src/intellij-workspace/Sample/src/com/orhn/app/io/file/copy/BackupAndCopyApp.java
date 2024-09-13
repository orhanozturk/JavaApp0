package com.orhn.app.io.file.copy;

import com.orhn.app.io.file.BackupAndCopy;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;

import static com.orhn.util.console.CommandLineUtil.checkLengthEquals;
import static com.orhn.util.console.Console.writeErrLine;

public class BackupAndCopyApp {
    private static void run(String [] args)
    {
        checkLengthEquals(2, args.length, "java org.csystem.app.io.file.copy.BackupAndCopyApp <src> <dest>");
        try{
            BackupAndCopy backupAndCopy = new BackupAndCopy(args[0], args[1]);
            backupAndCopy.copy("-bak");
        }
        catch (InvalidPathException ex){
            writeErrLine("Invalid path:%s", ex.getInput());
        }
        catch (NoSuchFileException ex){
            writeErrLine("Source file not found!...");
        }
        catch (IOException ex) {
            writeErrLine("IO problem occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            writeErrLine("Problem occurred:%s", ex.getMessage());
        }
    }

    public static void main(String [] args)
    {
        run(args);
    }
}
