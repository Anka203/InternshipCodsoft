import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;  

class Course {  
    String code, title, description;  
    int capacity, enrolled;  
    
    Course(String code, String title, String description, int capacity) {  
        this.code = code;  
        this.title = title;  
        this.description = description;  
        this.capacity = capacity;  
        this.enrolled = 0;  
    }  
}  

class Student {  
    String id, name;  
    List<Course> courses = new ArrayList<>();  
    
    Student(String id, String name) {  
        this.id = id;  
        this.name = name;  
    }  
}  

public class CourseRegistration {  
    static List<Course> courses = new ArrayList<>();  
    static List<Student> students = new ArrayList<>();  

    public static void main(String[] args) {  
        initializeCourses();  
        Scanner scanner = new Scanner(System.in);  
        String option;  
        do {  
            System.out.println("1. Register Student\n2. List Courses\n3. Register for Course\n4. Drop Course\n5. Exit");  
            System.out.print("Choose an option: ");  
            option = scanner.nextLine();  
            switch (option) {  
                case "1": registerStudent(scanner); break;  
                case "2": listCourses(); break;  
                case "3": registerForCourse(scanner); break;  
                case "4": dropCourse(scanner); break;  
                case "5": System.out.println("Goodbye!"); break;  
                default: System.out.println("Invalid option!");   
            }  
        } while (!option.equals("5"));  
        scanner.close();  
    }  

    static void initializeCourses() {  
        courses.add(new Course("CS101", "Intro to CS", "Basics of computer science.", 30));  
        courses.add(new Course("MA101", "Calculus I", "Intro to Calculus.", 25));  
        courses.add(new Course("PH101", "Physics I", "Principles of physics.", 20));  
    }  

    static void registerStudent(Scanner scanner) {  
        System.out.print("Enter student ID: ");  
        String id = scanner.nextLine();  
        System.out.print("Enter student name: ");  
        String name = scanner.nextLine();  
        students.add(new Student(id, name));  
        System.out.println("Student registered!");  
    }  

    static void listCourses() {  
        System.out.println("Available Courses:");  
        for (Course course : courses) {  
            System.out.printf("%s: %s (%d/%d)\n", course.code, course.title, course.enrolled, course.capacity);  
        }  
    }  

    static void registerForCourse(Scanner scanner) {  
        System.out.print("Enter student ID: ");  
        String id = scanner.nextLine();  
        Student student = findStudent(id);  
        if (student == null) { System.out.println("Student not found!"); return; }  
        
        listCourses();  
        System.out.print("Enter course code: ");  
        String code = scanner.nextLine();  
        Course course = findCourse(code);  
        if (course != null && course.enrolled < course.capacity) {  
            student.courses.add(course);  
            course.enrolled++;  
            System.out.println("Registered for " + course.title + "!");  
        } else {  
            System.out.println("Course not available.");  
        }  
    }  

    static void dropCourse(Scanner scanner) {  
        System.out.print("Enter student ID: ");  
        String id = scanner.nextLine();  
        Student student = findStudent(id);  
        if (student == null || student.courses.isEmpty()) {   
            System.out.println("No courses to drop or student not found.");   
            return;   
        }  
        
        System.out.println("Registered Courses:");  
        for (int i = 0; i < student.courses.size(); i++) {  
            System.out.printf("%d. %s\n", i + 1, student.courses.get(i).title);  
        }  
        System.out.print("Enter the number to drop: ");  
        int index = Integer.parseInt(scanner.nextLine()) - 1;  
        if (index >= 0 && index < student.courses.size()) {  
            Course course = student.courses.remove(index);  
            course.enrolled--;  
            System.out.println("Dropped " + course.title + "!");  
        } else {  
            System.out.println("Invalid selection.");  
        }  
    }  

    static Student findStudent(String id) {  
        return students.stream().filter(s -> s.id.equals(id)).findFirst().orElse(null);  
    }  

    static Course findCourse(String code) {  
        return courses.stream().filter(c -> c.code.equals(code)).findFirst().orElse(null);  
    }  
}