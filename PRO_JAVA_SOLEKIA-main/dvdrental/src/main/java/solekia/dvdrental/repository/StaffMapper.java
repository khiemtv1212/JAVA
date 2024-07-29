package solekia.dvdrental.repository;

import org.apache.ibatis.annotations.Select;

import solekia.dvdrental.entities.StaffModel;

public interface StaffMapper {
    @Select("select * from staff where username = #{username} or email = #{username}")
    public StaffModel findUserameOrEmail(String username);
}
