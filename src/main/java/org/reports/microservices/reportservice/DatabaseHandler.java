package org.reports.microservices.reportservice;

import java.util.ArrayList;
import java.util.List;

import org.reports.classes.Report;
import org.reports.classes.UnableToConnectError;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Data;

public class DatabaseHandler {

    public DatabaseHandler() throws UnableToConnectError{
        //Implement connection details
        
        //connect to db
        
        boolean condition = false;
        if(condition){
            throw new UnableToConnectError("Unable to connect to database");
        }
    }

    public boolean reportExists(int id){
        //Establish connection

        //Query for report
        
        //Check if it exists
        boolean condition = false;
        return condition;
    }

    public List<Report> getReports(){
        //Establish connection

        //retrieve reports using sql

        List<Report> r = new ArrayList<>();
        for(int i=0;i<5;i++){
            r.add(new Report());
        }
        return r;
    }

    public boolean addReport(Report r){
        //Establish connection

        //Add report

        //Return result
        return true;
    }

    public boolean updateReport(Report r){
        int reportID = r.id;
        //Establish connection
        
        //Extract ID and check if it exists

        //Update report

        //Return result
        return true;
    }

    public boolean deleteReport(Report r){
        //Establish connection
        
        //Extract ID and check if it exists

        //Delete report

        //Return result
        return true;
    }
}
