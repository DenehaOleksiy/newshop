package shop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
    private List<Product>productList;

    public Type() {
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
