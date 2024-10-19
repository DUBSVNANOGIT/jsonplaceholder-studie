package records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Todos(Long userId,
                    Long id,
                    String title,
                    Boolean completed) {
}
