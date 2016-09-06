package shop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
@Entity
public class Goods {

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
    @Lob
    @Column
    private byte [] images;

    @ManyToOne(fetch = FetchType.EAGER)
    private Brand brand;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "goods")
    private List<Orders> ordersList;
    @ManyToMany
    @JoinTable(name = "user_goods", joinColumns = @JoinColumn(name = "goods"), inverseJoinColumns = @JoinColumn(name = "user"))
    private List<User>userList;

    public Goods() {
    }
}
