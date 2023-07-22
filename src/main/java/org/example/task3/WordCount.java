package org.example.task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * 3. Створіть програму, яка зчитує текстовий файл та виконує підрахунок кількості слів у ньому.
 * Вивести статистику 10 найбільш поширених слів довжиною від 3 літер (не враховувати великі/маленькі літекри)
 */
public class WordCount {
    public static final String SEP = System.getProperty("file.separator");
    public static final String FILE_DIR = System.getProperty("user.dir") + SEP + "files";

    public static void main(String[] args) {
        try {
            File file = new File(FILE_DIR + SEP + "text.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            Map<String, Integer> wordCountMap = new HashMap<>();

            String line;
            int wordLength = 3;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");

                for (String word : words) {
                    if (word.length() >= wordLength) {
                        String lowercaseWord = word.toLowerCase();
                        wordCountMap.put(lowercaseWord, wordCountMap.getOrDefault(lowercaseWord, 0) + 1);
                    }
                }
            }

            List<Map.Entry<String, Integer>> wordCountList = new ArrayList<>(wordCountMap.entrySet());
            wordCountList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            int count = 0;
            for (Map.Entry<String, Integer> entry : wordCountList) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                if (++count >= 10) {
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}