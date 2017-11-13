/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import arjonator.Arjonator;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author felip
 */
public class ArjonatorConsoleUI {
    private Arjonator arjonator;
    private Scanner scanner;
    
    public ArjonatorConsoleUI(Arjonator arjonator) throws IOException {
        this.arjonator = arjonator;
        scanner = new Scanner(System.in);
        handleConsoleMenu();
    }

    private void handleConsoleMenu() {
        deployMenu();
        int selectedOption = Integer.parseInt(scanner.nextLine());
        selectOption(selectedOption);
        handleConsoleMenu();
    }

    private void deployMenu() {
        String menu = "\n--- Arjonator ---";
        menu += "\n1. Get random line.";
        menu += "\n2. Exit.\n";     
        System.out.println(menu);
    }
    
    private void selectOption(int selectedOption) {
        switch (selectedOption) {
            case 1:
                System.out.println(arjonator.getRandomLine());
                break;                
            case 2:
                System.exit(0);
                break;
        }
    }   
}
