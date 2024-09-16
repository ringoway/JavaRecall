package faangschool.lambda_and_FI.google_translate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static Map<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> addWordToDictionary = (word, translate) -> dictionary.put(word, translate);

        dictionaryProcessor.processWord("Собака", "Dog", addWordToDictionary);
        dictionaryProcessor.processWord("Кошка", "Cat", addWordToDictionary);

        printAllWords();
    }

    public static void printAllWords() {
        for (Map.Entry<String, String> stringStringEntry : dictionary.entrySet()) {
            System.out.println("Word: " + stringStringEntry.getKey() + ", " + "Translate: " + stringStringEntry.getValue() + ".");
        }
    }
}
