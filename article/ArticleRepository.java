package com.turing.api.article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    Connection connection;
    private static ArticleRepository instance;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArticleRepository() throws SQLException {

        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                "turing",
                "password");
    }

    public static ArticleRepository getInstance() {
        return instance;
    }


    public List<?> articleList() throws SQLException {
        List<?> list = new ArrayList<>();
        String sql = "select * from articles";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            do {
//            System.out.printf("ID: %d\t Title : %s\t content: %s\t Writer: %s\n",
//                    int id = rs.getInt(title);
//                    String title = rs.getString(content);
//                    String content= rs.getString(writer);
//                    String registerDate=  rs.getString(register_date);
                    Article a = Article.builder()
                            .id(rs.getLong("id"))
                            .title(rs.getString("title"))
                            .content(rs.getString("content"))
                            .writer(rs.getString("writer"))
                            .registerDate(rs.getString("register_date"))
                            .build();
        }while (rs.next());
    }else{
        System.out.println("데이터가 없습니다");
    }
        rs.close();
        pstmt.close();
        connection.close();

        return list;
    }
}
