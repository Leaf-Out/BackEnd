package leafout.backend.payumodel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

@Generated("net.hexar.json2pojo")
@Getter
@Builder
public class PayuTransaction {

    @Expose
    private CreditCard creditCard;
    @Expose
    private ExtraParameters extraParameters;
    @Expose
    private Order order;
    @Expose
    private Payer payer;
    @Expose
    private String paymentMethod;
    @Expose
    private String type;
}
