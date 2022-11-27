package com.example.demo.dao;

import java.util.List;
public class PersonalInfoDao {
    public int hasregistered(AlumniDetails alumni){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        alumni.setStudent(session.get(Student.class,alumni.getStudent().getId()));
        Query fetchquery =session.createQuery("from AlumniDetails where student_id ="+alumni.getStudent().getId());
        AlumniDetails temp = (AlumniDetails) fetchquery.uniqueResult();
        transaction.commit();
        session.close();
        if(temp==null) {
            return 1;
        }
        else{
            System.out.println(temp.toString());
            System.out.println("User already has registered");
            return 0;
        }
    }
    public void insertAlumniDetails(AlumniDetails alumni){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        alumni.setStudent(session.get(Student.class,alumni.getStudent().getId()));

        session.save(alumni);
        transaction.commit();
        session.close();
    }
}
