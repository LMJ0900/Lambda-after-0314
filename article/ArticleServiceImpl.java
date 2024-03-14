package com.turing.api.article;

import java.sql.SQLException;
import java.util.List;

public class ArticleServiceImpl implements ArticleService{
    ArticleRepository repository = new ArticleRepository();
    private static ArticleServiceImpl instance;

    static {
        try {
            instance = new ArticleServiceImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArticleServiceImpl() throws SQLException {
    }

    public static ArticleServiceImpl getInstance() {
        return instance;
    }

    @Override
    public List<?> articlesList() throws SQLException {
        return repository.articleList();
    }
}
