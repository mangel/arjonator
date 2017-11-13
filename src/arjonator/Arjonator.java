/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjonator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author felip
 */
public class Arjonator {
    
    // Constantes
    private static final String FILE_PATH = "./data/arjonator_file.txt";
    
    private ArrayList<String> lines;
    
    private Random randomGenerator;
    
    public Arjonator() throws IOException {
        lines = new ArrayList<>();
        loadFile();
        randomGenerator = new Random();
    }

    public String getRandomLine() {
        int randomIndex = randomGenerator.nextInt(lines.size());
        String randomLine = lines.get(randomIndex);
        return randomLine;
    }
    
    private void loadFile() throws FileNotFoundException, IOException {
        File arjonatorFile = new File(FILE_PATH);
        BufferedReader br = new BufferedReader(new FileReader(arjonatorFile));
        
        String line = br.readLine();
        while (line != null) {
            lines.add(line);
            line = br.readLine();
        }
        
        br.close();        
    }
    
}
