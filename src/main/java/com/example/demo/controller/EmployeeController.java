package com.example.demo.controller;

import com.example.demo.bean.EmployeeEducation;
import com.example.demo.dao.EmployeeInfoDao;
import com.example.demo.service.EmployeeRegistration;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("employeeInfo")
public class EmployeeController {
    //changes done
    EmployeeRegistration employeeRegistration = new EmployeeRegistration();
//changes done
    public void setemployeeRegistration(EmployeeInfoDao employeeInfoDao){
        employeeRegistration.setEmployeeInfoDao(employeeInfoDao);
    }

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerEducationDetails(List<EmployeeEducation> employeeEducations) throws URISyntaxException {
        if(employeeEducations.get(0).getCollege_name()==""){
            return Response.status(204).build();
        }
        System.out.println(employeeEducations.get(0).getEmployee().getId());
        System.out.println(employeeEducations.get(0).getAddress());
        System.out.println(employeeEducations.get(0).getJoining_year());


        int returnvalue=employeeRegistration.insert_einfo(employeeEducations);
        if(returnvalue==1)
            return Response.ok().build();
        else
            return Response.status(409).build();




    }
}
