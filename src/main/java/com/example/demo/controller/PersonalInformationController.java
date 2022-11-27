package com.example.demo.controller;
import com.example.demo.bean.EmployeeDetails;
import com.example.demo.dao.PersonalInfoDao;
import com.example.demo.service.EmployeeRegistration;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("PersonalInfo")
public class PersonalInformationController {
    EmployeeRegistration employeeRegistration = new EmployeeRegistration();

    public void setEmployeeRegistration(PersonalInfoDao pInfoDAO){
        employeeRegistration.setEmployeeInfoDao(pInfoDAO);
    }

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerAlumni(EmployeeDetails employee) throws URISyntaxException {
        System.out.println(employee.getStudent().getId());
        System.out.println(employee.getEmail());
        System.out.println(employee.getContact());

        int returnvalue=employeeRegistration.insert_pinfo(employee);
        if(returnvalue==1)
            return Response.ok().entity(employee).build();
        else
            return Response.status(409).entity(employee).build();


    }
}