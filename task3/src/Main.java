import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Object input = null;
        try {
            input = new JSONParser().parse(new FileReader(args[0]));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject data = (JSONObject) input;
        JSONArray tests = (JSONArray)data.get("tests");

        try {
            input = new JSONParser().parse(new FileReader(args[1]));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        data = (JSONObject) input;
        JSONArray values = (JSONArray) data.get("values");
        values.add(input);
        for(Object cur : tests){
            fillValue((JSONObject) cur, values);
        }
        try (FileWriter file = new FileWriter("report.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(tests.toJSONString());
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void fillValue(JSONObject obj, JSONArray values){
        String value = findId((Long)obj.get("id"), values);
        obj.put("value", value);
        if(obj.containsKey("values")){
            JSONArray tests = (JSONArray)obj.get("values");
            for(Object cur : tests){
                fillValue((JSONObject) cur, values);
            }
            obj.put("values", tests);
        }
    }
    public static String findId(Long id, JSONArray values){
        for(Object cur:values){
            JSONObject test = (JSONObject) cur;
            Long curId = (Long)test.get("id");
            if(id.equals(curId)){
                return (String)test.get("value");
            }
        }
        return "not found";
    }
}