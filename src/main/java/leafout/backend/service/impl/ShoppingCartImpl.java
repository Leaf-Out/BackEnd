package leafout.backend.service.impl;

import leafout.backend.apimodel.PayTypes;
import leafout.backend.model.Cart;
import leafout.backend.model.CartItem;
import leafout.backend.model.Pay;
import leafout.backend.model.User;
import leafout.backend.model.exception.NoUserFoundException;
import leafout.backend.persistence.CartRespository;
import leafout.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ShoppingCartImpl implements ShoppingCartService {

    @Autowired
    CartRespository cartRepository;

    @Autowired
    UserService userService;

    @Autowired
    ParkService parkService;

    @Autowired
    PlanService planService;

    @Autowired
    ActivityService activityService;

    /**
     * This method returns the shopping cart.
     *
     * @param id
     * @return Shopping cart object
     */
    @Override
    public Cart getCart(String id) {
        final Optional<Cart> cart = cartRepository.findById(id);
        if (cart.isPresent()) {
            return cart.get();
        } else {

            return Cart.builder().Id(id).build();
        }
    }

    /**
     * This method adds a new item to the cart
     *
     * @param id
     * @param pay pay item to be added
     */
    @Override
    public void add(String id, CartItem pay) throws NoUserFoundException {
        final User user = userService.getById(id).get();
        if (PayTypes.PARK.equals(pay.getType())) {
            final Pay park = parkService.getParkById(pay.getItem().getId());
        } else if (PayTypes.PLAN.equals(pay.getType())) {
            final Pay plan = planService.getPlanById(pay.getItem().getId());
        } else {
            final Pay activity = activityService.getActivityById(pay.getItem().getId());
        }

        final Cart cart = getCart(id);
        cart.getItems().add(pay);
        cartRepository.save(cart);
    }

    /**
     * This method removes an item from the cart
     *
     * @param id
     * @param pay item identifier for the object to be removed.
     */
    @Override
    public void remove(String id, String pay) {
        Cart cart = getCart(id);
        List<CartItem> items = cart.getItems();
        for (CartItem item :
                items) {
            if (pay.equals(item.getItem().getId())) {
                items.remove(item);
            }
        }
        cartRepository.insert(cart);
    }

    /**
     * This method removes all items from the cart
     *
     * @param id
     */
    @Override
    public void clear(String id) {
        cartRepository.insert(Cart.builder().Id(id).build());
    }
}
