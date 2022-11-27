package com.example.demo.dao;

import com.example.demo.bean.EmployeeDetails;
import com.example.demo.bean.EmployeeEducation;
import com.sun.tools.javac.Main;
import org.springframework.boot.web.servlet.server.Session;

import java.util.List;

public class EmployeeInfoDao {
    public void insertEmployeeEducationDetails(List<EmployeeEducation> edetails){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        for(EmployeeEducation edetail:edetails){
            edetail.setEmployee(session.get(EmployeeDetails.class,edetail.getEmployee().getId()));
            session.save(edetail);
        }


        transaction.commit();
        session.close();
    }

    public int hasregistered(int employee_id){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        Query fetchquery =session.createQuery("from EmployeeDetails where id ="+employee_id);
        EmployeeDetails temp = (EmployeeDetails) fetchquery.uniqueResult();
        transaction.commit();
        session.close();
        if(temp==null) {
            return 1;
        }
        else{
            //System.out.println(temp.toString());
            System.out.println("User already has registered");
            return 0;
        }
    }
}
