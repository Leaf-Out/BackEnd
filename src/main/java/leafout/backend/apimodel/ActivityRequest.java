package leafout.backend.apimodel;


import leafout.backend.model.Feedback;
import leafout.backend.model.Population;
import leafout.backend.model.Tag;
import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityRequest {

    /**
     * ID of the payable item
     */
    private UUID id;

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
