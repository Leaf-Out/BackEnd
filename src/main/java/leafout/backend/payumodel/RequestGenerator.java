package leafout.backend.payumodel;

import leafout.backend.model.Purchase;
import leafout.backend.model.Refund;
import leafout.backend.model.Ticket;
import leafout.backend.model.Transaction;
import leafout.backend.model.User;

import java.util.UUID;

/**
 * This class generates the request objects to be sent to payment platform as json
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public class RequestGenerator {

    /**
     * This method generates a request object to make a payment on the payment platform
     *
     * @param purchase Purchase object with all needed data to create a payment request
     * @param user User making the payment
     * @return PayRequest object with all the payment information
     */
    public static PayRequest generatePayRequest(final Purchase purchase,
                                          final User user) {

        return PayRequest.builder()
                .command("SUBMIT_TRANSACTION")
                .language("es")
                .merchant(generateMerchant())
                .transaction(generateTransaction(purchase, user))
                .test(false)
                .build();
    }

    /**
     * This method generates a request object to make a transaction refund on the payment platform
     *
     * @param refund Refund object with all data needed to make a refund
     * @return RefundRequest object with all the transaction refund information
     */
    public static RefundRequest generateRefundRequest(Refund refund) {
        return RefundRequest.builder()
                .command("SUBMIT_TRANSACTION")
                .language("es")
                .merchant(generateMerchant())
                .test(false)
                .transaction(generateRefundTransaction(refund))
                .build();
    }

    private static Details generateDetails(Transaction transaction) {
        return Details.builder()
            .orderId(transaction.getOrderId())
            .build();
    }

    private static RefundTransaction generateRefundTransaction(Refund refund) {
        return RefundTransaction.builder()
                .parentTransactionId(refund.getTransactionId().toString())
                .reason(refund.getReason())
                .type("REFUND")
                .order(RefundOrder.builder().id(refund.getOrderId()).build())
                .build();
    }

    public static PayuTransaction generateTransaction(final Purchase purchase,
                                                      final User user) {
        return PayuTransaction.builder()
                .creditCard(generateCreditCard(purchase))
                .extraParameters(generateExtraParameters())
                .order(generateOrder(purchase.getTicket()))
                .paymentMethod(purchase.getPaymentMethod().toString())
                .payer(generatePayer(user,purchase))
                .type("AUTHORIZATION_AND_CAPTURE")
                .build();
    }

    public static ExtraParameters generateExtraParameters() {
        return ExtraParameters.builder()
                .iNSTALLMENTSNUMBER(1L)
                .build();
    }

    public static Payer generatePayer(final User user, final Purchase purchase) {
        return Payer.builder()
                .contactPhone(user.getPhone())
                .dniNumber(purchase.getDni())
                .emailAddress(user.getEmail())
                .fullName(user.getName())
                .merchantPayerId(user.getId().toString())
                .build();
    }

    public static Order generateOrder(final Ticket ticket) {
        return Order.builder()
                .accountId("512321")
                .additionalValues(generateAdditionalValues(ticket.getTotalPrice()))
                .description("payment test")
                .language("es")
                .referenceCode(UUID.randomUUID().toString())
                .build();
    }

    public static AdditionalValues generateAdditionalValues(double price) {
        return AdditionalValues.builder()
                .tXVALUE(TXVALUE.builder().value((long) (price)).currency("COP").build())
                .build();
    }

    public static CreditCard generateCreditCard(final Purchase purchase) {
        return CreditCard.builder()
                .expirationDate(purchase.getExpirationDate())
                .name(purchase.getName())
                .number(purchase.getCardNumber())
                .securityCode(purchase.getSecurityCode())
                .build();
    }

    private static Merchant generateMerchant() {
        return Merchant.builder()
                .apiKey("4Vj8eK4rloUd272L48hsrarnUA")
                .apiLogin("pRRXKOl8ikMmt9u")
                .build();
    }
}
