package isp.lab6.exercise1;

import org.junit.Assert;
import org.junit.Test;

public class TestExercise1 {
    @Test
    public void testGradeSystem(){
        GradeManagementSystem system = new GradeManagementSystem();
        Student student1 = new Student("Alice", "1001");
        Student student2 = new Student("Bob", "1002");
        Student student3 = new Student("Jack", "1003");


        system.addStudent(student1);
        system.addStudent(student2);
        system.addStudent(student3);


        system.addStudentGrade("1001", "Math", 90);
        system.addStudentGrade("1002", "Math", 85);
        system.addStudentGrade("1003", "Math", 68);

        system.removeStudentById("1001");
        system.removeStudentByName("Jack");


        system.updateStudent("1002", "Bobby");
        Assert.assertEquals(student2.getName(), "Bobby");
    }
}
