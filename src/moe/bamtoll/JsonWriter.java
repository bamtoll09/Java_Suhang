package moe.bamtoll;

import org.json.simple.JSONObject;

/**
 * Created by Jaehyun on 2016-06-28.
 */
public class JsonWriter extends MakeJson {

    JSONObject jsonObject = new JSONObject();

    @Override
    public void Put(String name, int value) {
        jsonObject.put(name, value);
    }

    @Override
    public void Put(String name, float value) {
        jsonObject.put(name, value);
    }

    @Override
    public void Put(String name, String value) {
        jsonObject.put(name, value);
    }

    @Override
    public void Put(String name, boolean value) {
        jsonObject.put(name, value);
    }
}
