package shop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private List<Goods> goodsList;

    public Brand() {
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

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
