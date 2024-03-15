package com.turing.api.menu;

import com.turing.api.enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;

public class MenuServiceImpl implements MenuService{
    @Getter
    private static final MenuService instance = new MenuServiceImpl();
    private final MenuRepository menuRepository;

    public MenuServiceImpl() {
        menuRepository = MenuRepository.getInstance();
    }


    @Override
    public List<?> getMenusByCategory(String category){
        return menuRepository.getMenusByCategory(category);
    }

    @Override
    public void createTable() throws SQLException {
        menuRepository.createTable();
    }


    @Override
    public void deleteTable() throws SQLException {
        menuRepository.deleteTable();
    }
        @Override
        public void insertMenu() throws SQLException {
        String[] categories = {"navigate", "Member", "account", "article", "board", "soccer"};
        String[][] menus = {{"x", "mem", "acc", "cwl", "art", "bbs","ssc"},
                {"x","mk ","joi", "log", "cat", "ch-pw", "rm",
                        "ls-a","ls-n","ls-job","cnt"},
                {"x", "mk ","touch", "with", "depo", "bal", "rm", "cat", "ls-a"},
                {"x", "mkdir ", },
                {"x", "mkdir "},
                {"x", "mkdir", },
                {}};

        for(int i = 0; i < menus.length; i++)
            for(int j = 0; j < menus[i].length; j++)
                menuRepository.insertMenu(Menu.builder().category(categories[i]).item(menus[i][j]).build());
    }

    @Override
    public Messenger returnMessenger() throws SQLException {
        Messenger m = menuRepository.returnMessenger();
        return m;
    }

    @Override
    public List<?> returnAllMenu() throws SQLException {
        List<?> m = menuRepository.returnAllMenu();
        return m;
    }

    @Override
    public Menu returnOneMenu() throws SQLException {
        Menu m = menuRepository.returnOneMenu();
        return m;
    }

    @Override
    public List<String> getNAVI() throws SQLException {
        return menuRepository.getNAVI();
    }
}