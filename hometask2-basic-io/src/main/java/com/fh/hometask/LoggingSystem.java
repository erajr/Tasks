package com.fh.hometask;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class LoggingSystem {
    static DateTimeFormatter formatWholeDate = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
    
    // Using Character Stream to Create log file and append logs in that file
    public static void log(Level level, String className, String msg){
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("bufferedlog.txt", true)))) {
            writer.println(formatWholeDate.format(LocalDateTime.now()) + " --- " + className + " --- " + level + ": " + msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(msg);
    }

    // Using Byte Stream to read logs from the given file
    public static void readFromLogFile(String logFileName) {
        try(FileInputStream inputStream = new FileInputStream(logFileName)) {
            StringBuilder line = new StringBuilder();
            int byteInfo;
            while((byteInfo = inputStream.read()) != -1) {
                char character = (char) byteInfo;
                if (character == '\n') {
                    System.out.println(line.toString());
                    line = new StringBuilder();
                } else {
                    line.append(character);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Using Byte Stream to read logs of a file (with a given line number) 
    public static void readFromLogFileWithLine(String logFileName, int lineNumber) {
        try(FileInputStream inputStream = new FileInputStream(logFileName)) {
            StringBuilder line = new StringBuilder();
            int byteInfo;
            int fileLine = 1;
            while(fileLine < lineNumber && (byteInfo = inputStream.read()) != -1) {
                char character = (char) byteInfo;
                if (character == '\n') {
                    fileLine++;
                }
            }

            if(fileLine == lineNumber) {
                while((byteInfo = inputStream.read()) != -1) {
                    char character = (char) byteInfo;
                    if (character == '\n') {
                        System.out.println("Log at line " + lineNumber + ": " + line.toString());
                        break;
                    } else {
                        line.append(character);
                    }
                }
            } else {
                System.out.println("Line not found in the given file.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete the log file
    public static void deleteLogFile(String fileName) {
        Path path = Paths.get(System.getProperty("user.dir"), fileName);
        try {
            if(path.toFile().exists()) {
                Files.deleteIfExists(path);
                System.out.println("File " + fileName + " deleted successfully");
            } else {
                System.out.println("File " + fileName + " does not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Move the log file(s)
    public static void moveLogFile(String fileName, String destinationFolder) {
        Path source = Paths.get(System.getProperty("user.dir"), fileName);
        Path destination = Paths.get(System.getProperty("user.dir"), destinationFolder);
        try {
            Files.createDirectories(destination);
            Path destinationFilePath = destination.resolve(source.getFileName());
            if(destinationFilePath.toFile().exists()) {
                System.out.println("File already existed. Overwriting...");
                destinationFilePath.toFile().delete();
            }
            Files.move(source, destinationFilePath);
            System.out.println("File moved from " + source + " to " + destinationFilePath);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Archive the log file(s)
    public static void archiveLogFile(String fileName) {
        Path filePath = Paths.get(System.getProperty("user.dir"), fileName);
        Path zipFilePath = Paths.get(System.getProperty("user.dir"), fileName + ".zip");
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath.toFile()));
            FileInputStream fos = new FileInputStream(filePath.toFile())) {
            ZipEntry entry = new ZipEntry(fileName);
            zos.putNextEntry(entry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fos.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }
            zos.closeEntry();
            System.out.println("Log file archived successfully to: " + zipFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
