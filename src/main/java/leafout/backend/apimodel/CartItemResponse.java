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
    String itemId;
    double price;
    double rating;
    Population population;
    int units;
}
