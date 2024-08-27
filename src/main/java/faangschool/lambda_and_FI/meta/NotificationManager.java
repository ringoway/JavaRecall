package faangschool.lambda_and_FI.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> identification = new HashMap<>();
    public void registerHandler (String type, Consumer<Notification> notificationConsumer) {
        identification.put(type, notificationConsumer);
    }
    public void sendNotification (Notification notification) {
        Consumer<Notification> notificationConsumer = identification.get(notification.getType());
        notificationConsumer.accept(notification);
    }
}
