package shop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Goods> goodsList;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<SubCategory> subCategoryList;

    public Category() {
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

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<SubCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
