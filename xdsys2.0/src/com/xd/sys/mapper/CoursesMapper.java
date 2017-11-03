package com.xd.sys.mapper;

import com.xd.sys.po.Courses;
import com.xd.sys.po.CoursesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoursesMapper {
    int countByExample(CoursesExample example);

    int deleteByExample(CoursesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Courses record);

    int insertSelective(Courses record);

    List<Courses> selectByExampleWithBLOBs(CoursesExample example);

    List<Courses> selectByExample(CoursesExample example);
    
    List<Courses> selectByCourse(@Param(value="name") String name);

    Courses selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Courses record, @Param("example") CoursesExample example);

    int updateByExampleWithBLOBs(@Param("record") Courses record, @Param("example") CoursesExample example);

    int updateByExample(@Param("record") Courses record, @Param("example") CoursesExample example);

    int updateByPrimaryKeySelective(Courses record);

    int updateByPrimaryKeyWithBLOBs(Courses record);

    int updateByPrimaryKey(Courses record);
}