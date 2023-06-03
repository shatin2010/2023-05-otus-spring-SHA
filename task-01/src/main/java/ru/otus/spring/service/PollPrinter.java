package ru.otus.spring.service;

import ru.otus.spring.dto.Poll;

public class PollPrinter {
    private final PollParser pollParser;

    public PollPrinter(PollParser pollParser) {
        this.pollParser = pollParser;
    }

    public void print() {
        Poll poll = pollParser.read();
        System.out.println(poll);
    }
}
