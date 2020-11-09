package com.company;

import java.util.ArrayList;

public class Task {

    public String command;

    public ArrayList<String> args;

    public int index;

    public Task(String rawCommand){
        if (rawCommand.isBlank()) {
            command = null;
            args = null;
            index = -1;
            return;
        }
        String[] rawArgs = rawCommand.trim().split(" ");
        if ((!rawArgs[0].equals("ADD") &&
                !rawArgs[0].equals("LIST") &&
                !rawArgs[0].equals("EDIT") &&
                !rawArgs[0].equals("DELETE"))) {
            command = null;
            args = null;
            index = -1;
            return;
        }
        command = rawArgs[0];
        args = new ArrayList<>();
        for (int i = 1 ; i < rawArgs.length; i++){
            args.add(rawArgs[i]);
        }
        if (args.size()<=1 && !command.equals("DELETE"))
            index = -1;
        else {
            try {
                index = Integer.parseInt(args.get(0));
                args.remove(0);
            } catch (NumberFormatException | IndexOutOfBoundsException a) {
                index = -1;
            }
        }
    }
}
