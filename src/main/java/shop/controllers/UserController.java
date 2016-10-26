package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import shop.DTO.ProductDTO;
import shop.entity.Order;
import shop.entity.Product;
import shop.mail.MailMail;
import shop.services.OrderService;
import shop.services.ProductService;
import shop.services.UserService;
import shop.entity.User;
import shop.validations.UserValidator;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
@Controller
public class UserController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public  String registrPage(Model model){
        model.addAttribute("user", new User());
        return "registrationPage";
    }

    @RequestMapping(value = "/registrating", method = RequestMethod.POST)
    public String registration(@ModelAttribute User user, BindingResult bindingResult){
        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors()){
            return "registrationPage";
        }else{
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Date registr = Calendar.getInstance().getTime();

            user.setRegistration(registr);
            userService.add(user);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String login(){

        return "login";
    }

    @RequestMapping(value = "/myCart", method = RequestMethod.GET)
    public String cart(Principal principal, Model model){
        User user = userService.findOne(Integer.parseInt(principal.getName()));

        List<Product> products = user.getProductList();
        model.addAttribute("user", user);
        model.addAttribute("cart", products);
        return "shoppingCart";
    }


    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(Principal principal, @RequestParam("id")Integer id){
        User user = userService.findOne(Integer.parseInt(principal.getName()));
        List<Product>productList = user.getProductList();
        Product product = productService.findOne(id);
        Integer idProduct = product.getId();
        Integer i = 0;
        for (Product p:productList) {
            if(p.getId()==idProduct){
                i++;
            }
        }
        if(i==0){
            productList.add(product);
        }
        Integer totalPrice = 0;
        Integer quantity =0;

        for (Product p: productList) {
            int a = p.getPrice();
            totalPrice+=a;
            quantity++;
        }
        user.setCartQuantity(quantity);
        user.setTotalCartSum(totalPrice);
        user.setProductList(user.getProductList());
        userService.add(user);
        return "redirect:/allP/"+String.valueOf(product.getId());

    }




    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public  String deleteFromCart(Principal principal, @PathVariable("id")Integer id, Model model){
        User user = userService.findOne(Integer.parseInt(principal.getName()));
        List<Product>productList = user.getProductList();

        Product product = productService.findOne(id);
        System.out.println(product.getId());
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()){
            Product p = iterator.next();
            if(product.getId()==p.getId()){
                iterator.remove();
            }
        }
        Integer quantity =0;
        Integer totalPrice = 0;
        for (Product p: productList) {
            int a = p.getPrice();
            totalPrice+=a;
            quantity++;
        }
        user.setCartQuantity(quantity);
        user.setTotalCartSum(totalPrice);
        user.setProductList(productList);

        userService.add(user);

        return "redirect:/myCart";
    }



    @RequestMapping(value = "/userPage/{id}", method = RequestMethod.GET)
    public String userPage(@PathVariable String id,  Model model){
        User user = userService.findOne(Integer.parseInt(id));
        model.addAttribute("user", user);
        return "userPage";
    }


    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    public String blockUser(@ModelAttribute User user, @RequestParam boolean enabled){
        user.setEnabled(enabled);
        userService.add(user);
        return "redirect:/allUsers";
    }

    @RequestMapping(value = "/buyNow/{id}", method = RequestMethod.GET)
    public  String buyNow(Principal principal ,Model model, @PathVariable Integer id){
        User user = userService.findOne(Integer.parseInt(principal.getName()));

        ProductDTO productDTO = productService.findOneDto(id);
        model.addAttribute("user", new User());
        model.addAttribute("product", productDTO);
        return "buyNow";
    }
    @RequestMapping(value = "/afterPurchase", method = RequestMethod.GET)
    public String afterPurchase(){
        return "afterPurchase";
    }

    @RequestMapping(value = "/processing", method = RequestMethod.POST)
    public String buyingProcess(Principal principal, @RequestParam("id")Integer id, Model model, @RequestParam("phone")String phone, @RequestParam("email")String email){


//        userValidator.validate(user, bindingResult);
//        if(bindingResult.hasErrors()){
//            return "buyNow";
//        }

        Product product =productService.findOne(id);
        Order order = new Order();
        order.setOrderDate(Calendar.getInstance().getTime());
        order.setProduct(product);
        User user = userService.findOne(Integer.parseInt(principal.getName()));
        order.setUser(user);
        List<Order>orders=user.getOrderList();
        orders.add(order);
        user.setOrderList(orders);
        orderService.add(order);

        ApplicationContext context = new ClassPathXmlApplicationContext("mail.xml");
//
        MailMail mm = (MailMail) context.getBean("mailMail");


        mm.sendMail("johnnygstore@gmail.com",
                email,
                "Підтвердження замовлення",
                "Ви залишишили заявку на сайті Johnny Gentleman на "+product.getName()+"("+product.getType().getName()+", "+product.getBrand().getName()+"), Вартість товару - "+product.getPrice()+" грн.\nНаш представник зконтактується з Вами.\nДякуємо за довіру!");



        mm.sendMail("johnnygstore@gmail.com",
                "johnnygstore@gmail.com",
                "Нове замовлення з сайту!",
                "На сайті щойно було залишено заявку на "+product.getName()+"("+product.getType().getName()+", "+product.getBrand().getName()+", Вартість товару - "+product.getPrice()+" грн.\nEmail клієнта - "+email+"\nТелефон клієнта - "+phone);


        return "redirect:/afterPurchase";
    }


    @RequestMapping(value = "/sendMessage")
    public String sendingMessage(@RequestParam("name")String name, @RequestParam("email")String email, @RequestParam("message")String message){

        ApplicationContext context = new ClassPathXmlApplicationContext("mail.xml");
        MailMail  msg = (MailMail)context.getBean("mailMail");
        msg.sendMail(
                "johnnygstore@gmail.com",
                "johnnygstore@gmail.com",
                "Повідомлення з контактної форми сайту Johnny Gentleman",
                "Ім'я клієнта - "+name+"\nEmail клієнта - "+email+"\nТекст повідомлення: "+message
        );
        return "redirect:/";
    }

}
