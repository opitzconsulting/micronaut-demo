package com.opitzconsulting.demo.micronaut.genre;

import com.opitzconsulting.demo.micronaut.model.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TagMapper {


    //returns the technology where id=id
    @Select("SELECT * FROM tags WHERE id=#{id}")
    Tag getTag(int id) ;


    //insert new one
    @Insert("INSERT INTO tags(tag) values(#{tag})")
    void insertTag(Tag tag) ;

}
