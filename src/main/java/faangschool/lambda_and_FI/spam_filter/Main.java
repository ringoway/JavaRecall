package faangschool.lambda_and_FI.spam_filter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        String[] messages = {"Hello!", "It's spam!", "Wassup? =D", "Long message without спама and emoji"};

        MessageFilter spamFilter = message -> !message.toLowerCase().matches(".*\\bspam\\b.*");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("=D");

        List<MessageFilter> listFilters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, listFilters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
