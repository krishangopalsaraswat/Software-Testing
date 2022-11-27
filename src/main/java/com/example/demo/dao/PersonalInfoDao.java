package com.example.demo.dao;

import com.example.demo.bean.EmployeeDetails;
import com.example.demo.bean.Manager;
import com.sun.tools.javac.Main;
import org.springframework.boot.web.servlet.server.Session;

import javax.transaction.Transaction;
import java.util.List;
public class PersonalInfoDao {
    public int hasregistered(EmployeeDetails employeeDetails){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        employeeDetails.setManager(session.get(Manager.class,employeeDetails.getEmployee().getId()));
        Query fetchquery =session.createQuery("from EmployeeDetails where manager_id ="+manager.getManager().getId());
        EmployeeDetails temp = (EmployeeDetails) fetchquery.uniqueResult();
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
    public void insertEmployeeDetails(EmployeeDetails employeeDetails){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        employeeDetails.setManager(session.get(Manager.class,employeeDetails.getStudent().getId()));

        session.save(employeeDetails);
        transaction.commit();
        session.close();
    }
}
