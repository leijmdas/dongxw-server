package com.kunlong.data.dao;

import com.kunlong.data.entity.DocumentModel;
import com.kunlong.data.entity.DocumentModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DocumentModelMapper {
    long countByExample(DocumentModelExample example);

    int deleteByExample(DocumentModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DocumentModel record);

    int insertSelective(DocumentModel record);

    List<DocumentModel> selectByExampleWithBLOBsWithRowbounds(DocumentModelExample example, RowBounds rowBounds);

    List<DocumentModel> selectByExampleWithBLOBs(DocumentModelExample example);

    List<DocumentModel> selectByExampleWithRowbounds(DocumentModelExample example, RowBounds rowBounds);

    List<DocumentModel> selectByExample(DocumentModelExample example);

    DocumentModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DocumentModel record, @Param("example") DocumentModelExample example);

    int updateByExampleWithBLOBs(@Param("record") DocumentModel record, @Param("example") DocumentModelExample example);

    int updateByExample(@Param("record") DocumentModel record, @Param("example") DocumentModelExample example);

    int updateByPrimaryKeySelective(DocumentModel record);

    int updateByPrimaryKeyWithBLOBs(DocumentModel record);

    int updateByPrimaryKey(DocumentModel record);
}