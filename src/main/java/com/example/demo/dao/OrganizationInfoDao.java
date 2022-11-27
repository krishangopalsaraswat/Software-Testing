package com.example.demo.dao;

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

    public int insertAlumniOrganisationDetails(List<AlumniOrganisation> odetails){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        for(AlumniOrganisation odetail:odetails){
            odetail.setAlumni(session.get(AlumniDetails.class,odetail.getAlumni().getId()));
            Query fetchquery =session.createQuery("from Organisation where name='"+odetail.getOrganisation().getName()+"'" );
            Organisation org = (Organisation) fetchquery.uniqueResult();
            odetail.setOrganisation(org);
            session.save(odetail);
        }

        transaction.commit();
        session.close();
        return 1;

    }
}