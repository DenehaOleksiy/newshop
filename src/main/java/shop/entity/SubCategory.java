package shop.entity;

import javax.persistence.*;

/**
 * Created by Администратор on 05.09.2016.
 */@Entity
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public SubCategory() {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

