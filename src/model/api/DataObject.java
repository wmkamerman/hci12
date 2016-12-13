package model.api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by wimkamerman on 13-12-16.
 */
public class DataObject {

    private JSONArray arr;

    /************ CONSTRUCTOR ************/

    public DataObject(JSONArray arr) {
        this.arr = arr;
    }

    /************ METHODS ************/

    private JSONObject getFirst() {
        return (JSONObject) arr.get(0);
    }

    /**
     * Gets the metadata for the JSON Array
     * @return JSONObject with totalCount, pageCount, currentPage and perPage
     */
    public JSONObject getMeta() {
        return (JSONObject) getFirst().get("_meta");
    }

    public ArrayList<JSONObject> getItems() {
        JSONArray items = (JSONArray) getFirst().get("items");

        return getItems(items);
    }

    /************ STATIC GENERIC METHODS ************/

    public static ArrayList<JSONObject> getItems(JSONArray arr) {
        ArrayList<JSONObject> itemList = new ArrayList<>();
        for(int i=0; i < arr.size(); i++) {
            itemList.add((JSONObject) arr.get(i));
        }

        return itemList;
    }

    public static ArrayList<String> getItemsAsStrings(JSONArray arr, String key){
        ArrayList<String> result = new ArrayList<>();

        for (JSONObject item : getItems(arr)) {
            result.add((String) item.get(key));
        }
        return result;
    }

}
