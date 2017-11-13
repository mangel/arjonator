/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import arjonator.Arjonator;
import java.io.FileNotFoundException;
import java.io.IOException;
import ui.ArjonatorConsoleUI;
import ui.ArjonatorWindowUI;

/**
 *
 * @author felip
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Arjonator arjonator = new Arjonator();
            ArjonatorWindowUI arjonatorWindowUI = new ArjonatorWindowUI(arjonator);
            ArjonatorConsoleUI arjonatorConsole = new ArjonatorConsoleUI(arjonator);            
        } catch (FileNotFoundException fnfe) {
            System.out.println("The arjonator lines file doesn't exist");
            System.exit(0);
        } catch (IOException ioe) {
            System.out.println("There where a problem reading the lines from the arjonator file");
            System.exit(0);
        }
    }
    
}
