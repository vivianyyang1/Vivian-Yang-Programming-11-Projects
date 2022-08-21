/*This module is for School class.
 *Contains 6 fields for teachers, students, courses,
  the school's name, phone number, and principal's name
 *Methods: getters and setters for the fields of
  the school's name, phone number, and principal's name,
  and also for adding/deleting a teacher or student
  and finally, showing all students/teachers
 */
import java.util.ArrayList;

public class School {
    //Fields
    public ArrayList<Teacher> teachers = new ArrayList<>();
    public ArrayList<Student> students = new ArrayList<>();
    private ArrayList<String> courses = new ArrayList<>();
    private String schoolName;
    private String phoneNum;
    private String principal;

    //Constructor
    School(ArrayList<Teacher> tchs, ArrayList<Student> stds, String sName, String pNum, String princ) {
        teachers = tchs;
        students = stds;
        schoolName = sName;
        phoneNum = pNum;
        principal = princ;

        //Add 6 courses into courses list
        courses.add("English");
        courses.add("Math");
        courses.add("Physics");
        courses.add("Chemistry");
        courses.add("Biology");
        courses.add("Social Studies");
    }

    //Getters and setters for school name, phone number, and principal
    String getSchoolName() {
        return schoolName;
    }
    void setSchoolName(String newSName) {
        schoolName = newSName;
    }
    String getPhoneNum() {
        return phoneNum;
    }
    void setPhoneNum(String newPNUm) {
        phoneNum = newPNUm;
    }
    String getPrincipal() {
        return principal;
    }
    void setPrincipal(String newPrinc) {
        principal = newPrinc;
    }

    //add/delete a teacher from the list
    void addATeacher(Teacher tch) {
        teachers.add(tch);
    }
    void deleteATeacher(Teacher tch) {
        teachers.remove(tch);
    }

    //add/delete a student from the list
    void addAStudent (Student std) {
        students.add(std);
    }
    void deleteAStudent(Student std) {
        students.remove(std);
    }

    //show all teachers/students
    void showAllTeachers() {
        for(int i = 0; i < teachers.size(); i++) {
            teachers.get(i).printTchInfo();
        }
    }
    void showAllTStudents() {
        for(int i = 0; i < students.size(); i++) {
            students.get(i).printStdInfo();
        }
    }
}

