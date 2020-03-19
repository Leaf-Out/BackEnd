package leafout.backend.apimodel;

import leafout.backend.model.Feedback;
import lombok.*;

@Builder
@Getter
@Setter
public class UserRequest {

    private String name;

    private String email;

    private String password;

    private String phone;

    private Feedback feedback;

}
