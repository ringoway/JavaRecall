package faangschool.lambda_and_FI.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Consumer<Email> processing, Function<Email, String> transformation, Predicate<Email> filter) {
        for (Email email : emailList) {
            processing.accept(email);
            transformation.apply(email);
            filter.test(email);
        }
    }
}
