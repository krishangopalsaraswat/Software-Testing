package com.example.demo.bean;

@Entity
public class EmployeeDetails {

    public EmployeeDetails(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String contact;

    @OneToOne()
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", student=" + student +
                '}';
    }
}
