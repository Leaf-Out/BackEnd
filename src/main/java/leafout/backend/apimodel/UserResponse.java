package leafout.backend.apimodel;

import leafout.backend.model.Feedback;
import leafout.backend.model.Ticket;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * This class represent an User for the client.
 *
 * @author <a href=sergio.ruiz-p@mail.escuelaing.edu.co> Sergio Hernando Ruiz Paez </a>
 * @since 0.0.1
 */
@Builder
@Getter
public class UserResponse {

    private String id;

    /**
     * User's name
     */
    private String name;

    /**
     * User's email
     */
    private String email;

    /**
     * Feedback that User write
     */
    private Feedback feedback;

    /**
     * User's shoppingCart with it's tickets.
     */
    private List<Ticket> shoppingCart;

}
