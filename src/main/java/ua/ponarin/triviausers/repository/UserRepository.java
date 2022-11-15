package ua.ponarin.triviausers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.ponarin.triviausers.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
