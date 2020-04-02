package leafout.backend.apimodel;


import com.fasterxml.jackson.annotation.JsonTypeName;
import leafout.backend.model.Feedback;
import leafout.backend.model.Population;
import leafout.backend.model.Tag;
import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * This class represent the activity for the client
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("ActivityRequest")
public class ActivityRequest {


    /**
     * Name of the payable item
     */
    private String name;

    /**
     * Description of the payable item
     */
    private String description;

    /**
     * Price of the item depending on the population segment
     */
    private Map<Population,Double > prices;

    /**
     * Key words that represent the item
     */
    private List<Tag> tags;

    /**
     * Reviews given by the users about the item
     */
    private Feedback feedback;
}
