package shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface UserRepo extends JpaRepository<User,Integer> {
}
