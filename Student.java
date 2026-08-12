public class Student {
    private String id;
    private String name;
    private int age;
    private String grade;

    // Constructor to initialize a student object
    public Student(String id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Method to neatly display individual student details
    public void displayStudent() {
        System.out.printf("ID: %-8s | Name: %-20s | Age: %-5d | Grade: %-5s%n", id, name, age, grade);
    }
}
