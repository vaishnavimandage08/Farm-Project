package com.solvd.farm.fileOpeartions;

import com.solvd.farm.exception.NullValueException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
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

            logger.info("Finished counting unique words. Result written to output.txt");

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
