package com.example.demo.service;
import com.example.demo.bean.EmployeeEducation;
import com.example.demo.dao.OrganizationInfoDao;
import com.example.demo.dao.PersonalInfoDao;

import java.util.List;

public class EmployeeRegistration {
    EInfoDAO eInfoDAO = new EInfoDAO();
    PInfoDAO pInfoDAO = new PInfoDAO();
    OInfoDAO oInfoDAO = new OInfoDAO();
    public void seteInfoDAO(EInfoDAO eInfoDAO){
        this.eInfoDAO = eInfoDAO;
    }
    public void setEmployeeInfoDao(PersonalInfoDao pInfoDAO){ this.pInfoDAO = pInfoDAO; }
    public void setOrganizationInfoDAO(OrganizationInfoDao oInfoDAO){ this.oInfoDAO=oInfoDAO;}

    public int insert_pinfo(AlumniDetails alumni){
        System.out.println("Service Layer hit");
        int returnvalue= pInfoDAO.hasregistered(alumni);
        System.out.println(returnvalue);
        if(returnvalue==1){
            pInfoDAO.insertAlumniDetails(alumni);
            return 1;
        }
        else
            return -1;
    }

    public int insert_einfo(List<EmployeeEducation> edetails){

        int returnvalue = eInfoDAO.hasregistered(edetails.get(0).getAlumni().getId());
        if(returnvalue==0){
            return -1;
        }
        eInfoDAO.insertAlumniEducationDetails(edetails);
        return  1;

    }

    public int insertOrganizationinfo(List<AlumniOrganisation> odetails){

        oInfoDAO.insertAlumniOrganisationDetails(odetails);
        return  1;

    }
}
