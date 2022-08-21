/*Class for student objects
 */
import java.util.Random;

public class Student {
    //Fields
    private String firstName;
    private String lastName;
    private String grade;
    int studentNum;

    //Constructor
    Student(String firstName, String lastName, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        Random rd = new Random();//create Random object
        this.studentNum = rd.nextInt(10000, 20000);//generate unique number as ID
    }

    //Getters and setters
    void printStdInfo(){
        System.out.println("Student Number: " + studentNum + "\tName: " + firstName + ", " + lastName + "\tGrade: " + grade);
    }
    String getFirstName() {
        return firstName;
    }

    void setFirstName(String newFName){
        firstName = newFName;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String newLName) {
        lastName = newLName;
    }
    String getGrade() {
        return grade;
    }
    void setGrade(String newGrade) {
        grade = newGrade;
    }
    int getStudentNum() {
        return studentNum;
    }
    void setStudentNum(int newSNum) {
        studentNum = newSNum;
    }
}

