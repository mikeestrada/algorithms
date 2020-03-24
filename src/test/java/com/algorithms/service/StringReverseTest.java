package com.algorithms.service;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class}, loader = AnnotationConfigContextLoader.class)
public class StringReverseTest {

    @Autowired
    private StringReverse stringService;

    @Test
    public void reverseStringTest() {
        String actual = this.stringService.reverseString("car");
        assertThat(actual, equalToIgnoringCase("rac"));
    }

    @Test
    public void reverseWords() {
    }
}