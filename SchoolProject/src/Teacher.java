/*Class for teacher objects
 */

public class Teacher {
    //Fields
    private String firstName;
    private String lastName;
    private String subject;

    //Constructor
    Teacher (String fName, String lName, String sub) {
        firstName = fName;
        lastName = lName;
        subject = sub;
    }

    //Display teacher's info
    void printTchInfo(){
        System.out.println("Name: " + firstName + ", " + lastName + "\tSubject: " + subject);
    }

    //Getters and setters
    String getFirstName() {
        return firstName;
    }

    void setFirstName(String newFName){
        firstName = newFName;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String newLName){
        lastName = newLName;
    }
    String getSubject() {
        return subject;
    }

    void setSubject(String newSubject){
        subject = newSubject;
    }
}
