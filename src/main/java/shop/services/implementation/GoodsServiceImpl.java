package shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.DTO.GoodsDTO;
import shop.entity.Goods;
import shop.repo.GoodsRepo;
import shop.services.GoodsService;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepo goodsRepo;


    @Override
    public List<Goods> showAll() {
        return goodsRepo.findAll();
    }

    @Override
    public Goods findOne(int id) {
        return goodsRepo.findOne(id);
    }

    @Override
    public void addOrEdit(Goods goods) {
     goodsRepo.save(goods);
    }

    @Override
    public void delete(int id) {
    goodsRepo.delete(id);
    }

    @Override
    public List<Goods> byCategory(String name) {
        return goodsRepo.byCategory(name);
    }

    @Override
    public List<Goods> byBrand(String name) {
        return goodsRepo.byBrand(name);
    }
//===================================================
    @Override
    public List<GoodsDTO> showAllDto() {
        List<Goods>goodsList = goodsRepo.findAll();
        List<GoodsDTO>goodsDTOs = new ArrayList<>();
        for (Goods goods:goodsList) {
            GoodsDTO goodsDTO = new GoodsDTO();
            goodsDTO.setId(goods.getId());
            goodsDTO.setName(goods.getName());
            goodsDTO.setDescription(goods.getDescription());
            String image = Base64.getEncoder().encodeToString(goods.getImages());
            goodsDTO.setImage(image);
            goodsDTO.setPrice(goods.getPrice());
            goodsDTOs.add(goodsDTO);
        }
        return goodsDTOs;
    }

    @Override
    public List<GoodsDTO> byCategoryDto(String name) {
        List<Goods>goodsList = goodsRepo.byCategory(name);
        List<GoodsDTO>goodsDTOs = new ArrayList<>();
        for (Goods p:goodsList) {

            GoodsDTO goodsDTO = new GoodsDTO();
            goodsDTO.setId(p.getId());
            goodsDTO.setName(p.getName());
            goodsDTO.setPrice(p.getPrice());
            goodsDTO.setDescription(p.getDescription());
            String image = Base64.getEncoder().encodeToString(p.getImages());
            goodsDTO.setImage(image);
            goodsDTOs.add(goodsDTO);

        }
        return goodsDTOs;
    }

    @Override
    public List<GoodsDTO> byBrandDto(String name) {
        List<Goods>goodss = goodsRepo.byBrand(name);
        List<GoodsDTO>goodsDTOList = new ArrayList<>();
        for (Goods g:goodss) {
            GoodsDTO pDto = new GoodsDTO();
            pDto.setId(g.getId());
            pDto.setName(g.getName());
            pDto.setPrice(g.getPrice());
            String image = Base64.getEncoder().encodeToString(g.getImages());
            pDto.setImage(image);
            pDto.setDescription(g.getDescription());
            goodsDTOList.add(pDto);
        }
        return goodsDTOList;
    }

    @Override
    public GoodsDTO findOneDto(int id) {
        Goods goods = goodsRepo.findOne(id);
        GoodsDTO goodsDTO = new GoodsDTO();

        goodsDTO.setId(goods.getId());
        goodsDTO.setName(goods.getName());
        goodsDTO.setPrice(goods.getPrice());
        goodsDTO.setDescription(goods.getDescription());
        String image = Base64.getEncoder().encodeToString(goods.getImages());
        goodsDTO.setBrand(goods.getBrand());
        goodsDTO.setCategory(goods.getCategory());
        goodsDTO.setImage(image);
        return goodsDTO;
    }
}


