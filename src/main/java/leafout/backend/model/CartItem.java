package leafout.backend.model;

import leafout.backend.apimodel.PayTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItem {
    Pay item;
    Population population;
    PayTypes type;
}
