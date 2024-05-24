package isp.lab6.exercise1;

import java.util.HashMap;

public class Student {
    private String name;
    private String id;
    private HashMap<String, Integer> grades;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void getId(String id) {
        this.id = id;
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0;
        }
        int total = 0;
        for (int grade : grades.values()) {
            total += grade;
        }
        return (double) total / grades.size();
    }

    public HashMap<String, Integer> getGrades() {
        return grades;
    }
}
