package leafout.backend.payumodel;

/**
 * This class defines all possible response codes PayU payment platform can return
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public enum PayuTransactionState {

    APPROVED,
    DECLINED,
    ERROR,
    EXPIRED,
    PENDING,
    SUBMITTED

}
