package leafout.backend.payumodel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Generated("net.hexar.json2pojo")
@Getter
@Builder
public class CreditCard {

    @Expose
    private String expirationDate;
    @Expose
    private String name;
    @Expose
    private String number;
    @Expose
    private String securityCode;
}