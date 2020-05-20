package leafout.backend.model;


import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Cart {
    @Id
    private String user;
    //private List<Ticket> tickets;
    private Map<String,CartItem> items;
}
