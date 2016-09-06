package shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.Category;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
