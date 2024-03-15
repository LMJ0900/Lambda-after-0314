package com.turing.api.article;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleController {
 ArticleServiceImpl service;

    public ArticleController() {
        this.service = ArticleServiceImpl.getInstance();
    }

    public List<?> articlesList(Scanner sc) throws SQLException {
        return service.articlesList();
    }
}
