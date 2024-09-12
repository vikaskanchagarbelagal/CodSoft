package Intern;

import java.util.Scanner;

class Marks {
    private int subjects;
    private float totalMarks = 0;
    private float[] marks;

    public Marks() {
        System.out.print("Enter the number of subjects: ");
        Scanner sc = new Scanner(System.in);
        subjects = sc.nextInt();
        marks = new float[subjects];
        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
            marks[i] = sc.nextFloat();
            totalMarks += marks[i];
        }
        sc.close();
    }

    public float getTotal() {
        return totalMarks;
    }

    public int getSubject() {
        return subjects;
    }
}

class Grade {
    private float avgPercent;
    private String grade;

    public Grade(float totalMarks, int subjects) {
        avgPercent = (totalMarks / (subjects * 100)) * 100;
        grades();
    }

    private void grades() {
        if (avgPercent >= 90) {
            grade = "O";
        } else if (avgPercent >= 80) {
            grade = "A+";
        } else if (avgPercent >= 70) {
            grade = "A";
        } else if (avgPercent >= 60) {
            grade = "B+";
        } else if (avgPercent >= 50) {
            grade = "B";
        } else if (avgPercent >= 40) {
            grade = "C";
        } else if (avgPercent >= 35) {
            grade = "D";
        } else {
            grade = "F";
        }
    }
    
    public float getAvgPercent() {
        return avgPercent;
    }

    public String getGrade() {
        return grade;
    }
}

public class studentResult {
    public static void main(String[] args) {
        Marks m = new Marks();
        Grade g = new Grade(m.getTotal(), m.getSubject());

        System.out.println("\nTotal Marks: " + m.getTotal());
        System.out.println("Average Percentage: " + g.getAvgPercent() + "%");
        System.out.println("Grade: " + g.getGrade());
    }
}
