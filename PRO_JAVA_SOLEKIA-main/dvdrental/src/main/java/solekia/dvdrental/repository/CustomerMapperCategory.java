package solekia.dvdrental.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import solekia.dvdrental.entities.CustomerCategory;

public interface CustomerMapperCategory {
    @Select("select * from category")
    public List<CustomerCategory> findAll();
}
