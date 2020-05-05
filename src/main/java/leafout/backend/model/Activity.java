package leafout.backend.model;


import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * This class represents a Activity
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Getter
@Setter
@Document(collection = "Activities")
@JsonTypeName("Activity")
public class Activity extends Pay{

    @Builder
    public Activity(String id, String name, String description, Map< Population,Double > prices, List<Tag> tags, Feedback feedback) {
        super(id,name,description,prices,tags,feedback);
    }
}
