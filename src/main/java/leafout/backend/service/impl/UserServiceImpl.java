package leafout.backend.service.impl;

import leafout.backend.model.User;
import leafout.backend.model.exception.NoUserFoundException;
import leafout.backend.model.exception.UserAlreadyExistsException;
import leafout.backend.persistence.UserRepository;
import leafout.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAll() throws NoUserFoundException {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    @Override
    public Optional<User> getById(String userId) throws NoUserFoundException {
        return userRepository.findById(userId);
    }

    @Override
    public void save(User user) throws UserAlreadyExistsException {
        userRepository.save(user);
    }

    @Override
    public void delete(String userId) throws NoUserFoundException{
        userRepository.deleteById(userId);
    }
}
