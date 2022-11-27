package com.example.demo.controller;

import com.example.demo.bean.EmployeeOrganization;
import com.example.demo.bean.Organisation;
import com.example.demo.dao.OrganizationInfoDao;
import com.example.demo.service.EmployeeRegistration;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static com.example.demo.dao.OrganizationInfoDao.getCompanyNames;

@Path("organizationInfo")
public class OrganizationController {
    EmployeeRegistration employeeRegistration = new EmployeeRegistration();

    public void setEmployeeRegistration(OrganizationInfoDao organizationInfoDao){
        employeeRegistration.setOrganizationInfoDAO(organizationInfoDao);
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanies(){
        List<Organisation> company_names=getCompanyNames();
        return Response.ok().entity(company_names).build();
    }

    @POST
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerOrganisationDetails(List<EmployeeOrganization> organizationDetails){
        if(organizationDetails.get(0).getOrganisation().getName().equals("Company")){
            return  Response.status(204).build();
        }

        int returnvalue=EmployeeRegistration.insertOrganizationinfo(organizationDetails);

        return Response.ok().build();

    }


}

