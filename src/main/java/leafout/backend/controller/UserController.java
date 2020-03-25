package leafout.backend.controller;

import leafout.backend.model.User;
import leafout.backend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        try {
            List<User> users = new ArrayList<User>();
            users = userService.getAll();
            return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{Id}")
    public ResponseEntity<?> getById(@PathVariable("Id") String userId){
        try {
            Optional<User> user = userService.getById(userId);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{tickets}/Id")
    public ResponseEntity<?> getTicketsById(){return null;}

    @GetMapping(path = "/{feedbacks}/Id")
    public ResponseEntity<?> getFeedbacksById(){return null;}

    @PostMapping
    public ResponseEntity<?> add(@RequestBody User user){
        try {
            userService.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{Id}")
    public ResponseEntity<?> delete(@PathVariable("Id") String userId){
        try {
            userService.delete(userId);
            return new ResponseEntity<>(userId, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
