package leafout.backend.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Map;

/**
 * This class represents a payable item
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "typ")
@JsonSubTypes({
		@JsonSubTypes.Type(value = Park.class, name = "Park"),
		@JsonSubTypes.Type(value = Plan.class, name = "Plan"),
		@JsonSubTypes.Type(value = Activity.class, name = "Activity"),
})
@Getter
@Setter
@AllArgsConstructor
public abstract class Pay {

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
	protected Map<Population, Double> prices;

	/**
	 * Key words that represent the item
	 */
	protected List<Tag> tags;

	/**
	 * Reviews given by the users about the item
	 */
	protected Feedback feedback;


}
