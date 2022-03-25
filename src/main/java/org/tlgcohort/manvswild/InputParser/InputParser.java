package org.tlgcohort.manvswild.InputParser;

import java.util.*;
import java.util.stream.Collectors;


public class InputParser {

    //Fields
    private Word word;
    private static Scanner playerInput = new Scanner(System.in);
    private static Map<String, Word> wordlist = new HashMap<>();
    private static List<String> nounsnVerbs = new ArrayList<>();

    //Create a map of Key and Value String /Enum
    public static void activeWords() {
        Keywords wordlist = new Keywords();
        wordlist.getWordlist();
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
        String input = playerInput.nextLine();
        List<String> keywords = new ArrayList<>(List.of(input.split("\\s")));

        for (String word : nounsnVerbs) {
            if (keywords.size() == 2 && keywords.contains(word)) {
                //Add method to handle input
               // System.out.println(keywords);
                break;
            } else if (!(keywords.size() == 2 || keywords.contains(word))) {
                System.out.println("You must enter only two words:Verb and Noun" + "\n" + "And they must be from list below");
                System.out.println("Here are your choices:Nouns and Verbs" + nounsnVerbs);
                break;
            }
        }
        return keywords;
    }


}
