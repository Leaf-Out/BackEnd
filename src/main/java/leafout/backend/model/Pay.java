package leafout.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * This class represents a payable item
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pay {

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
	private Map< Population,Double > prices;

	/**
	 * Key words that represent the item
	 */
	private List<Tag> tags;

	/**
	 * Reviews given by the users about the item
	 */
	private Feedback feedback;

}
