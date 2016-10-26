package shop.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Администратор on 05.09.2016.
 */
@Entity (name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;


    public Order() {
        this.orderDate= Calendar.getInstance().getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
