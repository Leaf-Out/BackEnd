package leafout.backend.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;


/**
 * This class represents a park
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Getter
@Setter
@Document(collection = "Parks")
@JsonTypeName("Park")
public class Park extends Pay {

    /**
     * List of plans of a park
     */
    List<Plan> planList;

    /**
     * List of activities of a park
     */
    List<Activity> activitiesList;


    Location location;


    @Builder
    public Park(String id, String name, String description, Map< Population,Double > prices, List<Tag> tags,Feedback feedback,List<Plan> planList, List<Activity> activitiesList,Location location) {
        super(id,name,description,prices,tags,feedback);
        this.planList = planList;
        this.activitiesList = activitiesList;
        this.location =location;
    }


}
