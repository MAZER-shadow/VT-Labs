package org.example.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.entity.Person;
import org.example.io.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;


public class ReaderFile<T> implements JsonReader<T> {
    @Override
    public List<T> readJson (String path){
        try (BufferedReader reader = new BufferedReader(new FileReader(path)))  {
            Gson gson = new Gson();
            Type personListType = new TypeToken<List<Person>>() {}.getType();
            List<T> person = gson.fromJson(reader, personListType);
            return person;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

