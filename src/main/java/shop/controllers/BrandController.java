package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shop.entity.Brand;
import shop.services.BrandService;

import java.util.List;

/**
 * Created by Администратор on 11.10.2016.
 */
@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;


    @RequestMapping(value = "/addNewBrand", method = RequestMethod.GET)
    public String addNewBrand(Model model){
        List<Brand> brandList = brandService.findAll();
        model.addAttribute("brands", brandList);
        return "addBrand";
    }

    @RequestMapping(value = "/addBrand/new", method = RequestMethod.POST)
    public String addingBrand(@RequestParam("name")String name){

        brandService.addBrand(name);
        return "redirect:/addNewBrand";
    }

    @RequestMapping(value = "/deleteBrand/{id}", method = RequestMethod.POST)
    public String deleteBrand(@PathVariable Integer id){
        brandService.delete(id);
        return "redirect:/addNewBrand";
    }

}
