package leafout.backend.service.impl;

import leafout.backend.model.Cart;
import leafout.backend.model.Pay;
import leafout.backend.persistence.CartRespository;
import leafout.backend.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShoppingCartImpl implements ShoppingCartService {

    @Autowired
    CartRespository cartRepository;

    /**
     * This method returns the shopping cart.
     *
     * @return Shopping cart object
     */
    @Override
    public Cart getCart() {
        String currentUser;
        Cart cart = null;
        /*if(!cartRepository.findById(currentUser).ifPresent()){
            cartRepository.save(new Cart(currentUser,null,-1));
        }
        else{
            cart = cartRepository.findById(currentUser).get();
        }
         */
        return cart;
    }

    /**
     * This method returns a specific item from the cart
     *
     * @param pay identifier for the item to be searched
     * @return A pay object
     */
    @Override
    public Pay getById(String pay) {
        List<Pay> cartItems = getCart().getItems();
        Pay payable = null;
        for (Pay item : cartItems) {
            if (item.getId().equals(pay)) {
                return payable;
            }
        }
        return payable;
    }

    /**
     * This method adds a new item to the cart
     *
     * @param pay pay item to be added
     */
    @Override
    public void add(Pay pay) {
        Cart cart = getCart();

        cart.getItems().add(pay);
        cart.setItems(cart.getItems());
        cartRepository.save(cart);
    }

    /**
     * This method updates the cart state
     *
     * @param cart A list with the new items; i.e. the new state of the cart
     */
    @Override
    public void update(Cart cart) {
        cartRepository.insert(cart);
    }

    /**
     * This method removes an item from the cart
     *
     * @param pay item identifier for the object to be removed.
     */
    @Override
    public void remove(String pay) {
        cartRepository.delete(getCart());
    }

    /**
     * This method removes an item from the cart
     *
     * @param Pay item to be removed
     */
    @Override
    public void remove(Pay Pay) {
        Cart cart = getCart();
        cart.getItems().remove(Pay);
        cart.setItems(cart.getItems());
        cartRepository.save(cart);
    }

    /**
     * This method removes all items from the cart
     */
    @Override
    public void clear() {
        // get the logged in user
        String currentUser = null;
        cartRepository.deleteById(currentUser);
    }
}
