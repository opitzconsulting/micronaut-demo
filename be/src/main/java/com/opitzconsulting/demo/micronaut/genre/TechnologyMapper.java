package com.opitzconsulting.demo.micronaut.genre;

import com.opitzconsulting.demo.micronaut.model.Technology;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TechnologyMapper {


    //returns all technologies
    @Select("SELECT * FROM technologies")
    List<Technology> getTechnologies();

    //returns the technology where id=id
    @Select("SELECT * FROM technologies WHERE id=#{id}")
    Technology getTechnology(int id) ;


    //insert new one
    @Insert("INSERT INTO technologies (name, description, recommendation, relevance, complexity, url, tags) values(#{name}," +
            "#{description},#{recommendation},#{relevance},#{complexity},#{url},#{tags})")
    void insertTechnology(Technology technology) ;

    //delete where id = id
    @Delete("DELETE FROM technologies WHERE id=#{id}")
    void removeTechnology(int id);


    //update where id = id
    @Update("UPDATE technologies SET name=#{name}, description=#{description}, recommendation=#{recommendation}, " +
            "relevance=#{relevance}, complexity=#{complexity}, url=#{url}, tags=#{tags} WHERE id=#{id}")
    void update(@Param("id") Integer id, @Param("name") String name, @Param("description") String description,
                @Param("relevance") Integer relevance, @Param("recommendation")Integer recommendation,
                @Param("complexity")Integer complexity, @Param("url") String url,@Param("tags") List<String> tags);


}
