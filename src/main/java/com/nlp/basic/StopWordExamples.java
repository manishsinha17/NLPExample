package com.nlp.basic;

import com.aliasi.tokenizer.EnglishStopTokenizerFactory;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.Tokenizer;
import com.aliasi.tokenizer.TokenizerFactory;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StopWordExamples {

    public static void main(String[] args) {
        String sentence = "The first thing she caught was a 5 pound salmon.";
        String stopWords[] = {"the", "and", "or", "a", "with"};
        removeStopWords(sentence, stopWords);
        removeStopWordsWithLingPipe(sentence);
    }

    public static void removeStopWords(String text, String[] stopWords) {
        out.println("Core Java Example");
        out.println("Original Text: " + text);
        text = text.toLowerCase().trim();
        
        ArrayList<String> wordList = new ArrayList();
        wordList.addAll(Arrays.asList(text.split(" ")));
        
        List<String> stopWordList = new ArrayList<>();
        stopWordList.addAll(Arrays.asList(stopWords));
        
        wordList.removeAll(stopWordList);
        out.println("Text without stop words: " + wordList.toString());
    }

    public static void removeStopWordsWithLingPipe(String text) {
        out.println("\nLingPipe Example");
        out.println("Original Text: " + text);
        text = text.toLowerCase().trim();
        
        TokenizerFactory factory = IndoEuropeanTokenizerFactory.INSTANCE;
        factory = new EnglishStopTokenizerFactory(factory);
        Tokenizer tokenizer = factory.tokenizer(text.toCharArray(), 0, text.length());
        
        out.print("Text without stop words: ");
        for (String word : tokenizer) {
            out.print(word + " ");
        }
        out.println();
    }
}
