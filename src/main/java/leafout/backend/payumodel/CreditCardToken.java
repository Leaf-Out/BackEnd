package leafout.backend.payumodel;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@Getter
@Builder
public class CreditCardToken {

    @Expose
    private String expirationDate;
    @Expose
    private String name;
    @Expose
    private String number;
    @Expose
    private String payerId;
    @Expose
    private String identificationNumber;
    @Expose
    private String paymentMethod;
}
