package btcodever4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        PersonList personList = new PersonList();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("1.Add new student");
            System.out.println("2. Add new teacher");
            System.out.println("3. Update person by id");
            System.out.println("4. Delete person by id");
            System.out.println("5. Display all students and teachers");
            System.out.println("6. Find the student with the highest GPA");
            System.out.println("7. Find teachers by department");
            System.out.println("8. Exit");
            System.out.println("----------------------------");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println("----------------------------");
            switch (choice) {
                case 1:
                    System.out.print("Enter ID studen: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Full Name Student: ");
                    String fullName = sc.nextLine();
                    System.out.print("Enter Date Of Birth Student: ");
                    String dateOfBirth = sc.nextLine();
                    Date date = null;
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        date = sdf.parse(dateOfBirth);

                    } catch (Exception e) {
                        System.out.println("Wrong format!");
                    }
                    System.out.print("Enter GPA: ");
                    float gpa = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Enter Major: ");
                    String major = sc.nextLine();
                    personList.addStudent(new Student(gpa, major, id, fullName, date));
                    System.out.println("----------------------------");
                    break;
                case 2:
                    System.out.print("Enter ID Teacher: ");
                    String id1 = sc.nextLine();
                    System.out.print("Enter fullName Teacher: ");
                    String fullName1 = sc.nextLine();
                    System.out.print("Enter Date Of Birth Teacher: ");
                    String dateOfBirth1 = sc.nextLine();
                    Date date1 = null;
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        date1 = sdf.parse(dateOfBirth1);
                    } catch (Exception e) {
                        System.out.println("Wrong format!");
                    }
                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();
                    System.out.print("Enter Teaching Subject: ");
                    String teachingSubject = sc.nextLine();
                    personList.addTeacher(new Teacher(department, teachingSubject, id1, fullName1, date1));
                    System.out.println("----------------------------");
                    break;
                case 3:
                    System.out.print("Enter ID To Update: ");
                    String idUpdate = sc.nextLine();
                    personList.updatePerson(idUpdate);
                    System.out.println("----------------------------");
                    break;
                case 4:
                    System.out.print("Enter ID To Delete: ");
                    String idDelete = sc.nextLine();
                    personList.deletePersonById(idDelete);
                    break;
                case 5:
                    System.out.println("Display All: ");
                    personList.displayEveryone();
                    System.out.println("----------------------------");
                    break;
                case 6:
                    System.out.println("The student with highest GPA: ");
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        topStudent.displayInfo();
                    } else {
                        System.out.println("Not found student");
                    }
                    System.out.println("----------------------------");
                    break;
                case 7:
                    System.out.print("Enter department find teachers: ");
                    String department1 = sc.nextLine();
                    Teacher teacher = personList.findTeacherByDepartment(department1);
                    if (teacher != null) {
                        teacher.displayInfo();
                    } else {
                        System.out.println("Not found teacher");
                    }
                    System.out.println("----------------------------");
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again");
            }

        }
    }
}
