package moe.bamtoll;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Jaehyun on 2016-06-28.
 */
public abstract class MakeJson  {

    public abstract void Put(String name, int value);
    public abstract void Put(String name, float value);
    public abstract void Put(String name, String value);
    public abstract void Put(String name, boolean value);

    public  void Write(String url, JSONObject jsonObject) {
        try {
            FileWriter file = new FileWriter(url);
            file.write(jsonObject.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(jsonObject);
    }
}
