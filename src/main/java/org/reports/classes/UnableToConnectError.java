package org.reports.classes;

public class UnableToConnectError extends Exception{
    public UnableToConnectError(String errorMessage){
        super(errorMessage);
    }

}

