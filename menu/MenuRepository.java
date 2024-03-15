package com.turing.api.menu;


import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.turing.api.enums.Messenger;

import static java.awt.SystemColor.menu;

public class MenuRepository {
    @Getter
    private static final MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private MenuRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                "turing",
                "password");
        pstmt = null;
        rs = null;
    }


    public List<?> getMenusByCategory(String category) {
        String sql = "SELECT m.item FROM menus m WHERE category = ?";
        List<Menu> menus = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category);
            rs = pstmt.executeQuery();
            while (rs.next()) menus.add(Menu.builder().item(rs.getString(1)).build());
        } catch (SQLException e) {
            System.err.println("SQL Exception Occurred");
            return menus;
        }
        return menus;
    }

    public void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS menus (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    categories VARCHAR(20) NOT NULL,\n" +
                "    item VARCHAR(20) NOT NULL\n" +
                ");";
        pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
    }

    public void insertMenu(Menu build) throws SQLException {
        String sql = "INSERT INTO menus(categories,item) VALUES(?,?);";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, build.getCategory());
        pstmt.setString(2, build.getItem());
        int a = pstmt.executeUpdate();
        System.out.println(a);
    }

    public void deleteTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS menus;";
        pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
    }

    public Messenger returnMessenger() throws SQLException {
        String sql ="";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        Messenger m = (rs.next())? Messenger.SUCCESS:Messenger.FAIL;
        return m;
    }

    public List<?> returnAllMenu() throws SQLException {

        String sql ="SELECT * FROM menus;";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        List<Menu> ls = new ArrayList<>();
        if(rs.next()){
            do{
                Menu m = Menu.builder()
                        .item(rs.getString("item"))
                        .category(rs.getString("category"))
                        .build();
                ls.add(m);
            }while (rs.next());
        }else {
            System.out.println("NO Data");
        }
        return ls;
    }

    public Menu returnOneMenu() throws SQLException {
        String sql = "";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        Menu m = null;
       if(rs.next()){
           m= Menu.builder()
                   .item(rs.getString("item"))
                   .category(rs.getString("category"))
                   .build();
       }
       return m;
    }

    public List<String> getNAVI() throws SQLException {
        List<String> ls = new ArrayList<>();
        String sql ="SELECT item FROM menus";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        if(rs.next()){
            do{
                ls.add(rs.getString("item"));
            }while (rs.next());
        }else {
            System.out.println("데이터 없음");
        }


        return ls;
    }
}