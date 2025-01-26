package org.example.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.*;
import java.lang.reflect.Type;
import java.util.List;


public class ReaderFile<T> implements JsonReader<T>{
    private final Type listType;

    public ReaderFile(Class<T> clazz) {
        this.listType = TypeToken.getParameterized(List.class, clazz).getType();
    }

    @Override
    public List<T> readJson (String path){
        try (BufferedReader reader = new BufferedReader(new FileReader(path)))  {
            Gson gson = new Gson();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}



