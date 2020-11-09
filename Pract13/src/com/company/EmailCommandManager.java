package com.company;

public class EmailCommandManager implements ICommandManager{

    private EmailList emailList;
    Task task;

    public EmailCommandManager (EmailList emailList){
        this.emailList = emailList;
    }

    @Override
    public boolean execute(String command){
        if (command.equals("q"))
            return true;
        task = new Task(command);
        if (task.command == null)
            return false;
        if (task.command.equals("ADD")){
            return emailList.add(String.join(" ",task.args));
        }
        if (task.command.equals("LIST")){
            return emailList.print();
        }
        return false;
    }
}
