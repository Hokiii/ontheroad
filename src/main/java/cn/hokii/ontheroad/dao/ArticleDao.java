package cn.hokii.ontheroad.dao;

import cn.hokii.ontheroad.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ArticleDao {
    @Select("select * from cars")
    List<Article> getAll();

    @Select("select * from articles order by collect desc,likes desc limit 1,5")
    List<Article> getTop5LikesArticles();
}
