package faangschool.hash_map.counting_absenteeism;

import java.time.Year;
import java.util.Objects;

public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student() {

    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return Objects.equals(faculty, student.getFaculty()) && Objects.equals(name, student.getName()) && year == student.getYear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculty); // я сюда не указал year, так как у студента меняется курс
    }

    @Override
    public String toString() {
        return "Student{" +
                "name = " + name +
                ", faculty = " + faculty +
                ", year = " + year + "}";
    }
}
