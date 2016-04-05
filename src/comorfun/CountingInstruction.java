/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comorfun;

import static comorfun.ComOrFun.frequencyMap;
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
public class CountingInstruction {

    public static Map<String, Integer> frequencyMap;
    String directory;
    ArrayList<Integer> arr = new ArrayList<Integer>();
    ArrayList<String> arr2 = new ArrayList<String>();

    CountingInstruction(String directory) throws IOException {
        this.directory = "C:\\Users\\Kitravee\\Desktop\\ASSAMBLY.txt";
        this.frequencyMap = new HashMap<>();
        writeToHash();
        bubbleSort();
    }

    private void writeToHash() throws FileNotFoundException, IOException {
        String word;
        if (directory.endsWith(".txt") || directory.endsWith(".csv")) {
            BufferedReader reader = new BufferedReader(new FileReader(directory));
            String line;
            //read each line
            while ((line = reader.readLine()) != null ) {
                if ( line.trim().length() == 0 ) {
                    continue;  // Skip blank lines
                } // otherwise:
                if (line.indexOf("!") > -1) {
                    continue;
                }
                String linetrim = line.trim();
                String[] array = linetrim.split(":");
                int num = array[1].trim().indexOf(" ");
                if (num != -1) {//NOP 
                    word = array[1].trim().substring(0, num);
                } else {//other case
                    word = array[1].trim();
                }

                // write to hashtable
                Integer value = frequencyMap.get(word.toLowerCase());
                if (value != null) {
                    frequencyMap.put(word.toLowerCase(), value + 1);
                } else {
                    frequencyMap.put(word.toLowerCase(), 1);
                }

            }
            reader.close();
            
        }
        //write to array list
        this.arr = new ArrayList<Integer>(frequencyMap.values());
        this.arr2 = new ArrayList<String>(frequencyMap.keySet());
    }

    private void bubbleSort() {
        boolean swapped = true;
        int j = 0;
        int tmp;
        String tmp2;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < this.arr.size() - j; i++) {
                if (this.arr.get(i) < this.arr.get(i + 1)) {
                    tmp = this.arr.get(i);
                    tmp2 = this.arr2.get(i);

                    this.arr.set(i, this.arr.get(i + 1));
                    this.arr2.set(i, this.arr2.get(i + 1));

                    this.arr.set(i + 1, tmp);
                    this.arr2.set(i + 1, tmp2);
                    swapped = true;
                }
            }
        }
    }

    public String getWord(int index) {
        return arr2.get(index);
    }

    public int getFrequency(int index) {
        return arr.get(index);
    }
    
    public void setDirectory(String directory){
        this.directory = directory;
    }
    
    public String getDirectory(){
        return this.directory;
    }

    public void displayData() {
        int sumFq = 0;
        System.out.println("No.  |  frequency   |   Instruction  ");
        System.out.println("---------------------------------------");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println((i + 1) + "    |    " + arr.get(i) + "        |      " + arr2.get(i));
            System.out.println("---------------------------------------");
            sumFq = sumFq + arr.get(i);
        }
        System.out.println("There are : "+sumFq+" instructions ");
    }
    

}
