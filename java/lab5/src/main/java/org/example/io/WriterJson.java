package org.example.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.entity.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriterJson<T> implements JsonWriter<T>{
    @Override
    public void writeToJson(List<T> person, String path) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            gson.toJson(person, writer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
