package com.example.demo.service;

import com.example.demo.bean.EmployeeDetails;
import com.example.demo.bean.Manager;

public class FetchEmployeeDetails {


    public List<Manager> getEmployee(Manager manager){


        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        Query fetchquery =session.createQuery("from Manager where fname like '%"+manager.getFname()+"%'" +
                " or lname like '%"+manager.getLname()+"%'" +
                " and year="+manager.getYear());
        List<Manager> Employeeilist= fetchquery.list();
        transaction.commit();
        session.close();
        return Employeeilist;
    }

    public boolean ispresent(EmployeeDetails employeeDetails){
        Session session = Main.getSession();

        Transaction transaction = session.beginTransaction();
        Query fetchquery =session.createQuery("from EmployeeDetails where student_id="+employeeDetails.getManager().getId());
        EmployeeDetails temp = (EmployeeDetails)  fetchquery.uniqueResult();
        transaction.commit();
        session.close();
        return  temp!=null;
    }
}
