package model.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiService {

    private static final String API_URL = "http://localhost/hci/api/web/";
    private static final String API_VERSION = "v1";

    /**
     * Get all records from database table as JSONArray.
     * @param table Table Name to get data from
     * @return Result as JSONArray, or null if some error occurs.
     */
    public static JSONArray getAll(String table) {
        JSONArray result = null;

        try {

            URL url = new URL(API_URL + API_VERSION + "/" + table);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new BufferedReader(new InputStreamReader(conn.getInputStream())));
            //result = (JSONArray) obj;
            result = new JSONArray();
            result.add(obj);

            conn.disconnect();

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Get a specific record from a table
     * @param table Table Name to get data from
     * @param id ID of record to be retrieved
     * @return Result as JSONArray, or null if some error occurs.
     */
    public static JSONArray getSpecific(String table, String id) {
        return getAll(table + "/" + id);
    }

}