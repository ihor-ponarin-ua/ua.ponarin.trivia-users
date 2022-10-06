package ua.ponarin.triviausers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ua.ponarin.triviausers.dto.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLoginAndPassword(String login, String password);
}
