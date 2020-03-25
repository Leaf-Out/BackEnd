package leafout.backend.service.impl;

import leafout.backend.model.Cart;
import leafout.backend.model.Pay;
import leafout.backend.service.ShoppingCartService;

import java.util.List;
import java.util.UUID;

public class ShoppingCartImpl implements ShoppingCartService {
    /**
     * This method returns the shopping cart.
     *
     * @return Shopping cart object
     */
    @Override
    public Cart getCart() {
        return null;
    }

    /**
     * This method returns a specific item from the cart
     *
     * @param pay identifier for the item to be searched
     * @return A pay object
     */
    @Override
    public Pay getById(UUID pay) {
        return null;
    }

    /**
     * This method adds a new item to the cart
     *
     * @param pay pay item to be added
     */
    @Override
    public void add(Pay pay) {

    }

    /**
     * This method updates the cart state
     *
     * @param items A list with the new items; i.e. the new state of the cart
     */
    @Override
    public void update(List<Pay> items) {

    }

    /**
     * This method removes an item from the cart
     *
     * @param pay item identifier for the object to be removed.
     */
    @Override
    public void remove(UUID pay) {

    }

    /**
     * This method removes an item from the cart
     *
     * @param Pay item to be removed
     */
    @Override
    public void remove(Pay Pay) {

    }

    /**
     * This method removes all items from the cart
     */
    @Override
    public void clear() {

    }
}
