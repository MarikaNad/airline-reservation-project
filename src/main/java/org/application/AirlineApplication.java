package org.application;

import ui.MainMenu;

public class AirlineApplication
{
    public static void main( String[] args )
    {

        System.out.println("------------------------------------------");
        System.out.println("WELCOME TO AIRLINE RESERVATION APPLICATION");

        MainMenu mainMenu = new MainMenu();
        mainMenu.enterMainMenu();


    }
}
