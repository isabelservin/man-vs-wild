package org.tlgcohort.manvswild.InputParser;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class CommandFeedback {

    //Fields
    private int errorCode;
    private String playerInput;
    private String msg;

    //Constructor
    public CommandFeedback(){

    }
    public CommandFeedback(int errorCode, String commands, String msg) {
        this.errorCode = errorCode;
        this.playerInput = commands;
        this.msg = msg;
    }


    //Accessor Methods


    public int getErrorCode() {
        return errorCode;
    }

    public String getCommands() {
        return playerInput;
    }

    public String getMsg() {
        return msg;
    }

    public List<String> inValidEntry(List<String> command) {
        List<CommandFeedback> nextSteps = List.of(
                new CommandFeedback(1, "go north", "Please try aanother direction"),
                new CommandFeedback(2, "go south", "Please try aanother direction"),
                new CommandFeedback(3, "go east", "Please try aanother direction"),
                new CommandFeedback(4, "go west", "Please try aanother direction"),
                new CommandFeedback(5, "get knife", "Item is nolonger avalible in this location,Try another Item"),
                new CommandFeedback(6, "get matches", "Item is nolonger avalible in this location,Try another Item"),
                new CommandFeedback(7, "get fish", "Item is nolonger avalible in this location,Try another Item"),
                new CommandFeedback(8, "get firewood", "Item is nolonger avalible in this location,Try another Item"),
                new CommandFeedback(9, "get rock", "Item is nolonger avalible in this location Try another Item"),
                new CommandFeedback(10, "get grenade", "Item is nolonger avalible in this location Try another Item"),
                new CommandFeedback(11, "get wood", "Item is nolonger avalible in this location Try another Item"),
                new CommandFeedback(12, "get stick", "Item is nolonger avalible in this location Try another Item"),
                new CommandFeedback(13, "get fruit", "Item is nolonger avalible in this location Try another Item"),
                new CommandFeedback(14, "     ", " Invalid Command, please enter a verb and noun"),
                new CommandFeedback(15, " 3432 ", " Invalid Command, please enter a verb and a noun")
        );
//        Scanner sc = new Scanner(System.in);
//        System.out.println("What would you like to go");
//        String command = sc.nextLine();

        var playerIn = nextSteps.stream().filter(c -> c.playerInput.equalsIgnoreCase(String.valueOf(command)))//filter playerInput to return input that equals ""
                .map(CommandFeedback::getMsg)//map nextstep playerInput to get msg
                .collect(Collectors.toList());
        playerIn.forEach(System.out::println);//collect msg to a list and print

        return playerIn;
    }


    @Override
    public String toString() {
        return "commandFeedback{" +
                "errorCode=" + errorCode +
                ", commands='" + playerInput + '\'' +
                ", msg='" + msg + '\'' +
                '}';

    }


}
