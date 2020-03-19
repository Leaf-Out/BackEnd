package leafout.backend.service;

import leafout.backend.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserService {

    List<User> getAll();
    Optional<User> getById(UUID userId);
    void save(User user);
    void delete(UUID userId);

}
