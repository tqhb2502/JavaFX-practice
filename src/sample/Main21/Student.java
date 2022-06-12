package sample.Main21;

public class Student {
    private String studentID;
    private String name;
    private String email;
    private int age;
    private String major;

    public Student(String studentID, String name, String email, int age, String major) {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.age = age;
        this.major = major;
    }

    public Student() {
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }
}
