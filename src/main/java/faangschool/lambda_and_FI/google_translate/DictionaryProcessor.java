package faangschool.lambda_and_FI.google_translate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String, String> consumer) {
        consumer.accept(word, translate);
    }
 }
