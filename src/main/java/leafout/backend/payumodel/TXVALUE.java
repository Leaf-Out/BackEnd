package leafout.backend.payumodel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

@Generated("net.hexar.json2pojo")
@Getter
@Builder
public class TXVALUE {

    @Expose
    private String currency;
    @Expose
    private Long value;

}
