package org.reports.classes;

public class Report {
    public int id;
    public String name;
    public String reporter;
    public Location location;
    public float reportTime;
    public boolean isActive;
    public String extra;

    public Report(int id, String name, String reporter, Location location, float reportTime, boolean isActive, String extra){
        this.id = id;
        this.name = name;
        this.reporter = reporter;
        this.location = location;
        this.reportTime = reportTime;
        this.isActive = isActive;
        this.extra = extra;
    }

    //TODO: REMOVE TESTING CONSTRUCTOR;
    public static int counter = 0;
    public Report(){
        this.id = ++counter;
        this.name = "name " + counter;
        this.reporter = "reporter " + counter;
        this.location = new Location();
        this.reportTime = counter;
        this.isActive = true;
        this.extra = "extra stuff " + counter;
    }
}
