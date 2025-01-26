package org.example.io;

import org.example.entity.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface JsonWriter<T> {
    void writeToJson(List<T> person, String path);
}
