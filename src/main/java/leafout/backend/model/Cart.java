package leafout.backend.model;


import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Cart {
    @Id
    private String user;
    //private List<Ticket> tickets;
    private List<CartItem> items;
}
