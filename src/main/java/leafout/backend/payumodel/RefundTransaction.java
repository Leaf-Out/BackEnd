package leafout.backend.payumodel;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@Getter
@Builder
public class RefundTransaction {
    @Expose
    private String type;
    @Expose
    private String reason;
    @Expose
    private String parentTransactionId;
    @Expose
    private RefundOrder order;
}
