package shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.DTO.ProductDTO;
import shop.entity.Product;
import shop.repo.GoodsRepo;
import shop.services.GoodsService;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepo goodsRepo;


    @Override
    public List<Product> showAll() {
        return goodsRepo.findAll();
    }

    @Override
    public Product findOne(int id) {
        return goodsRepo.findOne(id);
    }

    @Override
    public void addOrEdit(Product product) {
     goodsRepo.save(product);
    }

    @Override
    public void delete(int id) {
    goodsRepo.delete(id);
    }

    @Override
    public List<Product> byCategory(String name) {
        return goodsRepo.byCategory(name);
    }

    @Override
    public List<Product> byBrand(String name) {
        return goodsRepo.byBrand(name);
    }
//===================================================
    @Override
    public List<ProductDTO> showAllDto() {
        List<Product> productList = goodsRepo.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setDescription(product.getDescription());
            String image = Base64.getEncoder().encodeToString(product.getImages());
            productDTO.setImage(image);
            productDTO.setPrice(product.getPrice());
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }

    @Override
    public List<ProductDTO> byCategoryDto(String name) {
        List<Product> productList = goodsRepo.byCategory(name);
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product p: productList) {

            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(p.getId());
            productDTO.setName(p.getName());
            productDTO.setPrice(p.getPrice());
            productDTO.setDescription(p.getDescription());
            String image = Base64.getEncoder().encodeToString(p.getImages());
            productDTO.setImage(image);
            productDTOs.add(productDTO);

        }
        return productDTOs;
    }

    @Override
    public List<ProductDTO> byBrandDto(String name) {
        List<Product> productses = goodsRepo.byBrand(name);
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product g: productses) {
            ProductDTO pDto = new ProductDTO();
            pDto.setId(g.getId());
            pDto.setName(g.getName());
            pDto.setPrice(g.getPrice());
            String image = Base64.getEncoder().encodeToString(g.getImages());
            pDto.setImage(image);
            pDto.setDescription(g.getDescription());
            productDTOList.add(pDto);
        }
        return productDTOList;
    }

    @Override
    public ProductDTO findOneDto(int id) {
        Product product = goodsRepo.findOne(id);
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        String image = Base64.getEncoder().encodeToString(product.getImages());
        productDTO.setBrand(product.getBrand());
        productDTO.setType(product.getType());
        productDTO.setImage(image);
        return productDTO;
    }
}


