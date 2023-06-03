package ru.otus.spring.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ru.otus.spring.dto.Poll;

import java.io.PrintStream;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PollPrinterTest {
    @Mock
    PollParser pollParser;
    @Mock
    PrintStream out;
    @Captor
    ArgumentCaptor<Poll> pollArgumentCaptor;
    PrintStream stdOut = System.out;

    PollPrinter pollPrinter;

    @Before
    public void setUp() {
        pollPrinter = new PollPrinter(pollParser);
    }

    @Test
    public void testPrint() {
        Poll poll = new Poll();
        System.setOut(out);
        Mockito.when(pollParser.read()).thenReturn(poll);

        pollPrinter.print();

        Mockito.verify(out).println(pollArgumentCaptor.capture());
        Poll actualPoll = pollArgumentCaptor.getValue();
        assertSame(poll, actualPoll);
    }

    @After
    public void tearDown() {
        System.setOut(stdOut);
    }

}