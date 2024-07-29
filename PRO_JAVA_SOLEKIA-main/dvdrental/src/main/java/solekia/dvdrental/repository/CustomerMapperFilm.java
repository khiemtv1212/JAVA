package solekia.dvdrental.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import solekia.dvdrental.entities.CustomerFilm;

public interface CustomerMapperFilm {
    @Select("select * from film")
    public List<CustomerFilm> findAll();

    @Delete("delete from film where film_id = #{id}")
    public void delete(int id);

    @Select("select * from film where title like #{name}")
    public List<CustomerFilm> findName(String name);

    @Select("select * from film where film_id = #{id}")
    public CustomerFilm findById(int id);

    @Update("update film set  title = #{title}, description = #{description} , replacement_cost = #{replacement_cost}  where film_id = #{film_id}")
    public void updateFilm(
            @Param("film_id") int film_id,
            @Param("title") String title,
            @Param("description") String description ,
            @Param("replacement_cost") Double replacement_cost);
            
            
            
            
    @Select("SELECT * FROM public.film ORDER BY film_id LIMIT #{pageSize} OFFSET #{offset}")
    List<CustomerFilm> getFilmsWithPagination(@Param("pageSize") int pageSize, @Param("offset") int offset);

    @Select("SELECT COUNT(*) FROM film")
    int getTotalFilms();


    // @Insert("insert into film values ((select max(customer_id) + 1 from
    // customer), '1', #{first_name}, #{last_name}, #{email}, '1', true, now(),
    // now(), '1')")
    // public void registUser(
    // @Param("first_name")String first_name,
    // @Param("last_name")String last_name,
    // @Param("email")String email
    // );
}