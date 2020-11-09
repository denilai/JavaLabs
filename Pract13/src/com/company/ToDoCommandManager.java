package com.company;

import java.util.function.Function;

public class ToDoCommandManager implements ICommandManager{

    private ToDoList toDoList;

    public ToDoCommandManager(ToDoList toDoList){

        this.toDoList = toDoList;
    }

    @Override
    public boolean execute(String command){
        if (command.equals("q"))
            return true;
        Task task = new Task(command);
        if (task.command == null)
            return false;
        if (task.command.equals("ADD"))
            if (task.index != -1)
                return toDoList.add(task.index, String.join(" ",task.args));
            else {
                return toDoList.add(String.join((""),task.args));
            }
        if (task.command.equals("LIST")){
            return toDoList.print();
        }
        if(task.command.equals("EDIT")){
            if (task.index !=-1){
                return toDoList.edit(task.index,String.join(" ",task.args));
            }
            else return false;
        }
        if(task.command.equals("DELETE")){
            if (task.index !=-1){
                return  toDoList.delete(task.index);
            }
            else return false;
        }
        return false;
}


    public String[] words (String line){
        return line.trim().split(" ");
    }
}
