package leafout.backend.payumodel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

/**
 * This contains all information needed to send a json payment request to the payment platform
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Generated("net.hexar.json2pojo")
@Getter
@Builder
public class PayRequest {

    @Expose
    private String command;
    @Expose
    private String language;
    @Expose
    private Merchant merchant;
    @Expose
    private Boolean test;
    @Expose
    private PayuTransaction transaction;
}
