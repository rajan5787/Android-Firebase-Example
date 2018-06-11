package rajan5787.tikuraja.androidfirebaseexample;

/**
 * Created by rajanpipaliya on 11/06/18.
 */

public class Student {

    public String name;
    public String email;
    public String number;
    public String standard;

    // Default constructor required for calls to
    // DataSnapshot.getValue(Student.class)
    public Student() {
    }

    public Student(String name, String email, String number, String standard) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.standard = standard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }
}