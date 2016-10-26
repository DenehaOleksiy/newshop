package shop.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    //    @Column
//    private String name;
//    @Column
//    private String lastName;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private boolean enabled = true;
    @Column
    private int totalCartSum;
    @Column
    private int cartQuantity;
    @Column
    @Temporal(TemporalType.DATE)
    private Date birth;
    @Column
    @Temporal(TemporalType.DATE)
    private Date registration;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Order>orderList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_product", joinColumns = @JoinColumn(name = "user"), inverseJoinColumns = @JoinColumn(name = "product"))
    private List<Product>productList;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isEnabled() {

        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getTotalCartSum() {
        return totalCartSum;
    }

    public void setTotalCartSum(int totalCartSum) {
        this.totalCartSum = totalCartSum;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }
}
