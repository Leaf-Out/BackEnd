package leafout.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

/**
 * This class represents an user in the business
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collation = "Users")
public class User {

	/**
	 * ID of the user in the business
	 */
	@Id
	private String id;

	/**
	 * Name of the user
	 */
	private String name;

	/**
	 * Email of the user
	 */
	private String email;

	/**
	 * Hashed password of the user
	 */
	private String password;

	/**
	 * Phone number of the user
	 */
	private String phone;

	/**
	 * Shopping cart of the user
	 */
	private List<Ticket> shoppingCart;

	/**
	 * Reviews given by the user
	 */
	private Feedback givenFeedback;

	/**
	 * Role of the user
	 */
	private String role;

}
