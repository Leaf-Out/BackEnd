package leafout.backend.service.impl;

import leafout.backend.model.User;
import leafout.backend.model.exception.NoUserFoundException;
import leafout.backend.model.exception.UserAlreadyExistsException;
import leafout.backend.persistence.UserRepository;
import leafout.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAll() throws NoUserFoundException {
        return userRepository.findAll();
    }

    @Override

    public Optional<User> getById(String userId) throws NoUserFoundException {
        return userRepository.getUserById(userId);
    }

    @Override
    public User getByEmail(String userName) throws NoUserFoundException {
        Optional<User> user = userRepository.getUserByEmail(userName);
        if (!user.isPresent()){
            new NoUserFoundException(userName);
        }
        return user.get();
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
