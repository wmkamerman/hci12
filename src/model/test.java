package model;

import model.api.ApiService;
import model.api.DataObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Created by wimkamerman on 13-12-16.
 */
public class test {

    public static void main(String[] args) {

        //List to save activities in
        ArrayList<Activity> activityList = new ArrayList<>();

        //Get all activities from api, expanded with the organiser and participants per activity
        JSONArray arr = ApiService.getAll("activities?expand=organiser,participants");
        DataObject dataObject = new DataObject(arr);

        //Get the items (the activities) from the dataobject and create new Activity objects for each of them
        for(JSONObject jObj : dataObject.getItems()) {
            activityList.add(new Activity(jObj));
        }

        //Print things for testing
        System.out.println("=============");
        System.out.println("There are " + dataObject.getMeta().get("totalCount") + " activities:");
        System.out.println("=============\n");
        for(Activity a : activityList) {
            System.out.println(a.getId());
            System.out.println(a.getDatetime());
            System.out.println(a.getDescription());
            System.out.println(a.getLocation());
            System.out.println("Participants:");
            for(String s : a.getParticipants()) {
                System.out.println("    " + s);
            }
            System.out.println("\n=============\n");
        }
    }
}
