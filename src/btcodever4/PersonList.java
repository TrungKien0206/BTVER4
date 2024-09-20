package btcodever4;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PersonList {

    ArrayList<Person> personList;

    public PersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public PersonList() {
        this.personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public void addStudent(Student student) {
        personList.add(student);
        System.out.println("---------Student add successfully--------");
    }

    public void addTeacher(Teacher teacher) {
        personList.add(teacher);
        System.out.println("---------Teacher add successfully---------");
    }

    public void updatePerson(String id) {
        Person updatePerson = null;
        Scanner sc = new Scanner(System.in);
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                updatePerson = person;
                break;
            }
            
        }
        if (updatePerson != null) {
            if (updatePerson instanceof Student) {
                System.out.print("Enter New Full Name Student: ");
                String fullName = sc.nextLine();
                updatePerson.setFullName(fullName);
                System.out.print("Enter New Date Of Birth: ");
                String dateOfBirth = sc.nextLine();
                Date date = null;
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    date = sdf.parse(dateOfBirth);
                    updatePerson.setDateOfBirth(date);
                } catch (Exception e) {
                    System.out.println("Wrong format!");
                }
                System.out.print("Enter New GPA: ");
                float gpa = sc.nextFloat();
                ((Student) updatePerson).setGpa(gpa);
                sc.nextLine();
                System.out.print("Enter New Major: ");
                String major = sc.nextLine();
                ((Student) updatePerson).setMajor(major);

            } else if (updatePerson instanceof Teacher) {
                System.out.print("Enter New Full Name Teacher: ");
                String fullName1 = sc.nextLine();
                updatePerson.setFullName(fullName1);
                System.out.print("Enter New Date Of Birth: ");
                String dateOfBirth1 = sc.nextLine();
                Date date1 = null;
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    date1 = sdf.parse(dateOfBirth1);
                    updatePerson.setDateOfBirth(date1);
                } catch (Exception e) {
                    System.out.println("Wrong format!");
                }
                System.out.print("Enter New Department: ");
                String department = sc.nextLine();
                ((Teacher) updatePerson).setDepartment(department);
                System.out.print("Enter New Teaching Subject: ");
                String teachingSubject = sc.nextLine();
                ((Teacher) updatePerson).setTeachingSubject(teachingSubject);
            }
        }
    }

    public void deletePersonById(String id) {
        personList.removeIf(Person -> Person.getId().equals(id));

    }

    public Person findPersonById(String id) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }

        }
        return null;
    }

    public void displayEveryone() {
        for (Person person : personList) {
            person.displayInfo();
        }
    }

    public Student findTopStudent() {
        Student topToStudent = null;
        for (Person person : personList) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (topToStudent == null || ((Student) person).getGpa() > topToStudent.getGpa()) {
                    topToStudent = student;
                }
            }
        }
        return topToStudent;
    }

    public Teacher findTeacherByDepartment(String department) {
        for (Person person : personList) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDepartment().equals(department)) {
                    return teacher;
                }
            }
        }
        return null;
    }
}
