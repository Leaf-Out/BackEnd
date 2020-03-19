package leafout.backend.payumodel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

@Generated("net.hexar.json2pojo")
@Getter
@Builder
public class Payer {

    @Expose
    private String contactPhone;
    @Expose
    private String dniNumber;
    @Expose
    private String emailAddress;
    @Expose
    private String fullName;
    @Expose
    private String merchantPayerId;
}