package leafout.backend.model;


import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Cart {
    private String Id;
    private List<CartItem> items;
}
