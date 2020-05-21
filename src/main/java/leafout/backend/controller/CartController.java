package leafout.backend.controller;

import leafout.backend.apimodel.CartItemResponse;
import leafout.backend.apimodel.CartPayRequest;
import leafout.backend.model.CartItem;
import leafout.backend.model.exception.ActivityException;
import leafout.backend.model.exception.ParkException;
import leafout.backend.model.Pay;
import leafout.backend.model.exception.NoUserFoundException;
import leafout.backend.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carts")
public class CartController {

    /**
     * Injected instance of shopping cart service
     */
    @Autowired
    ShoppingCartService cartService;

    @GetMapping("/{id}")
    public ResponseEntity<List<CartItemResponse>> get(final @PathVariable("id") String id) {
        List<CartItemResponse> cart = mapItems(cartService.getCart(id).getItems());
        final ResponseEntity<List<CartItemResponse>> response = new ResponseEntity(cart, HttpStatus.OK);
        return response;
    }

    @PostMapping("/{id}/items")
    public ResponseEntity<?> add(@PathVariable("id") String userEmail, @RequestBody List<CartPayRequest> payables) throws NoUserFoundException, ParkException, ActivityException {
        for (CartPayRequest payable:
             payables ) {
            cartService.add(userEmail, payable.getItemId(),payable.getType(), payable.getPopulation() );
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> clear(final @PathVariable("id") String user) {
        cartService.clear(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/items/{item}")
    public ResponseEntity<Pay> removeItem(final @PathVariable("id") String id, final @PathVariable("item") String pay) {
        cartService.remove(id, pay);
        return new ResponseEntity(HttpStatus.OK);
    }

    public List<CartItemResponse> mapItems(Map<String,CartItem> payables) {
        final List<CartItemResponse> items = new ArrayList<>();
        for (Map.Entry<String, CartItem> payable : payables.entrySet()) {
            CartItemResponse newItem = CartItemResponse.builder()
                    .itemId(payable.getValue().getItem().getId())
                    .population(payable.getValue().getPopulation())
                    .price(payable.getValue().getItem().getPrices().get(payable.getValue().getPopulation()))
                    .rating(payable.getValue().getItem().getFeedback().getRating())
                    .type(payable.getValue().getType())
                    .units(payable.getValue().getUnits())
                    .build();

            items.add(newItem);
        }
        return items;
    }
}
