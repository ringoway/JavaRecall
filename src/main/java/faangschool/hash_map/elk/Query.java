package faangschool.hash_map.elk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Query {
    private int id;
    private String content;

    private LocalDateTime timestamp;

    @Override
    public String toString() {
        return "Query{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
