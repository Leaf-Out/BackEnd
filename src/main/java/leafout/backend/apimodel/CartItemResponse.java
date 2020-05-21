package leafout.backend.apimodel;

import leafout.backend.model.Feedback;
import leafout.backend.model.Pay;
import leafout.backend.model.Population;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CartItemResponse {
    PayTypes type;
    Pay pay;
    double price;
    Population population;
    int units;
}
