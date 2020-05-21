package leafout.backend.service.impl;

import leafout.backend.apimodel.PayTypes;
import leafout.backend.model.*;
import leafout.backend.model.exception.ActivityException;
import leafout.backend.model.exception.ParkException;
import leafout.backend.model.exception.NoUserFoundException;
import leafout.backend.persistence.CartRespository;
import leafout.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
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
    public Cart getCart(String id) throws NoUserFoundException {

        final Optional<Cart> cart = cartRepository.findById(id);
        if (cart.isPresent()) {
            return cart.get();
        } else {
            Map<String,CartItem> items = new HashMap<>();
            return Cart.builder().user(id).items(items).build();
        }
    }

    /**
     * This method adds a new item to the cart
     *
     * @param id
     * @param pay pay item to be added
     */
    @Override
    public void add(String id, CartItem pay) throws NoUserFoundException, ParkException, ActivityException {
        //TODO
    }

    /**
     * This method adds a new item to the cart
     * given an item id
     * @param userEmail for the item to be added to the cart
     * @param pay pay item to be added
     * @param type
     * @param population
     */
    @Override
    public void add(String userEmail, String pay, PayTypes type, Population population) throws NoUserFoundException, ParkException, ActivityException {
        final User user = userService.getByEmail(userEmail);
        final Cart cart = getCart(userEmail);
        if(cart.getItems().get(pay.concat(population.toString())) != null){
            cart.getItems().get(pay.concat(population.toString())).setUnits(
                            cart.getItems().get(pay.concat(population.toString())).getUnits() + 1
                    );
        } else{
            final Pay payItem;
            if (PayTypes.PARK.equals(type)) {
                payItem = parkService.getParkById(pay);
                payItem.getPrices();
                CartItem cartItem = CartItem.builder()
                        .item(payItem)
                        .population(population)
                        .units(1)
                        .type(type)
                        .build();
                cart.getItems().put(pay.concat(population.toString()), cartItem);
            } else if (PayTypes.PLAN.equals(type)) {
                payItem = planService.getPlanById(pay);
                CartItem cartItem = CartItem.builder()
                        .item(payItem)
                        .population(population)
                        .units(1)
                        .type(type)
                        .build();
                cart.getItems().put(pay.concat(population.toString()), cartItem);
            } else {
                payItem = activityService.getActivityById(pay);
                CartItem cartItem = CartItem.builder()
                        .item(payItem)
                        .population(population)
                        .units(1)
                        .type(type)
                        .build();
                cart.getItems().put(pay.concat(population.toString()), cartItem);
            }
        }
        cartRepository.save(cart);
    }

    /**
     * This method removes an item from the cart
     *
     * @param id
     * @param pay item identifier for the object to be removed.
     */
    @Override
    public void remove(String id, String pay) throws NoUserFoundException {
        Cart cart = getCart(id);
        Map<String,CartItem> items = cart.getItems();
        items.remove(pay);
        cartRepository.save(cart);
    }

    /**
     * This method removes all items from the cart
     *
     * @param id
     */
    @Override
    public void clear(String id) {
        cartRepository.insert(Cart.builder().user(id).build());
    }
}
