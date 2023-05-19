package com.solvd.farm.fileOpeartions;

import com.solvd.farm.exception.NullValueException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UniqueWordCounter {
    private static final Logger logger = LogManager.getLogger(UniqueWordCounter.class);
    public static void main(String[] args) throws NullValueException {
        // Read the input text file from the resources folder
        try {
            File inputFile = new File("src/main/resources/input.txt");
            String inputText = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);

            // Split the input text into words using whitespace as the delimiter
            String[] words = StringUtils.replace(inputText, "[^a-zA-Z ]", "").toLowerCase().split("\\s+");

            //Stores unique words from file
            HashMap<String, Integer> wordCounts = new HashMap<>();

            for (String word : words) {
                if (wordCounts.containsKey(word)) {
                    // If the word already exists in the map, increment its count
                    wordCounts.put(word, wordCounts.get(word) + 1);
                } else {
                    // If the word doesn't exist in the map, add it with a count of 1
                    wordCounts.put(word, 1);
                }
            }

                // Write the result to a new text file in the resources folder
                File outputFile = new File("src/main/resources/output.txt");
                StringBuilder outputText = new StringBuilder();
                for (String uniqueWord : wordCounts.keySet()) {
                    int count = wordCounts.get(uniqueWord);
                    outputText.append(uniqueWord).append(": ").append(count).append("\n");
                }
                FileUtils.writeStringToFile(outputFile, outputText.toString(), StandardCharsets.UTF_8);

                int numUniqueWords = wordCounts.size();
            logger.info("Finished counting unique words. Result written to output.txt");
            logger.info("Number of unique words: {}", numUniqueWords);
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
}
