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

    private static final String API_URL = "http://192.168.10.102/api/web/";
    private static final String API_VERSION = "v1";

    /**
     * Get all records from database table as JSONArray.
     * @param table Table Name to get data from
     * @return Result as JSONArray, or null if some error occurs.
     */
    public static JSONArray getAll(String table) {
        JSONArray result = null;

        //** COMMENT FOR TESTING **/
//        try {
//
//            URL url = new URL(API_URL + API_VERSION + "/" + table);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//
//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }
//
//            JSONParser parser = new JSONParser();
//
//            Object obj = parser.parse(new BufferedReader(new InputStreamReader(conn.getInputStream())));
//
//
//            //result = (JSONArray) obj;
//            result = new JSONArray();
//            result.add(obj);
//
//            conn.disconnect();
//
//        } catch (ParseException | IOException e) {
//            e.printStackTrace();
//        }
        //** END COMMENT FOR TESTING **/



        //* TESTING *//
        JSONParser parser = new JSONParser();

        Object obj = null;
        try {
            obj = parser.parse(
                    "{\"items\":[{\"id\":7,\"description\":\"Zonnebank\",\"time\":\"2017-01-10 19:01\",\"location\":\"De Posten\",\"organiser\":{\"fullname\":\"Wim Kamerman\"},\"participants\":[{\"fullname\":\"Felicia Elskamp\"},{\"fullname\":\"Han Hollander\"},{\"fullname\":\"Davey Hu\"},{\"fullname\":\"Linde van den Elzen\"},{\"fullname\":\"Freddy Kleine\"},{\"fullname\":\"Nelly Berendsen\"},{\"fullname\":\"Petra Dielis\"},{\"fullname\":\"Claus ter Borgh\"}],\"_links\":{\"self\":{\"href\":\"http://localhost/api/web/v1/activities/7\"}}},{\"id\":14,\"description\":\"Koffie drinken\",\"time\":\"2017-01-10 15:01\",\"location\":\"Needebrink 13 Enschede\",\"organiser\":{\"fullname\":\"Felicia Elskamp\"},\"participants\":[],\"_links\":{\"self\":{\"href\":\"http://localhost/api/web/v1/activities/14\"}}},{\"id\":5,\"description\":\"Boodschappen AH\",\"time\":\"2017-01-10 13:01\",\"location\":\"De Brink\",\"organiser\":{\"fullname\":\"Wim Kamerman\"},\"participants\":[],\"_links\":{\"self\":{\"href\":\"http://localhost/api/web/v1/activities/5\"}}},{\"id\":13,\"description\":\"Vissen\",\"time\":\"2017-01-10 12:01\",\"location\":\"De Posten\",\"organiser\":{\"fullname\":\"Wim Kamerman\"},\"participants\":[],\"_links\":{\"self\":{\"href\":\"http://localhost/api/web/v1/activities/13\"}}},{\"id\":1,\"description\":\"Boodschappen Lidl\",\"time\":\"2017-01-10 11:01\",\"location\":\"De Brink\",\"organiser\":{\"fullname\":\"Linde van den Elzen\"},\"participants\":[{\"fullname\":\"Wim Kamerman\"}],\"_links\":{\"self\":{\"href\":\"http://localhost/api/web/v1/activities/1\"}}},{\"id\":4,\"description\":\"Koffie drinken\",\"time\":\"2017-01-09 08:01\",\"location\":\"Reestweg 18 Enschede\",\"organiser\":{\"fullname\":\"Wim Kamerman\"},\"participants\":[],\"_links\":{\"self\":{\"href\":\"http://localhost/api/web/v1/activities/4\"}}}],\"_links\":{\"self\":{\"href\":\"http://localhost/api/web/v1/activities?expand=organiser%2Cparticipants&sort=-time&page=1\"}},\"_meta\":{\"totalCount\":6,\"pageCount\":1,\"currentPage\":1,\"perPage\":20}}"
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //result = (JSONArray) obj;
        result = new JSONArray();
        result.add(obj);

        //* END TESTING *//

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