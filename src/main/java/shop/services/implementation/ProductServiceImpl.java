package shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.DTO.ProductDTO;
import shop.entity.Product;
import shop.repo.ProductRepo;
import shop.services.ProductService;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;


    public List<Product> showAll() {
        return productRepo.findAll();
    }

    public Product findOne(int id) {
        return productRepo.findOne(id);
    }


    public List<Product> byType(String name) {return productRepo.byType(name);}

    public List<Product> byBrand(String name) {
        return productRepo.byBrand(name);
    }



    public void addOrEdit(Product product) {
        productRepo.save(product);
    }

    public void delete(int id) {
        productRepo.delete(id);
    }

    public List<ProductDTO> showAllDto() {
        List<Product>productList = productRepo.findAll();
        List<ProductDTO>productDTOs = new ArrayList<>();
        for (Product product:productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());

            productDTO.setDescription(product.getDescription());
            productDTO.setFull_description(product.getFull_description());
            String image = Base64.getEncoder().encodeToString(product.getImage());
            productDTO.setImage(image);
            productDTO.setPrice(product.getPrice());
            productDTOs.add(productDTO);
        }

        return productDTOs;
    }


    public List<ProductDTO> byTypeDto(String name) {
        List<Product>productList = productRepo.byType(name);
        List<ProductDTO>productDTOs = new ArrayList<>();
        for (Product p:productList) {

            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(p.getId());
            productDTO.setName(p.getName());
            productDTO.setPrice(p.getPrice());
            productDTO.setDescription(p.getDescription());
            productDTO.setFull_description(p.getFull_description());
            String image = Base64.getEncoder().encodeToString(p.getImage());
            productDTO.setImage(image);
            productDTOs.add(productDTO);

        }
        return productDTOs;
    }


    public List<ProductDTO> byBrandDto(String name){
        List<Product>products = productRepo.byBrand(name);
        List<ProductDTO>productDTOList = new ArrayList<>();
        for (Product p:products) {
            ProductDTO pDto = new ProductDTO();
            pDto.setId(p.getId());
            pDto.setName(p.getName());
            pDto.setPrice(p.getPrice());
            String image = Base64.getEncoder().encodeToString(p.getImage());
            pDto.setImage(image);
            pDto.setDescription(p.getDescription());
            pDto.setFull_description(p.getFull_description());

            productDTOList.add(pDto);
        }
        return productDTOList;
    }

    @Override
    public ProductDTO findOneDto(int id) {
        Product product = productRepo.findOne(id);
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setFull_description(product.getFull_description());
        String image = Base64.getEncoder().encodeToString(product.getImage());
        productDTO.setBrand(product.getBrand());
        productDTO.setType(product.getType());
        productDTO.setImage(image);
        return productDTO;
    }
}
