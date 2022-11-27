package com.example.demo.dao;

import com.example.demo.bean.EmployeeDetails;
import com.example.demo.bean.EmployeeOrganization;
import com.example.demo.bean.Organisation;
import com.sun.tools.javac.Main;
import org.springframework.boot.web.servlet.server.Session;

import javax.management.Query;
import javax.transaction.Transaction;
import java.util.List;

public class OrganizationInfoDao {
    public static List<Organisation> getCompanyNames(){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        Query fetchquery =session.createQuery("from Organisation ");
        List<Organisation> companylist= fetchquery.list();
        transaction.commit();
        session.close();
        return companylist;
    }

    public int insertEmployeeOrganisationDetails(List<EmployeeOrganization> organizationDetails){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        for(EmployeeOrganization organizationDetail:organizationDetails){
            organizationDetail.setEmployee(session.get(EmployeeDetails.class,organizationDetail.getEmployee().getId()));
            Query fetchquery =session.createQuery("from Organisation where name='"+organizationDetail.getOrganisation().getName()+"'" );

            Organisation org = (Organisation) fetchquery.uniqueResult();
            organizationDetail.setOrganisation(org);
            session.save(organizationDetail);
        }

        transaction.commit();
        session.close();
        return 1;

    }
}
