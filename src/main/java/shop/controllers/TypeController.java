package shop.controllers;

/**
 * Created by Администратор on 11.10.2016.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shop.entity.Type;
import shop.services.CategoryService;

import java.util.List;

@Controller
public class TypeController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/addNewCategory", method = RequestMethod.GET)
    public String addNewCategory(Model model){
        List<Type> typeList = categoryService.showAll();
        model.addAttribute("category", typeList);
        return "addCategory";
    }

    @RequestMapping(value = "/addCategory/new", method = RequestMethod.POST)
    public String addingCategory(@RequestParam("name")String name){
        categoryService.addCategory(name);
        return "redirect:/addNewCategory";
    }

    @RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.POST)
    public String deleteCategory(@PathVariable Integer id){
        categoryService.delete(id);

        return "redirect:/addNewCategory";
    }
}

