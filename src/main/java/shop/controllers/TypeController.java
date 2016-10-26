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
import shop.services.TypeService;

import java.util.List;

@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/addNewType", method = RequestMethod.GET)
    public String addNewType(Model model){
        List<Type> typeList = typeService.showAll();
        model.addAttribute("types", typeList);
        return "addType";
    }

    @RequestMapping(value = "/addType/new", method = RequestMethod.POST)
    public String addingType(@RequestParam("name")String name){
        typeService.addType(name);
        return "redirect:/addNewType";
    }

    @RequestMapping(value = "/deleteType/{id}", method = RequestMethod.POST)
    public String deleteType(@PathVariable Integer id){
        typeService.delete(id);

        return "redirect:/addNewType";
    }
}
