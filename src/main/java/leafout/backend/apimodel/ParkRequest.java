package leafout.backend.apimodel;

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
public class ParkRequest {


    /**
     * Name of the Park item
     */
    private String name;

    /**
     * Description of the Park item
     */
    private String description;

    /**
     * Price of the Park depending on the population segment
     */
    private Map<Population,Double > prices;

    /**
     * Key words that represent the Park
     */
    private List<Tag> tags;

    /**
     * Reviews given by the users about the Park
     */
    private Feedback feedback;
    /**
     * List of plans of a park
     */
    List<Plan> planList;

    /**
     * List of activities of a park
     */
    List<Activity> activitiesList;
}
