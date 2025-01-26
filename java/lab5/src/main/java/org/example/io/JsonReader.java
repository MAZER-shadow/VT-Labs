package org.example.io;

import org.example.entity.Person;

import java.io.File;
import java.util.List;

public interface JsonReader<T> {
    List<T> readJson(String path);
}
