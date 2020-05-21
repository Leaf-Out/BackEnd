package leafout.backend.apimodel;

import leafout.backend.model.Population;
import lombok.Data;

@Data
public class CartPayRequest {
    String itemId;
    PayTypes type;
    Population population;
}
