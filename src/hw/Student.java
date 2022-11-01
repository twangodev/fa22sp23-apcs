package hw;

import java.util.Objects;

// James Ding
public class Student {

    private final String name;
    private Double gpa;
    private int numOfClass;

    public Double getGpa() {
        return gpa;
    }

    public Student(String name, Double gpa, int numOfClass) {
        this.name = name;
        this.gpa = gpa;
        this.numOfClass = numOfClass;
    }

    private double gradeToGpa(int grade) {
        if (grade >= 93) {
            return 4.0;
        } else if (grade >= 90) {
            return 3.7;
        } else if (grade >= 87) {
            return 3.3;
        } else if (grade >= 83) {
            return 3.0;
        } else if (grade >= 80) {
            return 2.7;
        } else if (grade >= 77) {
            return 2.3;
        } else if (grade >= 73) {
            return 2.0;
        } else if (grade >= 70) {
            return 1.7;
        } else if (grade >= 67) {
            return 1.3;
        } else if (grade >= 63) {
            return 1.0;
        } else if (grade >= 60) {
            return 0.7;
        } else {
            return 0.0;
        }
    }

    void takeClass(int grade, boolean ap) {
        double calculatedGpa = gradeToGpa(grade);
        if (ap) {
            calculatedGpa += 1;
        }
        gpa = (gpa * numOfClass + calculatedGpa) / (numOfClass + 1);
        numOfClass++;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                ", numOfClass=" + numOfClass +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return numOfClass == student.numOfClass && name.equals(student.name) && getGpa().equals(student.getGpa());
    }

    public static void main(String[] args) {
        Student james = new Student("James", 4.3, 1);
        james.takeClass(80, true); // AP Language Moment
        System.out.println(james);

        Student bryan = new Student("Bryan", 4.6, 1);
        bryan.takeClass(90, true); // AP Language moment
        System.out.println(bryan);

        System.out.println(james.equals(bryan));
    }

}
