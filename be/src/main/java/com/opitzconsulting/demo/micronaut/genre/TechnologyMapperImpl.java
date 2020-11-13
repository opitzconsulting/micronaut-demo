package com.opitzconsulting.demo.micronaut.genre;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.opitzconsulting.demo.micronaut.model.Technology;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TechnologyMapperImpl implements TechnologyMapper {

    private final SqlSessionFactory sqlSessionFactory;

    public TechnologyMapperImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Technology getTechnology(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return getTechnologyMapper(sqlSession).getTechnology(id);

        }


    }
    private TechnologyMapper getTechnologyMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(TechnologyMapper.class);
    }

    @Override
    public List<Technology> getTechnologies() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return getTechnologyMapper(sqlSession).getTechnologies();
        }
    }


    public void insertTechnology(Technology technology) {

        // Use try-with-resources to automatically close the sql session.
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            getTechnologyMapper(sqlSession).insertTechnology(technology);
            //in a database write the access,commit the transaction
            sqlSession.commit();
        }
        // return HttpResponse.registerNatives (HttpStatus.CREATED).body("success:neue Technologie wurde gespeichert");
    }

    @Override
    public void removeTechnology(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            getTechnologyMapper(sqlSession).removeTechnology(id);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Integer id, String name, String description, Integer relevance,
                       Integer recommendation, Integer complexity, String url, List<String> tags) {
        ObjectMapper objectMapper= new ObjectMapper();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            getTechnologyMapper(sqlSession).
                    update(id, name,description,relevance,recommendation,complexity,url,objectMapper.convertValue(tags, ArrayList.class));
            sqlSession.commit();
        }
//asil o degisiskligi burda yapman lazimdi
    }
}
