package leafout.backend.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import leafout.backend.model.Activity;
import leafout.backend.model.Feedback;
import leafout.backend.model.Population;
import leafout.backend.model.Tag;
import lombok.*;

import java.util.List;
import java.util.Map;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("PlanResponse")
public class PlanResponse {
    private String id;
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
    private Map<Population,Double > prices;

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

    List<ActivityResponse> activitiesList;

    String activityDescription;

    String parkName;

    PayRequest type;
}
