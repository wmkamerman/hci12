package model;

import model.api.DataObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import static java.lang.Math.toIntExact;

import java.util.ArrayList;

/**
 * Created by wimkamerman on 13-12-16.
 */
public class Activity {

    private int id;
    private String datetime;
    private String description;
    private String location;
    private ArrayList<String> participants;

    /************ CONSTRUCTORS ************/

    public Activity(int id, String datetime, String description, String location, ArrayList<String> participants) {
        this.id = id;
        this.datetime = datetime;
        this.description = description;
        this.location = location;
        this.participants = participants;
    }

    public Activity(int id, String datetime, String location, String description) {
        this(id, datetime, description, location, new ArrayList<String>());
    }

    public Activity(JSONObject obj) {
        this.id = toIntExact((long) obj.get("id"));
        this.datetime = (String) obj.get("time");
        this.description = (String) obj.get("description");
        this.location = (String) obj.get("location");
        this.participants = DataObject.getItemsAsStrings((JSONArray) obj.get("participants"), "fullname");
    }

    /************ GETTERS ************/

    public int getId() {
        return id;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<String> getParticipants() {
        return participants;
    }

    /************ METHODS ************/

    public void addParticipant(String participant) {
        participants.add(participant);
    }





}
