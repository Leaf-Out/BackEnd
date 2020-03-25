package leafout.backend.controller;

import leafout.backend.model.Cart;
import leafout.backend.model.Pay;
import leafout.backend.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {

    /**
     * Injected instance of shopping cart service
     */
    @Autowired
    ShoppingCartService cartService;

    @GetMapping()
    public ResponseEntity<Cart> get() {
        final ResponseEntity<Cart> response = new ResponseEntity(cartService.getCart(), HttpStatus.OK);
        return response;
    }

    @GetMapping("/{id")
    public ResponseEntity<Cart> getByID(final @PathVariable UUID id) {
        //TODO
        return null;
    }

    @PostMapping()
    public ResponseEntity<Pay> add(@RequestBody Pay payable) {
        //TODO
        return null;
    }

    @PutMapping()
    public ResponseEntity<Pay> update(final @RequestBody Pay payable) {
        //TODO
        return null;
    }

    @DeleteMapping()
    public ResponseEntity<Pay> clear() {
        //TODO
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pay> removeItem(final @PathVariable("id") UUID Pay) {
        //TODO
        return null;
    }
}
