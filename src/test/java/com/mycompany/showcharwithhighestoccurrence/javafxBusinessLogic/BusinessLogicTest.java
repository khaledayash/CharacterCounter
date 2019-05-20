package com.mycompany.showcharwithhighestoccurrence.javafxBusinessLogic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BusinessLogicTest {

    private BusinessLogic businessLogic = new BusinessLogic();

    @Spy
    private BusinessLogic businessLogic1;

    @Test
    public void giveFinalResult(){
        String s = "hello test";
        String result = "The most frequent letters are e, l, t with 2 occurences.";

        assertEquals(businessLogic.giveFinalResult(s), result);



        //Using Mockito
        int max = 0;
        String test = "";
        doReturn(test).when(businessLogic1).evaluateInputText(test);
        List<Character> listCharMaxFreq = new LinkedList<>();
        Map<Character, Integer> counts = new HashMap<>();
        when(businessLogic1.computeOccurence(test, listCharMaxFreq, counts)).thenReturn(max);
        when(businessLogic1.print(listCharMaxFreq, max)).thenReturn("");
        assertEquals(businessLogic1.giveFinalResult(anyString()),"");
    }
    @Test
    public void evaluateInputText(){
        String s = " HELLO ";
        String result = businessLogic.evaluateInputText(s);
        assertNotNull(result);
        assertEquals("hello", result);
    }
    @Test
    public void print(){
        List<Character> list = new LinkedList<>();
        list.add('b');
        int i = 2;
        assertNotNull(businessLogic.print(list, i));
        assertNotEquals("", businessLogic.print(list, i));
        assertEquals("The most frequent letter is b with 2 occurences.", businessLogic.print(list, i));
        list.add('h');
        assertNotNull(businessLogic.print(list, i));
        assertNotEquals("", businessLogic.print(list, i));
        assertEquals("The most frequent letters are b, h with 2 occurences.", businessLogic.print(list, i));
        i = 0;
        assertEquals("", businessLogic.print(list, i));
        i = 1;
        assertEquals("", businessLogic.print(list, i));
        i = 2;
        list = null;
        assertEquals("", businessLogic.print(list, i));

    }
    @Test
    public void computeOccurence(){
        String input = "Hello";
        List<Character> listCharMaxFreq =  new LinkedList<>();
        listCharMaxFreq.add('l');
        Map<Character, Integer> counts = new HashMap<>();
        assertEquals(2, businessLogic.computeOccurence(input, listCharMaxFreq, counts));
    }
    @Test
    public void computeOccurenceWithEmptyString(){
        String input = "";
        List<Character> listCharMaxFreq =  new LinkedList<>();
        listCharMaxFreq.add('l');
        Map<Character, Integer> counts = new HashMap<>();
        assertEquals(0, businessLogic.computeOccurence(input, listCharMaxFreq, counts));
    }
}