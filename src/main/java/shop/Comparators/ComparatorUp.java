package shop.Comparators;

import java.util.Comparator;

/**
 * Created by Администратор on 25.10.2016.
 */
public class ComparatorUp implements Comparator<ProductDTO>{

    @Override
    public int compare(ProductDTO o1, ProductDTO o2) {
        return o1.getPrice()-o2.getPrice();
    }
}
