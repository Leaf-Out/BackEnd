package eci.ieti.leafout.backEnd.controller;

import eci.ieti.leafout.backEnd.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * This interface offers all payment API endpoints
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@RestController
@RequestMapping("/payments")
public class PaymentsController {

    /**
     * Injected payments service instance
     */
    @Autowired
    private PaymentsService paymentServices;

    @GetMapping
    public ResponseEntity<?> getAllTransactions() {
        return null;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getTransactionsByUserId(@PathVariable("id") UUID user) {
        return null;
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable("id") UUID transaction) {
        return null;
    }

    @PostMapping("/pay/user/{id}")
    public ResponseEntity<?> pay(@PathVariable("id") UUID user) {
        return null;
    }

    @PostMapping("/refund")
    public ResponseEntity<?> refund() {
        return null;
    }
}
