package com.opitzconsulting.demo.micronaut.genre;

import com.opitzconsulting.demo.micronaut.model.Tags;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TagMapper {


    //returns the technology where id=id
    @Select("SELECT * FROM tags WHERE id=#{id}")
    Tags getTag(int id) ;


    //insert new one
    @Insert("INSERT INTO tags(tag) values(#{tag})")
    void insertTag(Tags tag) ;

    @Select("SELECT * FROM tags")
    List<Tags> getTags();
}
