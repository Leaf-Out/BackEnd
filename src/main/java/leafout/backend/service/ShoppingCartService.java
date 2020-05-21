package leafout.backend.service;

import leafout.backend.apimodel.PayTypes;
import leafout.backend.model.Cart;
import leafout.backend.model.CartItem;
import leafout.backend.model.exception.ActivityException;
import leafout.backend.model.exception.ParkException;
import leafout.backend.model.Population;
import leafout.backend.model.exception.NoUserFoundException;

public interface ShoppingCartService {

    /**
     * This method returns the shopping cart.
     *
     * @param id
     * @return Shopping cart object
     */
    Cart getCart(String id);

    /**
     * This method adds a new item to the cart
     *
     * @param id
     * @param pay pay item to be added
     */
    void add(String id, CartItem pay) throws NoUserFoundException, ParkException, ActivityException;

    /**
     * This method adds a new item to the cart
     * @param userEmail
     * @param pay pay item to be added
     * @param type
     * @param population
     */
    void add(String userEmail, String pay, PayTypes type, Population population) throws NoUserFoundException, ParkException, ActivityException;

    /**
     * This method removes an item from the cart
     *
     * @param id
     * @param pay item identifier for the object to be removed.
     */
    void remove(String id, String pay);

    /**
     * This method removes all items from the cart
     *
     * @param id
     */
    void clear(String id);
}
