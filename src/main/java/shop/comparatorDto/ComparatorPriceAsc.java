package shop.comparatorDto;

import shop.DTO.ProductDTO;

import java.util.Comparator;

/**
 * Created by Администратор on 25.10.2016.
 */
public class ComparatorPriceAsc implements Comparator<ProductDTO> {

    @Override
    public int compare(ProductDTO o1, ProductDTO o2) {
        return o2.getPrice()-o1.getPrice();
    }
}
