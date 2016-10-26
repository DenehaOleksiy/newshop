package shop.services;

import shop.DTO.ProductDTO;
import shop.entity.Product;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface ProductService {

    List<ProductDTO>showAllDto();
    List<Product>showAll();
    Product findOne(int id);

    List<ProductDTO>byTypeDto(String name);
    List<ProductDTO>byBrandDto(String name);
    ProductDTO findOneDto(int id);

//    ProductDTO findOneDto(int id);

    void addOrEdit(Product product);
    void delete(int id);

    List<Product>byType(String name);
    List<Product>byBrand(String name);

//    List<ProductDTO>byTypeDto(String name);
//    List<ProductDTO>byBrandDto(String name);
}
