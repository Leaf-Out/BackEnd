package leafout.backend.controller;

import leafout.backend.model.Cart;
import leafout.backend.model.Pay;
import leafout.backend.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody Pay payable) {
        cartService.add(payable);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> update(final @RequestBody Cart newCart) {
        cartService.update(newCart);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping()
    public ResponseEntity<Pay> clear() {
        cartService.clear();
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pay> removeItem(final @PathVariable("id") String pay) {
        cartService.remove(pay);
        return new ResponseEntity(HttpStatus.OK);
    }
}
