package org.tlgcohort.manvswild.client;

import java.util.*;
import java.util.stream.Collectors;


public class InputParser {
    Word word;
    static Scanner playerInput = new Scanner(System.in);
    static String input = playerInput.nextLine();
    static List<String> inputWords = new ArrayList<>(List.of(input.split("\\s")));
    static Map<String, Word> wordlist = new HashMap<>();
    static List<String> nounsnVerbs = new ArrayList<>();

    //Create a map of Key and Value String /Enum
    public static void activeWords() {
        Scanner playerInput = new Scanner(System.in);
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

      //Separate wordlist of verb/noun
      public static List<String> handleWords() {

         activeWords();
         //Stream through verbs
         List<String> vCommand = wordlist.entrySet()
                 .stream().filter(v -> v.getValue()
                         .equals(Word.VERB))
                 .map(Map.Entry::getKey)
                 .collect(Collectors.toList());
         nounsnVerbs.addAll(vCommand);

         //Stream through nouns
         List<String> nCommand = wordlist.entrySet()
                 .stream().filter(v -> v.getValue()
                         .equals(Word.NOUN))
                 .map(Map.Entry::getKey)
                 .collect(Collectors.toList());
         nounsnVerbs.addAll(nCommand);

         return nounsnVerbs;
     }


     //Parse user input to List
     public static List<String> parseInput() {
         handleWords();

         System.out.println("Start Game Test");

         String input = playerInput.nextLine();

         List<String> inputWords = new ArrayList<String>(List.of(input.split("\\s")));

         for (String word : nounsnVerbs) {
             if (inputWords.size() == 2 && inputWords.contains(word)) {
                 //Add method to handle input
                 System.out.println("Hey where's the Method");
                 System.out.println(inputWords);
                 return inputWords;
             } else if (!(inputWords.size() == 2 || !inputWords.contains(word))) {
                 System.out.println("You must enter only two words:Verb and Noun" + "\n" + "And they must be from list below");
                 System.out.println("Here are your choices:Nouns and Verbs" + nounsnVerbs);
                 break;
             }


         }
     return inputWords;
    }


    public static void main(String[] args) {
        InputParser ip = new InputParser();

        parseInput();


    }

}