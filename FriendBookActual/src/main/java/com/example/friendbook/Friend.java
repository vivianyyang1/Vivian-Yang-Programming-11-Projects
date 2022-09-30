/*This class creates Friend object
 *Creator: Vivian Yang
 * Date: September 1, 2022
 */

package com.example.friendbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {//create variables
    public String name;
    public String trait;
    private int age;

    Friend (String name, String trait, int age) {//constructor
        this.name = name;
        this.trait = trait;
        this.age = age;
    }

    public void writeToFile() throws IOException{//format for writing friend object to file friends.txt
        FileWriter fw = new FileWriter("friends.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + ",\r");
        bw.write(trait + "&\r");
        bw.write(age + "\r");
        bw.write(";\r");
        bw.close();
    }

    public int getAge() {//getter for age
        return age;
    }

    public void setAge(int age) {//setter for age
        this.age = age;
    }

    public String toString() {
        return name;
    }
}
