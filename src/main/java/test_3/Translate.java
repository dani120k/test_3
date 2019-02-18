package test_3;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Translate {
    final static String translateYandex = "https://translate.yandex.net/api/v1.5/tr.json/translate";
    final static String key = "trnsl.1.1.20190218T045111Z.d1379b1b272a0708.a69e25b86b415b20c050e158df1f5f0032d2138f";

    public static void getTranslate(String input){
        String url = translateYandex + "?key="+key+"&lang=en-ru&text="+input;
        try{

            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.toString());

        StringBuffer answer = new StringBuffer(jsonObject.get("text").toString());
        answer.delete(0, 2);
        answer.delete(answer.length() - 2, answer.length());
        System.out.println(answer);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
