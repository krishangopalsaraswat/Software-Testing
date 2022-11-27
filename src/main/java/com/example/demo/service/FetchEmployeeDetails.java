package com.example.demo.service;

public class FetchEmployeeDetails {
    public List<Student> getAlumni(Student student){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        Query fetchquery =session.createQuery("from Student where fname like '%"+student.getFname()+"%'" +
                " or lname like '%"+student.getLname()+"%'" +
                " and year="+student.getYear());
        List<Student> alumnilist= fetchquery.list();
        transaction.commit();
        session.close();
        return alumnilist;
    }

    public boolean ispresent(AlumniDetails alumni){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        Query fetchquery =session.createQuery("from AlumniDetails where student_id="+alumni.getStudent().getId());
        AlumniDetails temp = (AlumniDetails) fetchquery.uniqueResult();
        transaction.commit();
        session.close();
        return  temp!=null;
    }
}
