package faangschool.lambda_and_FI.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> map = new HashMap<>();
    public void registerHandler (String type, Consumer<Notification> notificationConsumer) {
        if (type == null && type.isEmpty()) {
            throw new IllegalArgumentException("Пустой тип оповещения");
        }
        map.put(type, notificationConsumer);
    }
    public void sendNotification (Notification notification) {
        Consumer<Notification> notificationConsumer = map.get(notification.getType());
        notificationConsumer.accept(notification);
    }
}
