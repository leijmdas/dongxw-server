package com.kunlong.data.dao;

import com.kunlong.data.entity.ProductModel;
import com.kunlong.data.entity.ProductModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ProductModelMapper {
    long countByExample(ProductModelExample example);

    int deleteByExample(ProductModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductModel record);

    int insertSelective(ProductModel record);

    List<ProductModel> selectByExampleWithRowbounds(ProductModelExample example, RowBounds rowBounds);

    List<ProductModel> selectByExample(ProductModelExample example);

    ProductModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductModel record, @Param("example") ProductModelExample example);

    int updateByExample(@Param("record") ProductModel record, @Param("example") ProductModelExample example);

    int updateByPrimaryKeySelective(ProductModel record);

    int updateByPrimaryKey(ProductModel record);
}