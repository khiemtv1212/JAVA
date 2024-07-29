package solekia.dvdrental.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
// import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * CustomerMapper
 */
public interface CustomerMapper {
    @Select("select * from customer")
    public List<CustomerModel> findAll();

    @Select("select * from customer where first_name || last_name like #{name} OR email like #{name}")
    public List<CustomerModel> findName(String name);

    @Delete("delete from customer where customer_id = #{id}")
    public void delete(int id);

    @Select("select * from customer where customer_id = #{id}")
    public CustomerModel findById(int id);

    @Update("update customer set first_name = #{first_name}, last_name = #{last_name} , email = #{email} where customer_id = #{customer_id}")
    public void update(
            @Param("customer_id") int customer_id,
            @Param("first_name") String first_name,
            @Param("last_name") String last_name,
            @Param("email") String email);

    // @Insert("insert into customer values ((select max(customer_id) + 1 from
    // customer), '1', #{first_name}, #{last_name}, #{email}, '1', true, now(),
    // now(), '1')")
    // public void registUser(
    // @Param("first_name")String first_name,
    // @Param("last_name")String last_name,
    // @Param("email")String email
    // );
}
