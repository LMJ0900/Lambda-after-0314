package com.turing.api.menu;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {


    List<?> getMenusByCategory(String category);

    void createTable() throws SQLException;


    void deleteTable() throws SQLException;

    void insertMenu() throws SQLException;

    Messenger returnMessenger() throws SQLException;

    List<?> returnAllMenu() throws SQLException;

    Menu returnOneMenu() throws SQLException;

    List<String> getNAVI() throws SQLException;
}
