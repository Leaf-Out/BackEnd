package leafout.backend.controller;

import leafout.backend.apimodel.PlanRequest;
import leafout.backend.apimodel.PlanResponse;
import leafout.backend.apimodel.UserRequest;
import leafout.backend.apimodel.UserResponse;
import leafout.backend.model.Feedback;
import leafout.backend.model.Plan;
import leafout.backend.model.User;
import leafout.backend.model.exception.NoUserFoundException;
import leafout.backend.model.exception.UserAlreadyExistsException;
import leafout.backend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<User> users = new ArrayList<>();

        try {
            users= userService.getAll();
            return new ResponseEntity<>(mapUsersResponse(users), HttpStatus.ACCEPTED);
        }catch (NoUserFoundException e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String userEmail){
        User user = null;
        try {
            user = userService.getByEmail(userEmail);
        } catch (NoUserFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(mapUserResponse(user), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/{Id}")
    public ResponseEntity<?> getById(@PathVariable("Id") String userId){
        Optional<User> user = null;
        try {
            user = userService.getById(userId);
        } catch (NoUserFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(mapUserResponse(user.get()), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/{tickets}/Id")
    public ResponseEntity<?> getTicketsById(){return null;}

    @GetMapping(path = "/{feedbacks}/Id")
    public ResponseEntity<?> getFeedbackById(){return null;}

    @PostMapping
    public ResponseEntity<?> add(@RequestBody UserRequest user){
        try {
            userService.save(mapUser(user));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{Id}")
    public ResponseEntity<?> delete(@PathVariable("Id") String userId){
        try {
            userService.delete(userId);
            return new ResponseEntity<>(userId, HttpStatus.OK);
        } catch (NoUserFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    /**
     * This method transforms a Rest user object into the business user object
     *
     * @param userRequest Rest user object to be transformed
     * @return A user object
     */
    private User mapUser(final UserRequest userRequest) {
        String encoded = new BCryptPasswordEncoder().encode(userRequest.getPassword());
        User user = User.builder().id(UUID.randomUUID().toString()).email(userRequest.getEmail())
                .name(userRequest.getName()).shoppingCart(new ArrayList<>()).givenFeedback(new Feedback())
                .password(encoded).phone(userRequest.getPhone()).role("USER")
                .build();
        return user;
    }
    /**
     * This method transforms a Rest user object into the business user object
     *
     * @param user Rest user object to be transformed
     * @return A user object
     */
    private UserResponse mapUserResponse(final User user) {

        UserResponse userResponse = UserResponse.builder().id(user.getId())
                .email(user.getEmail()).feedback(user.getGivenFeedback()).name(user.getName())
                .shoppingCart(user.getShoppingCart())
                .build();
        return userResponse;
    }
    /**
     * This method transforms a lists of  User object into the response  list User object
     *
     * @param allUser Rest User object to be transformed
     * @return A List<User> object
     */
    private List<UserResponse> mapUsersResponse(final List<User> allUser) {
        List<UserResponse> users = new ArrayList<>();
        for (User user : allUser) {
            users.add(
                    UserResponse.builder().id(user.getId())
                            .email(user.getEmail()).feedback(user.getGivenFeedback()).name(user.getName())
                            .shoppingCart(user.getShoppingCart())
                            .build()
            );
        }

        return users;
    }
}
