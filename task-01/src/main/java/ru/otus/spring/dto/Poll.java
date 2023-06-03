package ru.otus.spring.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Poll {
    private final List<String> lines = new ArrayList<>();

    public void add(String line) {
        lines.add(line);
    }

    @Override
    public String toString() {
        return lines.stream().collect(Collectors.joining(System.lineSeparator()));
    }
}
