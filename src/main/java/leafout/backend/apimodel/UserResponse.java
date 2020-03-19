package leafout.backend.apimodel;

import leafout.backend.model.Feedback;
import leafout.backend.model.Ticket;
import lombok.*;

import java.util.List;

@Builder
@Getter
public class UserResponse {

    private String name;

    private String email;

    private String password;

    private Feedback feedback;

    private List<Ticket> shoppingCart;

}
