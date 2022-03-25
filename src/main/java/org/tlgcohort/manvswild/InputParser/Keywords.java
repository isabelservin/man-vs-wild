package org.tlgcohort.manvswild.InputParser;

import java.util.HashMap;
import java.util.Map;

public class Keywords {

    Word word;
    private Map<String, Word> wordlist = new HashMap<>();

    public Keywords() {
        wordlist.put("take", Word.VERB);
        wordlist.put("get", Word.VERB);
        wordlist.put("knife", Word.NOUN);
        wordlist.put("torch", Word.NOUN);
        wordlist.put("go", Word.VERB);
        wordlist.put("run", Word.VERB);
        wordlist.put("kick", Word.VERB);
        wordlist.put("hit", Word.VERB);
        wordlist.put("water", Word.NOUN);
        wordlist.put("moss", Word.NOUN);
        wordlist.put("fish", Word.NOUN);
        wordlist.put("fruit", Word.NOUN);
        wordlist.put("beer", Word.NOUN);
        wordlist.put("matches", Word.NOUN);
        wordlist.put("rock", Word.NOUN);
        wordlist.put("grenade", Word.NOUN);
        wordlist.put("wood", Word.NOUN);
        wordlist.put("stick", Word.NOUN);
        wordlist.put("drop", Word.VERB);
        wordlist.put("north", Word.NOUN);
        wordlist.put("south", Word.NOUN);
        wordlist.put("east", Word.NOUN);
        wordlist.put("west", Word.NOUN);
        wordlist.put("look", Word.VERB);
    }

    public Map<String, Word> getWordlist() {
        return wordlist;
    }

    public void setWordlist(Map<String, Word> wordlist) {
        this.wordlist = wordlist;
    }

}
