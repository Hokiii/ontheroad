package cn.hokii.ontheroad.service.impl;

import cn.hokii.ontheroad.dao.ArticleDao;
import cn.hokii.ontheroad.model.Article;
import cn.hokii.ontheroad.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> getAll() {
        return articleDao.getAll();
    }

    @Override
    public List<Article> getTop5LikesArticles() {
        return articleDao.getTop5LikesArticles();
    }
}
