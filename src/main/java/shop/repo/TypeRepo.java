package shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.Type;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface TypeRepo extends JpaRepository<Type,Integer> {
}
