package faangschool.hash_map.counting_absenteeism;

import java.util.Objects;

public class FacultyAndYear {
    private String faculty;
    private int year;

    public String getFaculty() {
        return faculty;
    }


    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyAndYear that = (FacultyAndYear) o;
        return year == that.year && Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

    public FacultyAndYear(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public String toString() {
        return "FacultyAndYear{" +
                "faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }
}
