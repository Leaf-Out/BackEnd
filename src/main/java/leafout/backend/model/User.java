package leafout.backend.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


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
@Document(collection = "Users")
@JsonTypeName("user")
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
