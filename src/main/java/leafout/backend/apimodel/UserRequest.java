package leafout.backend.apimodel;

import leafout.backend.model.Feedback;
import lombok.*;

/**
 * This class contains all data needed to create a user request
 *
 * @author <a href=sergio.ruiz-p@mail.escuelaing.edu.co> Sergio Hernando Ruiz Paez </a>
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
public class UserRequest {

    /**
     * User's name
     */
    private String name;

    /**
     * User's email
     */
    private String email;

    /**
     * Password that the user want to register
     */
    private String password;

    /**
     * Phone that User want to register
     */
    private String phone;

    /**
     * Feedback that the user write in some Activities, Plans or Parks
     */
    private Feedback feedback;

}
