package com.turing.api.menu;

import com.turing.api.enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;

public class MenuController {
    @Getter
    private static final MenuController instance = new MenuController();
    private final MenuService menuService;
    private MenuController(){
        menuService = MenuServiceImpl.getInstance();
    }

    public List<?> getMenusByCategory(String category){
        return menuService.getMenusByCategory(category);
    }

    public void createTable() throws SQLException {
        menuService.createTable();
    }

    public void insertMenu() throws SQLException {
        menuService.insertMenu();
    }

    public void deleteTable() throws SQLException {
        menuService.deleteTable();
    }

    public Messenger returnMessenger() throws SQLException {
        Messenger m = menuService.returnMessenger();
        return m;
    }

    public List<?> returnAllMenu() throws SQLException {
        List<?> m = menuService.returnAllMenu();
        return m;
    }

    public Menu returnOneMenu() throws SQLException {
        Menu m = menuService.returnOneMenu();
        return m;
    }

    public List<String> getNAVI() throws SQLException {
        return menuService.getNAVI();
    }
}
