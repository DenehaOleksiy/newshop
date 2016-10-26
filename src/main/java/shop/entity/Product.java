package shop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private int price;
    @Column
    private String description;
    @Column
    private String full_description;
    @Column
    @Lob
    private byte[] image;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @ManyToOne(fetch = FetchType.EAGER)

    private Brand brand;
    @ManyToOne(fetch = FetchType.EAGER)
    private Type type;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private List<Order>orderList;
    @ManyToMany
    @JoinTable(name = "user_product", joinColumns = @JoinColumn(name = "product"), inverseJoinColumns = @JoinColumn(name = "user"))
    private List<User>userList;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFull_description() {
        return full_description;
    }

    public void setFull_description(String full_description) {
        this.full_description = full_description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

}
