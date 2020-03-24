package leafout.backend.payumodel;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@Getter
@Builder
public class RefundRequest {

    @Expose
    private String command;
    @Expose
    private String language;
    @Expose
    private Merchant merchant;
    @Expose
    private Boolean test;
    @Expose
    private RefundTransaction transaction;

}
