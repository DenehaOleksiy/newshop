package shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.SubCategory;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface SubCategoryRepo extends JpaRepository<SubCategory,Integer> {
}
