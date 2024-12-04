package Assignment;

public class Student {
    // Tính bao đóng - Encapsulation
    // Access modifiers
    private String name;
    private String id;
    private double mark;
    private String rank;

    // Constructors
    public Student(String id, String name, double mark) {
        this.name = name;
        this.id = id;
        this.mark = mark;
        setRank();
    }

    public Student(String[] data) {
        this.id = data[0];
        this.name = data[1];
        this.mark = Double.valueOf(data[2]);
        setRank();
    }

    public String convertToRank() {
        if (mark > 0 && mark <= 5) {
            return "Fail";
        } else if (mark < 6.5) {
            return "Medium";
        } else if (mark < 7.5) {
            return "Good";
        } else if (mark < 9) {
            return "Very Good";
        } else if (mark <= 10) {
            return "Excellent";
        } else {
            System.out.println("Invalid");
            return null;
        }
    }

    public void setRank() {
        this.rank = convertToRank();
    }

    public String getId() {
        return id;
    }
    
    public double getMark() {
        return mark;
        
    }
    public void print() {
        System.out.println("Student Name:" + name);
        System.out.println("Student Id:" + id);
        System.out.println("Mark:" + mark);
        System.out.println("Rank:" + rank);
    }
}