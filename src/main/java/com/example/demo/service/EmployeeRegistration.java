package com.example.demo.service;
import com.example.demo.bean.EmployeeDetails;
import com.example.demo.bean.EmployeeEducation;
import com.example.demo.bean.EmployeeOrganization;
import com.example.demo.dao.EmployeeInfoDao;
import com.example.demo.dao.OrganizationInfoDao;
import com.example.demo.dao.PersonalInfoDao;

import java.util.List;

public class EmployeeRegistration {
    EmployeeInfoDao employeeInfoDao = new EmployeeInfoDao();
    PersonalInfoDao personalInfoDao = new PersonalInfoDao();
    OrganizationInfoDao organizationInfoDao = new OrganizationInfoDao();
    public void seteInfoDAO(EmployeeInfoDao employeeInfoDao){
        this.employeeInfoDao = employeeInfoDao;
    }
    public void setEmployeeInfoDao(PersonalInfoDao personalInfoDao){ this.personalInfoDao = personalInfoDao; }
    public void setOrganizationInfoDAO(OrganizationInfoDao organizationInfoDao){ this.organizationInfoDao=organizationInfoDao;}

    public int insertPersonalinfo(EmployeeDetails employeeDetails){
        System.out.println("Service Layer hit");
        int returnvalue= personalInfoDao.hasregistered(employeeDetails);
        System.out.println(returnvalue);
        if(returnvalue==1){
            personalInfoDao.insertEmployeeDetails(employeeDetails);
            return 1;
        }
        else
            return -1;
    }

    public int insertEmployeeinfo(List<EmployeeEducation> employeeEducations){

        int returnvalue = employeeInfoDao.hasregistered(employeeEducations.get(0).getEmployee().getId());
        if(returnvalue==0){
            return -1;
        }
        employeeInfoDao.insertEmployeeEducationDetails(employeeEducations);
        return  1;

    }

    public int insertOrganizationinfo(List<EmployeeOrganization> odetails){

        organizationInfoDao.insertEmployeeOrganisationDetails(employeeInfoDao);
        return  1;

    }
}
