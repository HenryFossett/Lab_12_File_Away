import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lab_12_File_Away {
    public static void main(String[] args) {
        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a Text File");

        // Show the file chooser dialog
        int result = fileChooser.showOpenDialog(null);

        // Check if the user selected a file
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            java.io.File selectedFile = fileChooser.getSelectedFile();

            // Process the selected file
            processFile(selectedFile);
        } else {
            System.out.println("No file selected. Exiting program.");
        }
    }

    private static void processFile(java.io.File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // Variables to store summary information
            int lineCount = 0;
            int wordCount = 0;
            int characterCount = 0;

            // Read the file line by line
            String line;
            while ((line = reader.readLine()) != null) {
                // Update counters
                lineCount++;
                wordCount += countWords(line);
                characterCount += line.length();
            }

            // Print summary report
            System.out.println("Summary Report:");
            System.out.println("File Name: " + file.getName());
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + characterCount);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    private static int countWords(String line) {
        // Simple word count implementation (may not cover all cases)
        String[] words = line.split("\\s+");
        return words.length;
    }
}
