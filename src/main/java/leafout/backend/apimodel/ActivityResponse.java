package leafout.backend.apimodel;

import com.fasterxml.jackson.annotation.JsonTypeName;
import leafout.backend.model.Feedback;
import leafout.backend.model.Population;
import leafout.backend.model.Tag;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("ActivityResponse")
public class ActivityResponse {

    /**
     * ID of the payable item
     */
    @Id
    protected String id;

    /**
     * Name of the payable item
     */
    protected String name;

    /**
     * Description of the payable item
     */
    protected String description;

    /**
     * Price of the item depending on the population segment
     */
    protected Map<Population,Double > prices;

    /**
     * Key words that represent the item
     */
    protected List<Tag> tags;

    /**
     * Reviews given by the users about the item
     */
    protected Feedback feedback;

    private String parkName;

    private String planName;

    PayRequest type;
}
