
package leafout.backend.payumodel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

@Generated("net.hexar.json2pojo")
@Getter
@Builder
public class Order {

    @Expose
    private String accountId;
    @Expose
    private AdditionalValues additionalValues;
    @Expose
    private String description;
    @Expose
    private String language;
    @Expose
    private String referenceCode;
}
