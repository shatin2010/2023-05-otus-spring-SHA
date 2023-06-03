package ru.otus.spring.service;

import org.springframework.core.io.ClassPathResource;
import ru.otus.spring.dto.Poll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PollParser {

    private final String resourceName;

    public PollParser(String resourceName) {
        this.resourceName = resourceName;
    }

    public Poll read() {
        try {
            Poll poll = new Poll();
            ClassPathResource resource = new ClassPathResource(resourceName);
            InputStream inputStream = resource.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                poll.add(line);
            }
            return poll;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
