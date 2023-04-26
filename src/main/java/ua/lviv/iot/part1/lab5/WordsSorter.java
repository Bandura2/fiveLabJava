package ua.lviv.iot.part1.lab5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsSorter {

    public String sorterWords(final String stringThatSorting,
                              final String neededLetter) {

        List<String> result = new LinkedList<>();
        Map<Integer, List<String>> mapOfWords = new HashMap<>();

        Pattern patternForSplit = Pattern.compile("\\s+");
        Pattern pattern = Pattern.compile(neededLetter);

        String[] words = patternForSplit.split(stringThatSorting);

        for (String word : words) {

            Matcher matcher = pattern.matcher(word);
            int countOfLetterInWord = 0;

            while (matcher.find()) {
                countOfLetterInWord++;
            }

            if (!mapOfWords.containsKey(countOfLetterInWord)) {

                mapOfWords.put(countOfLetterInWord, new LinkedList<>());
                mapOfWords.get(countOfLetterInWord).add(word);
            } else {
                mapOfWords.get(countOfLetterInWord).add(word);

            }
        }

        for (List<String> list : mapOfWords.values()) {
            list.sort(String::compareTo);
            result.addAll(list);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String a = "a f re j gb ki bh jhf cd oiu";
        String b = "d";

        var sorter = new WordsSorter();

        System.out.println(sorter.sorterWords(a, b));
    }
}