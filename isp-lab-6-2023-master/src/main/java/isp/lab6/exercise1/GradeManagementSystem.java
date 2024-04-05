package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.List;

public class GradeManagementSystem {
    private List<Student> students;

    public GradeManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addStudentGrade(String id, String subject, int grade) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.addGrade(subject, grade);
                return;
            }
        }
        System.out.println("Student not found with ID: " + id);
    }

    public void removeStudentById(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public void removeStudentByName(String name) {
        students.removeIf(student -> student.getName().equals(name));
    }

    public void updateStudent(String id, String newName) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(newName);
                return;
            }
        }
        System.out.println("Student not found with ID: " + id);
    }


    public String toString() {
        String newString = null;
        for (Student student : students) {
            newString = newString + "Name: " + student.getName() + ", ID: " + student.getId() + '\n';
        }
        return newString;
    }

    public void displayStudents() {
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", ID: " + student.getId());
        }
        System.out.println("------------------------------");
    }
}
