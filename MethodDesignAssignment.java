/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.methoddesignassignment;

/**
 *
 * @author SChang2026
 */
// Base Student and Course classes with required functionality
class Course {
    private String name;
    private int testScore;

    // Constructor
    public Course(String name) {
        this.name = name;
        this.testScore = 0; // Initialize test score to zero
    }

    // Getter and Setter for testScore
    public void setTestScore(int score) {
        this.testScore = score;
    }

    public int getTestScore() {
        return testScore;
    }

    @Override
    public String toString() {
        return name + " (Score: " + testScore + ")";
    }
}

class Student {
    private String name;
    private int id;
    private Course[] courses;

    // Constructor
    public Student(String name, int id, String[] courseNames) {
        this.name = name;
        this.id = id;
        this.courses = new Course[3];
        for (int i = 0; i < 3; i++) {
            this.courses[i] = new Course(courseNames[i]);
        }
    }

    // Set test score for a specific course
    public void setTestScore(int courseIndex, int score) {
        if (courseIndex >= 0 && courseIndex < 3) {
            courses[courseIndex].setTestScore(score);
        } else {
            System.out.println("Invalid course index.");
        }
    }

    // Get test score for a specific course
    public int getTestScore(int courseIndex) {
        if (courseIndex >= 0 && courseIndex < 3) {
            return courses[courseIndex].getTestScore();
        } else {
            System.out.println("Invalid course index.");
            return -1;
        }
    }

    // Calculate average test score
    public double getAverage() {
        int total = 0;
        for (Course course : courses) {
            total += course.getTestScore();
        }
        return total / 3.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name: ").append(name).append(", ID: ").append(id).append("\n");
        sb.append("Courses:\n");
        for (Course course : courses) {
            sb.append("  ").append(course.toString()).append("\n");
        }
        sb.append("Average Score: ").append(getAverage()).append("\n");
        return sb.toString();
    }
}

public class MethodDesignAssignment {
    public static void main(String[] args) {
        // Example usage
        String[] courses = {"AP Calculus BC", "AP Chemistry", "AP Language and Composition"};
        Student student = new Student("Ann", 2026001, courses);

        student.setTestScore(0, 91);
        student.setTestScore(1, 94);
        student.setTestScore(2, 97);

        System.out.println(student);

        // Adding another student
        Student student2 = new Student("Travis", 2026002, courses);
        student2.setTestScore(0, 98);
        student2.setTestScore(1, 86);
        student2.setTestScore(2, 80);

        System.out.println(student2);
    }
}
