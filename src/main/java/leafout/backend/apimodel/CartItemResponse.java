package leafout.backend.apimodel;

import leafout.backend.model.Population;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CartItemResponse {
    PayTypes type;
    String id;
    double price;
    double rating;
    Population population;
}
