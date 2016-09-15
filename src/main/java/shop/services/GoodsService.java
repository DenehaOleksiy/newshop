package shop.services;

import shop.DTO.GoodsDTO;
import shop.entity.Goods;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface GoodsService {

    List<GoodsDTO> showAllDto();
    List<Goods>showAll();
    Goods findOne(int id);

    List<GoodsDTO>byCategoryDto(String name);
    List<GoodsDTO>byBrandDto(String name);
    GoodsDTO findOneDto(int id);

    void addOrEdit(Goods goods);
    void delete(int id);

    List<Goods>byCategory(String name);
    List<Goods>byBrand(String name);

}

