/*This class creates Friend object
 *Creator: Vivian Yang
 * Date: September 1, 2022
 */

package com.example.friendbook;

public class Friend {//create variables
    public String name;
    public String trait;
    private int age;

    Friend (String name, String trait, int age) {//constructor
        this.name = name;
        this.trait = trait;
        this.age = age;
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
