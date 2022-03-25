package org.tlgcohort.manvswild.client;

import java.util.*;
import java.util.stream.Collectors;


public class InputParser {

    Word word;
    static Scanner playerInput = new Scanner(System.in);
    static Map<String, Word> wordlist = new HashMap<>();
    static List<String> nounsnVerbs = new ArrayList<>();

    //Create a map of Key and Value String /Enum
    public static void activeWords() {
        Scanner playerInput = new Scanner(System.in);
        Keywords keywords = new Keywords();
        keywords.getWordlist();
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

         String verbnoun = playerInput.nextLine();

         List<String> inputWords = new ArrayList<String>(List.of(verbnoun.split("\\s")));

         for (String word : nounsnVerbs) {
             if (inputWords.size() == 2 && inputWords.contains(word)) {
                 //Add method to handle input
                 System.out.println("Hey where's the Method");
                 System.out.println(inputWords);

             } else if (!(inputWords.size() == 2 || inputWords.contains(word))) {
                 System.out.println("You must enter only two words:Verb and Noun" + "\n" + "And they must be from list below");
                 System.out.println("Here are your choices:Nouns and Verbs" + nounsnVerbs);
                 break;
             }

         }
         return inputWords;
     }

}
