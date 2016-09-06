package shop.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Администратор on 05.09.2016.
 */
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    @Temporal(TemporalType.DATE)
    private Date dateOrders;

    @ManyToOne(fetch = FetchType.EAGER)
    private Goods goods;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Orders() {
        this.dateOrders = Calendar.getInstance().getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOrders() {
        return dateOrders;
    }

    public void setDateOrders(Date dateOrders) {
        this.dateOrders = dateOrders;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
