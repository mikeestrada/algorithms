package com.algorithms.service;

import org.springframework.stereotype.Service;

@Service
public class StringReverse {

    public String reverseString(String given) {
        return new StringBuilder(given).reverse().toString();
    }

    public String reverseWords(String words) {
        String[] wordsArray = words.split(" ");
        StringBuilder reversedWords = new StringBuilder();
        for (String aWord : wordsArray) {
            reversedWords.append(reverseString(aWord)).append(" ");
        }
        return reversedWords.toString().trim();
    }

    public String reverseSentence(String sentence) {
        String[] wordsArray = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();
        for(int i = wordsArray.length - 1; i == 0; i--) {
            reversedSentence.append(reverseString(wordsArray[i])).append(" ");
        }
        return reversedSentence.toString();
    }
}