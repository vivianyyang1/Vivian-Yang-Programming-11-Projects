/*This program copies each line of in.txt into its own element of an ArrayList, and also search for the line that a certain word is in.
 *Creator: Vivian Yang
 * Date: September 2, 2022
 */
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<String> lines;
    public static void main(String[] args) throws IOException {
        lines = new ArrayList<>(); //change variable lines into field, so it can be accessed in the search method below
        FileReader fr = new FileReader("in.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null) {
            if(line.length() != 0)
                lines.add(line);
        }
        br.close();
        for(String s: lines) {
            System.out.println(s);
        }
        //call searchWord method to search a word you pick (I picked "programs")
        //use an ArrayList<Integer> variable to hold its return value
        //use a for each loop to run through the ArrayList<Integer> to print all positions
        String word = "programs";
        ArrayList<Integer> posits = searchWord(word);
        System.out.println("\nThe positions for " + "\""+word + "\"" + ":");
        for(Integer n: posits) {
            System.out.println(n);

        }
    }

    //create method that can search for a word in the entire text, return every index position of the arraylist that the word is in
    public static ArrayList<Integer> searchWord(String word){
        //Create an ArrayList<Integer>
        ArrayList <Integer> positions = new ArrayList<>();
        //use for loop to search through the lines for each occurance of a word, and put their index into
        //the array listArrayList<Integer> created above
        for(int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            String[] words = line.split(" ");
            for(int j= 0; j < words.length; j++) {
                if (words[j].equals(word)) {
                    positions.add(Integer.valueOf(i));
                    break; //Stop searching in this line when one occurance is found
                }
            }
        }

        //return the array list
        return positions;
    }
}
