package faangschool.hash_map.counting_absenteeism;

import faangschool.hash_map.library_of_westeros.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Student> studentList = new ArrayList<>();
    public static void main(String[] args) {
        studentList.add(new Student("Igor", "Math", 1));
        studentList.add(new Student("Katya", "Math", 1));
        studentList.add(new Student("Anton", "Physics", 2));
        studentList.add(new Student("Azat", "Physics", 2));
        studentList.add(new Student("Georgy", "History", 3));
        studentList.add(new Student("Gor", "History", 3));
        FacultyAndYear facultyAndYear = new FacultyAndYear("Math", 1);
        findAllStudents();
        System.out.println(findStudentsByFacultyAndYear(facultyAndYear));
    }
    public static HashMap<FacultyAndYear, List<Student>> listStudents(List<Student> entireStudent) {
        HashMap<FacultyAndYear, List<Student>> studentMap = new HashMap<>();
        for (Student student : entireStudent) {
            FacultyAndYear facultyAndYear = new FacultyAndYear(student.getFaculty(), student.getYear()); //к примеру создали пару Матан + 1 курс
            if (!studentMap.containsKey(facultyAndYear)) {
                studentMap.put(facultyAndYear, new ArrayList<>());
            }
            List<Student> students = studentMap.get(facultyAndYear);
            students.add(student);
        }
        return studentMap;
    }
    public static void addStudent (Student student) {
        studentList.add(student);
    }
    public static void removeStudent (Student student) {
        studentList.remove(student);
    }
    public static void findAllStudents () {
        for (Map.Entry<FacultyAndYear, List<Student>> entry: listStudents(studentList).entrySet()) {
            System.out.println("Faculty And Year: " + entry.getKey() + ", Student " + entry.getValue());
        }
    }
    public static List<Student> findStudentsByFacultyAndYear(FacultyAndYear facultyAndYear) {
        HashMap<FacultyAndYear, List<Student>> studentMap = listStudents(studentList);
        return studentMap.get(facultyAndYear);
    }
}
