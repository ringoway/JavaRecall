package faangschool.lambda_and_FI.gmail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Привет, жопа жопа жопа как дела?", false),
                new Email("Письмо 3", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );


        Consumer<Email> processing = email -> {
            String important = email.isImportant() ? "Важное" : "Не важное";
            System.out.println("Письмо обработано:" + " Заголовок: " + email.getSubject() + ", " + "Текст: " + email.getBody() + ". " + important);
        };

        Function<Email, String> transformation = email -> {
            email.setBody(email.getBody().toUpperCase(Locale.forLanguageTag("ru")));
            return email.getBody();
        };

        Function<Email, String> censure = email -> {
            String body = email.getBody().replace("жопа", "****");
            email.setBody(body);
            return body;
        };

        Predicate<Email> filter = email -> email.isImportant();


        emailProcessor.processEmails(emails, processing, censure, filter);
        System.out.println();
        emailProcessor.processEmails(emails, processing, transformation, filter);
    }
}
