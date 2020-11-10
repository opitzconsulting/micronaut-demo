package com.opitzconsulting.demo.micronaut.genre;

import com.opitzconsulting.demo.micronaut.model.Tags;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class TagMapperImpl implements TagMapper{
    private final SqlSessionFactory sqlSessionFactory;

    public TagMapperImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private TagMapper getTagMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(TagMapper.class);
    }

    @Override
    public Tags getTag(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return getTagMapper(sqlSession).getTag(id);

        }
    }

    @Override
    public void insertTag(Tags tag) {
        // Use try-with-resources to automatically close the sql session.
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            getTagMapper(sqlSession).insertTag(tag);
            //in a database write the access,commit the transaction
            sqlSession.commit();
        }

    }

    @Override
    public List<Tags> getTags() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return getTagMapper(sqlSession).getTags();
        }
    }
}
