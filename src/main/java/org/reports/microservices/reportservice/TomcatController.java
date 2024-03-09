package org.reports.microservices.reportservice;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.reports.classes.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
public class TomcatController {

    @GetMapping("/reports")
    public ResponseEntity<String> getAllReports(){
        Optional<DatabaseHandler> connection = connectToDatabase();
        if(connection.isPresent()){
            DatabaseHandler db = connection.get();
            Gson g = new Gson();
            return new ResponseEntity<>(g.toJson(db.getReports()), HttpStatus.OK);
        }
        else{
            //TODO: find more appropriate return value if can't connect
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/reports/add")
    public ResponseEntity<String> addReport(@RequestBody String payload){
        Optional<DatabaseHandler> connection = connectToDatabase();
        if(connection.isPresent()){
            DatabaseHandler db = connection.get();
            //create object from json
            Gson g = new Gson();
            Report r = g.fromJson(payload, Report.class);
            if(db.addReport(r)){
                return new ResponseEntity<>("aaaa", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else{
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/reports/update")
    public ResponseEntity<String> updateReport(@RequestBody String payload){

        Optional<DatabaseHandler> connection = connectToDatabase();
        if(connection.isPresent()){
            DatabaseHandler db = connection.get();
            Gson g = new Gson();
            Report r = g.fromJson(payload, Report.class);
            if(db.reportExists(r.id)){
                db.updateReport(r);
                return new ResponseEntity<>("", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else{
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/reports/delete")
    public ResponseEntity<String> deleteReport(@RequestBody String payload){
        Optional<DatabaseHandler> connection = connectToDatabase();
        if(connection.isPresent()){
            DatabaseHandler db = connection.get();
            Gson g = new Gson();
            Report r = g.fromJson(payload, Report.class);
            if(db.reportExists(r.id)){
                db.deleteReport(r);
                return new ResponseEntity<>("", HttpStatus.OK);
            }
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else{
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //helper function to catch db connection error
    private Optional<DatabaseHandler> connectToDatabase(){
        try{
            DatabaseHandler db = new DatabaseHandler();
            return Optional.ofNullable(db);
        }
        catch(UnableToConnectError e){
            return Optional.ofNullable(null);
        }
    }


}
