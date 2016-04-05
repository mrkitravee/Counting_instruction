/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comorfun;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kitravee
 */
public class ComOrFun {

    public static Map<String, Integer> frequencyMap;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        CountingInstruction x = new CountingInstruction("C:\\Users\\Kitravee\\Desktop\\ASSAMBLY.txt");
        x.displayData();
    }
}
    
