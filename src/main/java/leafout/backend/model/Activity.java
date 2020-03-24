package leafout.backend.model;


import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
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

@Document
@Builder
@JsonTypeName("Plan")
public class Activity extends Pay{
	//TODO implement
    @Builder
    public Activity(UUID id, String name, String description, Map< Population,Double > prices, List<Tag> tags, Feedback feedback) {
        super(id,name,description,prices,tags,feedback);

    }
}
