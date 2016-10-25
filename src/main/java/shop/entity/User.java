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
    @Column
    private String name;
    @Column
    private String secondName;
    @Column
    @Temporal(TemporalType.DATE)
    private Date registrDate;
    @Column
    private String password;
    @Transient
    @Column
    private String passwConfirm;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private boolean enable = true;
    @Column
    private int quantity;
    @Column
    private int summa;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Orders> ordersList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_goods", joinColumns = @JoinColumn(name = "user"), inverseJoinColumns = @JoinColumn(name = "goods"))
    private List<Product> productList;

    public User() {
        this.registrDate = Calendar.getInstance().getTime();
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getRegistrDate() {
        return registrDate;
    }

    public void setRegistrDate(Date registrDate) {
        this.registrDate = registrDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSumma() {
        return summa;
    }

    public void setSumma(int summa) {
        this.summa = summa;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getPasswConfirm() {
        return passwConfirm;
    }

    public void setPasswConfirm(String passwConfirm) {
        this.passwConfirm = passwConfirm;
    }
}
