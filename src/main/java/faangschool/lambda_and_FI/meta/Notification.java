package faangschool.lambda_and_FI.meta;

import java.util.Objects;

public class Notification {
    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    private final String type;
    private final String message;

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) return false;
        if (this == obj) return true;
        Notification notification = (Notification) obj;
        return Objects.equals(type, notification.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
