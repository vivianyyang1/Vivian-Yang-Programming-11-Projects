/*This program creates a school object using classes, objects, and array lists.
 *Creator: Vivian Yang
 *Date: August 21, 2022
 */
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    ArrayList<Student> students = new ArrayList<Student>();//create an array list for students
        //create 10 student objects and add them into array list
    Student std = new Student("Vivian", "Yang", "11");
    students.add(std);
    std = new Student("Karen", "Lee", "8");
    students.add(std);
    std = new Student("Ben", "Cho", "12");
    students.add(std);
    std = new Student("Kevin", "Murray", "9");
    students.add(std);
    std = new Student("Sarah", "Crosby", "10");
    students.add(std);
    std = new Student("Nina", "Clement", "12");
    students.add(std);
    std = new Student("Austin", "Hooverman", "11");
    students.add(std);
    std = new Student("Brian", "Yip", "10");
    students.add(std);
    std = new Student("Ashley", "Min", "9");
    students.add(std);
    std = new Student("Bob", "Fu", "8");
    students.add(std);

    ArrayList<Teacher> teachers = new ArrayList<Teacher>();//create an array list for teacher
        //create 3 teacher objects and add them into teachers array list
    Teacher tch = new Teacher("Dan", "Smith", "Math");
    teachers.add(tch);
    tch = new Teacher("Anne", "Wong", "Chemistry");
    teachers.add(tch);
    tch = new Teacher("Elena", "Williams", "English");
    teachers.add(tch);

    //Create a school object by calling its constructor
    School school = new School(teachers, students, "Burnaby North", "888-888-8888", "Ron Woozley");

    //Display both lists
    school.showAllTStudents();
    school.showAllTeachers();

    //Remove last 2 students in the list
        school.deleteAStudent(school.students.get(students.size()-1));
        school.deleteAStudent(school.students.get(students.size()-1));
        System.out.println();
        school.showAllTStudents();

        //Remove first teacher in the list
        school.deleteATeacher(school.teachers.get(0));
        school.showAllTeachers();
    }
}

