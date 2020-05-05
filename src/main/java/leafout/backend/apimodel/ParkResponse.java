package leafout.backend.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import leafout.backend.model.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("ParkResponse")
public class ParkResponse {

    private String id;
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
    private Map<Population, Double> prices;

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
    List<PlanResponse> planList;

    /**
     * List of activities of a park
     */

    List<ActivityResponse> activitiesList;

    Location location;
}
