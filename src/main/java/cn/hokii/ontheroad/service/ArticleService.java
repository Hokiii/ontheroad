package cn.hokii.ontheroad.service;

import cn.hokii.ontheroad.model.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAll();

    List<Article> getTop5LikesArticles();
}
