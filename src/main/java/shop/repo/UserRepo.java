package shop.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.entity.User;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface UserRepo extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.email LIKE :param OR u.phone LIKE :param")
    User findUserByLogin(@Param("param")String login);
}
