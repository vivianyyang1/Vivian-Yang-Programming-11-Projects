/*This program reads each saved friend object in the friends.txt and can print it out again
 *Creator: Vivian Yang
 * Date: September 3rd, 2022
 */
package com.example.friendbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriends {//variables
    private static String name;
    private static String trait;
    private static int age;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();

    //method to read file and determine which substring = one friend object
    public static ArrayList createAllFriends(String fileName) throws IOException {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String friendString = "";
        while((line = br.readLine()) != null) {
            if (!line.equals(";")){
                friendString += line;
            }
            else {
                parseFriend(friendString);
                friendString = "";
            }
        }
        return friends;
    }

    //assigns certain substring to name, trait, and age using loops to search for the "," and "&" on the friends.txt page
    private static void parseFriend(String string) {
        int pos = 0;
        int pos2 = 0;
        String name = "";
        String trait = "";
        int age = 0;
        for(int i = 0; i < string.length(); i++) {
            if (string.substring(i, i+1).equals(",")) {
                pos = i;
                name = string.substring(0, pos);
            }

            if (string.substring(i, i+1).equals("&")) {
                //pos = i;
                trait = string.substring(pos+1, i);
            }

        }
        for(int i = 0; i < string.length(); i++) {
            if (string.substring(i, i+1).equals("&")) {
                pos = i;
                age = Integer.parseInt(string.substring(pos+1));
            }
        }
        friends.add(new Friend(name, trait, age));//add new Friend object to array list
    }
}
