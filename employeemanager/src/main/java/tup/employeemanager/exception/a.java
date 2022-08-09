package tup.employeemanager.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class a {

    private static void checkedExceptionWithThrows() throws FileNotFoundException {
        File file = new File("not_existing_file.txt");
        FileInputStream stream = new FileInputStream(file);
    }

    private static void checkedExceptionWithTryCatch() {
        File file = new File("not_existing_file.txt");
        try {
            FileInputStream stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void divideByZero() {
        int numerator = 1;
        int denominator = 0;
        int result = numerator / denominator;
    }

    private static String xxx() throws IncorrectFileNameException {
        String fileName = "kjhkjhkjh";

        if (!isCorrectFileName(fileName)) {
            throw new IncorrectFileNameException("Incorrect filename : " + fileName);
        }

        if (fileName == null || fileName.isEmpty()) {
            throw new NullOrEmptyException("The filename is null or empty.");
        }

        try (Scanner file = new Scanner(new File(fileName))) {
            if (file.hasNextLine())
                return file.nextLine();
        } catch (FileNotFoundException e) {
            // Logging, etc
        }

        try (Scanner file = new Scanner(new File(fileName))) {
            if (file.hasNextLine())
                return file.nextLine();
        } catch (FileNotFoundException e) {
            if (!isCorrectFileName(fileName)) {
                throw new IncorrectFileNameException("Incorrect filename : " + fileName);
            }
            // ...
        }

        try (Scanner file = new Scanner(new File(fileName))) {
            if (file.hasNextLine()) {
                return file.nextLine();
            }
        } catch (FileNotFoundException err) {
            if (!isCorrectFileName(fileName)) {
                throw new IncorrectFileNameException(
                        "Incorrect filename : " + fileName, err);
            }
            // ...
        }

try (Scanner file = new Scanner(new File(fileName))) {
    if (file.hasNextLine()) {
        return file.nextLine();
    } else {
        throw new IllegalArgumentException("Non readable file");
    }
} catch (FileNotFoundException err) {
    if (!isCorrectFileName(fileName)) {
        throw new IncorrectFileNameException(
                "Incorrect filename : " + fileName, err);
    }

    // ...
} catch (IllegalArgumentException err) {
    if (!containsExtension(fileName)) {
        throw new IncorrectFileExtensionException(
                "Filename does not contain extension : " + fileName, err);
    }

    // ...
}

        return fileName;
    }

    private static boolean containsExtension(String fileName) {
        return false;
    }

    private static boolean isCorrectFileName(String fileName) {
        return false;
    }

}
