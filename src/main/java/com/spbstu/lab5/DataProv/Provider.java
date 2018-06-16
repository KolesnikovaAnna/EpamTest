package com.spbstu.lab5.DataProv;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Provider {
    @org.testng.annotations.DataProvider(name = "provider")
    public static Object[] getData() throws IOException {
        FileReader dataFile = new FileReader(Provider.class.getClassLoader().getResource("MetalsColorsDataProvider.json").getFile());
        JsonReader jsonReader = new JsonReader(dataFile);
        Map<String, DataForResult> testValues = new Gson().fromJson(jsonReader, new TypeToken<Map<String, DataForResult>>() { }.getType());
        return testValues.values().toArray();
    }
}
