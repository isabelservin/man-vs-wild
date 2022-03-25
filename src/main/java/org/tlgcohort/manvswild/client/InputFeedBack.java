package org.tlgcohort.manvswild.client;

import org.tlgcohort.manvswild.client.InputParser;

import java.awt.*;
import java.util.List;
import java.util.function.Consumer;

public class InputFeedBack {

    public class commandFeedback {

        //Fields
        private int errorCode;
        private String commands;
        private String msg;

        //Constructor
        public commandFeedback(int errorCode, String commands, String msg) {
            this.errorCode = errorCode;
            this.commands = commands;
            this.msg = msg;
        }


        //Accessor Methods


        public int getErrorCode() {
            return errorCode;
        }

        public String getCommands() {
            return commands;
        }

        public String getMsg() {
            return msg;
        }

        public void inValidEntry(){
            List<commandFeedback> nextSteps = List.of(
                    new commandFeedback(1, "go north",  "Please try aanother direction"),
                    new commandFeedback(2, "go south",  "Please try aanother direction"),
                    new commandFeedback(3, "go east",  "Please try aanother direction"),
                    new commandFeedback(4, "go west",  "Please try aanother direction"),
                    new commandFeedback(5, "get knife",  "Item is nolonger avalible in this location,Try another Item"),
                    new commandFeedback(6, "get matches",  "Item is nolonger avalible in this location,Try another Item"),
                    new commandFeedback(7, "get fish",  "Item is nolonger avalible in this location,Try another Item"),
                    new commandFeedback(8, "get firewood",  "Item is nolonger avalible in this location,Try another Item"),
                    new commandFeedback(9, "get rock",  "Item is nolonger avalible in this location Try another Item"),
                    new commandFeedback(10, "get grenade",  "Item is nolonger avalible in this location Try another Item"),
                    new commandFeedback(11, "get wood",  "Item is nolonger avalible in this location Try another Item"),
                    new commandFeedback(12, "get stick",  "Item is nolonger avalible in this location Try another Item"),
                    new commandFeedback(13, "get fruit",  "Item is nolonger avalible in this location Try another Item"),
                    new commandFeedback(14, "     ",  " Invalid Command, please enter a verb and noun"),
                    new commandFeedback(15, " 3432 ",  " Invalid Command, please enter a verb and a noun")
            );

            Consumer<String> action = e->{
                //Complete Logic
            };
            nextSteps.forEach(e ->{

            });
        }


        @Override
        public String toString() {
            return "commandFeedback{" +
                    "errorCode=" + errorCode +
                    ", commands='" + commands + '\'' +
                    ", msg='" + msg + '\'' +
                    '}';
        }
    }


}
