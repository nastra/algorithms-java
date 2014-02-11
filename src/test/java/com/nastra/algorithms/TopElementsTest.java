package com.nastra.algorithms;

import com.nastra.algorithms.heap.TopElements;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author nastra
 */
public class TopElementsTest {

    @Test
    public void testTopElements() {
        Random random = new Random();
        List<Integer> items = new ArrayList<Integer>();
        List<Integer> sorted = new ArrayList<Integer>();
        int topElements = 100;
        for (int i = 0; i < 100000; i++) {
            Integer value = random.nextInt();
            items.add(value);
            sorted.add(value);
        }

        List<Integer> top = TopElements.findTopElements(items, topElements, true);
        List<Integer> expectedTop = retrieveTopElementsFromList(sorted, topElements);
        Assert.assertTrue(top.size() == expectedTop.size());

        for (int i = 0; i < topElements; i++) {
            Assert.assertTrue(expectedTop.get(i).equals(top.get(i)));
        }
    }

    private List<Integer> retrieveTopElementsFromList(List<Integer> input, int topElements) {
        Collections.sort(input);
        Collections.reverse(input);
        List<Integer> result = new ArrayList<Integer>(topElements);
        for (int i = 0; i < topElements; i++) {
            result.add(input.get(i));
        }
        // so that we get the top elements in increasing order
        Collections.reverse(result);
        return result;
    }
}
