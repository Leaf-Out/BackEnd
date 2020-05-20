package leafout.backend.model;

import leafout.backend.apimodel.PayTypes;
import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CartItem {
    Pay item;
    Population population;
    int units;
    PayTypes type;
}
