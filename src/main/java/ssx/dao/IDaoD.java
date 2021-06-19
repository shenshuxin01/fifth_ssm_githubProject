package ssx.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ssx.entity.DBSchemaD;

@Repository
public interface IDaoD {

    @Select("select value from ssm_five where name=#{name}")
    DBSchemaD que(String name);

    @Insert("insert into ssm_five values(#{name},#{value})")
    boolean add(DBSchemaD d);
}
