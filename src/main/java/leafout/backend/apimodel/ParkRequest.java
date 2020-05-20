package leafout.backend.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import leafout.backend.model.*;
import lombok.*;


import java.util.List;
import java.util.Map;

/**
 * This class represent the park for the client
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("ParkRequest")
public class ParkRequest {


    /**
     * Name of the Park item
     */
    String name;

    /**
     * Description of the Park item
     */
    String description;

    /**
     * Price of the Park depending on the population segment
     */
    Map<Population,Double > prices;

    /**
     * Key words that represent the Park
     */
    List<Tag> tags;

    /**
     * Reviews given by the users about the Park
     */
    Feedback feedback;
    /**
     * List of plans of a park
     */
    List<PlanRequest> planList;

    /**
     * List of activities of a park
     */

    List<ActivityRequest> activitiesList;

    String planDescription;

    String activityDescription;


    Location location;
}
