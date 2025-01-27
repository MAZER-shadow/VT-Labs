package org.example;


import org.example.entity.Coordinates;
import org.example.io.ReaderFile;
import org.example.io.WriterJson;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WriterJson<Coordinates> writerJson = new WriterJson<>();
        List<Coordinates> people = new ArrayList<>();

        people.add(new Coordinates());
        people.add(new Coordinates());
        writerJson.writeToJson(people, "src\\main\\resources\\FileWithPerson.json");
        ReaderFile<Coordinates> reader = new ReaderFile<>(Coordinates.class);
        List<Coordinates> personList = reader.readJson("src\\main\\resources\\FileWithPerson.json");
        System.out.println(personList.get(0).getX());
    }
}




