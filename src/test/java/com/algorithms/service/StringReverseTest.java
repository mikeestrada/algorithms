package com.algorithms.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ContextConfiguration(classes = {TestConfiguration.class}, loader = AnnotationConfigContextLoader.class)
public class StringReverseTest {

    @Autowired
    private StringReverse stringService;

    @Test
    public void reverseStringTest() {
        String actual = this.stringService.reverseString("car");
        Assert.assertSame(actual, "rac");
    }

    @Test
    public void reverseWords() {
    }
}