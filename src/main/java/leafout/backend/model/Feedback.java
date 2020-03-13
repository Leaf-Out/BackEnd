package leafout.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * This class represents the review given by the users about a payable item
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

	/**
	 * The comments made about a payable item
	 */
	private List<Comment> comments;

	/**
	 * The rating value given by the users
	 */
	private double rating;

}
