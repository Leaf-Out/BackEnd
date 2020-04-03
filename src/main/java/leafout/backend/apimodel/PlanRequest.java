package leafout.backend.apimodel;

import leafout.backend.model.Activity;
import leafout.backend.model.Feedback;
import leafout.backend.model.Population;
import leafout.backend.model.Tag;
import lombok.*;

import java.util.List;
import java.util.Map;


/**
 * This class represent the plan for the client
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanRequest {


    /**
     * Name of the payable Plan
     */
    private String name;

    /**
     * Description of the payable Plan
     */
    private String description;

    /**
     * Price of the Plan depending on the population segment
     */
    private Map<Population, Double> prices;

    /**
     * Key words that represent the Plan
     */
    private List<Tag> tags;

    /**
     * Reviews given by the users about the Plan
     */
    private Feedback feedback;
    /**
     * List of activities of a Plan
     */
    List<Activity> activitiesList;
}
