package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shop.comparatorDto.ComparatorPriceAsc;
import shop.comparatorDto.ComparatorPriceDesc;
import shop.DTO.ProductDTO;
import shop.entity.Brand;
import shop.entity.Product;
import shop.entity.Type;
import shop.services.BrandService;
import shop.services.ProductService;
import shop.services.TypeService;

import java.io.IOException;
import java.util.*;

/**
 * Created by Администратор on 09.09.2016.
 */@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private TypeService typeService;

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/allP", method = RequestMethod.GET)
    public String allProducts(Model model){
        List<Type>typeList = typeService.showAll();
        List<ProductDTO>productList = productService.showAllDto();
        model.addAttribute("type", typeList);
        model.addAttribute("productList", productList);
        List<Brand>brands = brandService.findAll();
        model.addAttribute("brand", brands);
        return "allProductsPage";
    }

    @RequestMapping(value = "/allP/edit/{id}")
    public String editProduct(Model model, @PathVariable String id){
        List<Type>typeList = typeService.showAll();
        List<Brand>brands = brandService.findAll();
        model.addAttribute("product", productService.findOne(Integer.parseInt(id)));
        model.addAttribute("types", typeList);
        model.addAttribute("brands", brands);
        return "productEdit";
    }

    @RequestMapping(value = "/allP/editing", method = RequestMethod.POST)
    public String editing(@RequestParam("id")Integer id, @RequestParam("name")String name, @RequestParam("price")Integer price, @RequestParam("description")String description,@RequestParam("full_description")String full_description, @RequestParam("image")MultipartFile multipartFile,  @RequestParam("typeName")Integer typeId, @RequestParam("brandName")Integer brandId ){
        Product product = productService.findOne(id);
        Brand brand = brandService.findOne(brandId);
        Type type = typeService.findOne(typeId);
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setFull_description(full_description);
        product.setType(type);
        product.setBrand(brand);

        try {
            product.setImage(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        productService.addOrEdit(product);

        return "redirect:/allP";
    }

    @RequestMapping(value = "/productDelete/{id}", method = RequestMethod.POST)
    public String delete(Model model, @PathVariable String id){
        productService.delete(Integer.parseInt(id));
        return "redirect:/allP";
    }

    @RequestMapping(value = "/allP/{id}", method = RequestMethod.GET)
    public String singleProductPage(@PathVariable String id, Model model){
//        Product product = productService.findOne(Integer.parseInt(id));

        ProductDTO product = productService.findOneDto(Integer.parseInt(id));
        model.addAttribute("product", product);
        return "singleProductPage";
    }


    @RequestMapping(value = "/pByBrand/{name}", method = RequestMethod.GET)
    public String byBrand(@PathVariable String name, Model model){
        List<Type>typeList =typeService.showAll();
        List<ProductDTO>byBrand =productService.byBrandDto(name);
        model.addAttribute("type", typeList);
        model.addAttribute("byBrand", byBrand);
        List<Brand>brands = brandService.findAll();
        model.addAttribute("brand", brands);
        return "productByBrand";
    }

    @RequestMapping(value = "/pByType/{name}", method = RequestMethod.GET)
    public String productsByType(@PathVariable String name, Model model){
        List<Type>typeList = typeService.showAll();
        List<ProductDTO>byType = productService.byTypeDto(name);
        model.addAttribute("type", typeList);
        model.addAttribute("byType", byType);
        List<Brand>brands = brandService.findAll();
        model.addAttribute("brand", brands);
        return "productByType";
    }

    @RequestMapping(value = "/addP", method = RequestMethod.GET)
    public String addProduct(Model model ){
        List<Type>typeList = typeService.showAll();
        List<Brand>brandList = brandService.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("type", typeList);
        model.addAttribute("brand", brandList);
        return "addProduct";
    }

    @RequestMapping(value = "/allP/create", method = RequestMethod.POST)
    public String createProduct(@RequestParam("name")String name, @RequestParam("price")Integer price, @RequestParam("description")String description, @RequestParam("full_description")String full_description, @RequestParam("image")MultipartFile multipartFile, @RequestParam("typeName")Integer typeId, @RequestParam("brandName")Integer brandId){
        Product product = new Product();

        Brand brand = brandService.findOne(brandId);
        Type type =typeService.findOne(typeId);
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setFull_description(full_description);
        product.setType(type);
        product.setBrand(brand);
        try {
            product.setImage(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        productService.addOrEdit(product);
        return "redirect:/allP";
    }
    @RequestMapping(value = "/fromMin", method = RequestMethod.GET)
    public String fromMin(Model model){
        List<Type>typeList = typeService.showAll();
        List<Brand>brands = brandService.findAll();
        List<ProductDTO>products = productService.showAllDto();
        Collections.sort(products, new ComparatorPriceDesc());
        model.addAttribute("products", products);
        model.addAttribute("type", typeList);
        model.addAttribute("brand", brands);
        return "allProductFromMin";
    }

    @RequestMapping(value = "/fromMax", method = RequestMethod.GET)
    public String fromMax(Model model){
        List<Type>typeList = typeService.showAll();
        List<ProductDTO>products = productService.showAllDto();
        List<Brand>brands = brandService.findAll();
        Collections.sort(products, new ComparatorPriceAsc());
        model.addAttribute("products", products);
        model.addAttribute("type", typeList);
        model.addAttribute("brand", brands);
        return "allProductFromMax";
    }

}
