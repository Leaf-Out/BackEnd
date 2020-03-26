package leafout.backend.security;

import leafout.backend.model.User;
import leafout.backend.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.getUserByEmail(email);
        if(userOptional.isPresent()) {
            final User user = userOptional.get();
            String name = user.getName();
            String password = user.getPassword();
            List<String> roles = new ArrayList<>();
            roles.add(user.getRole());
            List<String> authorities = roles;
            MongoUserDetails mongoUserDetails = new MongoUserDetails(email,password,authorities.toArray(new String[authorities.size()]));
            return mongoUserDetails;
        }
        return null;
    }
}
