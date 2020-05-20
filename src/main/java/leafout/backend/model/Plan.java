package leafout.backend.model;


import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * This class represents a plan
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */

@Getter
@Setter
@Document(collection = "Plans")
@JsonTypeName("Plan")
public class Plan extends Pay{
    /**
     * List of activities of a park
     */
    List<Activity> activitiesList;

    String activityDescription;

    String parkName;

    @Builder
    public Plan(String id,String activityDescription,String parkName, String name, String description, Map< Population,Double > prices, List<Tag> tags, Feedback feedback,List<Activity> activitiesList) {
        super(id,name,description,prices,tags,feedback);
        this.activitiesList = activitiesList;
        this.parkName = parkName;
        this.activityDescription= activityDescription;
    }

}
