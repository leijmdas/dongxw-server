package com.kunlong.data.dao;

import com.kunlong.data.entity.BomModel;
import com.kunlong.data.entity.BomModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BomModelMapper {
    long countByExample(BomModelExample example);

    int deleteByExample(BomModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BomModel record);

    int insertSelective(BomModel record);

    List<BomModel> selectByExampleWithRowbounds(BomModelExample example, RowBounds rowBounds);

    List<BomModel> selectByExample(BomModelExample example);

    BomModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BomModel record, @Param("example") BomModelExample example);

    int updateByExample(@Param("record") BomModel record, @Param("example") BomModelExample example);

    int updateByPrimaryKeySelective(BomModel record);

    int updateByPrimaryKey(BomModel record);
}