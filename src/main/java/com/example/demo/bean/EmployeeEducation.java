package com.example.demo.bean;

@Entity
public class EmployeeEducation {

    public EmployeeEducation(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private EmployeeDetails employee;
    @Column(nullable = false)
    private  String degree;
    @Column(nullable = false)
    private  int joining_year;
    @Column(nullable = false)
    private int passing_year;

    private String college_name;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmployeeDetails getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDetails employee) {
        this.employee = employee;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getJoining_year() {
        return joining_year;
    }

    public void setJoining_year(int joining_year) {
        this.joining_year = joining_year;
    }

    public int getPassing_year() {
        return passing_year;
    }

    public void setPassing_year(int passing_year) {
        this.passing_year = passing_year;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeeEducation{" +
                "id=" + id +
                ", employee=" + employee +
                ", degree='" + degree + '\'' +
                ", joining_year=" + joining_year +
                ", passing_year=" + passing_year +
                ", college_name='" + college_name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
