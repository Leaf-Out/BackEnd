package leafout.backend.payumodel;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@Getter
@Builder
public class Details {
    @Expose
    private int orderId;
}
