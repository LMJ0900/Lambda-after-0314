package com.turing.api;

import com.turing.api.enums.Navigation;
import com.turing.api.enums.NavigationOfConsumer;
import com.turing.api.enums.NavigationOfPredicate;
import com.turing.api.enums.NavigationOfSupplier;
import com.turing.api.enums.NavigationOfFunction;
import com.turing.api.menu.MenuController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) throws IOException, SQLException {


         //MenuController.getInstance().createTable();
        //MenuController.getInstance().returnMessenger();
        //MenuController.getInstance().returnAllMenu();
        //MenuController.getInstance().returnOneMenu();
       MenuController.getInstance().insertMenu();
        //MenuController.getInstance().deleteTable();

        Scanner sc = new Scanner(System.in);
       /* while (NavigationOfFunction.selectMain(sc).equals("x")){

        }
        NavigationOfSupplier.selectMain(sc);
        NavigationOfConsumer.selectMain(sc);
        NavigationOfPredicate.selectMain(sc);
*/
        while (Navigation.selectmain(sc)) {

        }
    }



}


