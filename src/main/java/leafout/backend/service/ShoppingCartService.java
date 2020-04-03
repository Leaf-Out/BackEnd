package leafout.backend.service;

import leafout.backend.model.Cart;
import leafout.backend.model.Pay;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {

    /**
     * This method returns the shopping cart.
     *
     * @return Shopping cart object
     */
    Cart getCart();

    /**
     * This method returns a specific item from the cart
     *
     * @param pay identifier for the item to be searched
     * @return A pay object
     */
    Pay getById(String pay);

    /**
     * This method adds a new item to the cart
     *
     * @param pay pay item to be added
     */
    void add(Pay pay);

    /**
     * This method updates the cart state
     *
     * @param cart A list with the new items; i.e. the new state of the cart
     */
    void update(Cart cart);

    /**
     * This method removes an item from the cart
     *
     * @param pay item identifier for the object to be removed.
     */
    void remove(String pay);

    /**
     * This method removes an item from the cart
     *
     * @param Pay item to be removed
     */
    void remove(Pay Pay);

    /**
     * This method removes all items from the cart
     */
    void clear();
}
