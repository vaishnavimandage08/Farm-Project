package com.solvd.farm.fileOpeartions;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class UniqueWordCounter {
    public static void main(String[] args) throws IOException {
        // Read the input text file from the resources folder
        try {
            File inputFile = new File("src/main/resources/input.txt");
            String inputText = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);

            // Split the input text into words using whitespace as the delimiter
            String[] words = StringUtils.replace(inputText,"[^a-zA-Z ]", "").toLowerCase().split("\\s+");

            // Count the number of unique words
            Set<String> uniqueWords = new HashSet<>();
            for (String word : words) {
                uniqueWords.add(word);
            }
            int numUniqueWords = uniqueWords.size();

            // Write the result to a new text file in the resources folder
            File outputFile = new File("src/main/resources/output.txt");
            String outputText = "Number of unique words: " + numUniqueWords;
            FileUtils.writeStringToFile(outputFile, outputText, StandardCharsets.UTF_8);

            System.out.println("Finished counting unique words. Result written to output.txt");

        }
        catch(IOException e){
            e.getMessage();
        }
    }
}
