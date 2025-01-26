package org.example;


import org.example.entity.Person;
import org.example.io.ReaderFile;
import org.example.io.WriterJson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WriterJson writerJson = new WriterJson();
        List<Person> people = new ArrayList<>();
        people.add(new Person("David"));
        people.add(new Person("Mark"));
        writerJson.writeToJson(people,"FileWithPerson.json");
        ReaderFile reader = new ReaderFile();
        List<Person> personList = reader.readJson("FileWithPerson.json");
        System.out.println(personList.get(0).getName());




    }
}
