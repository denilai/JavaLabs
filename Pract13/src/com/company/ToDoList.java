package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<String> tasks;

    ToDoList(){
        tasks = new ArrayList<>();
    }

    public boolean add(String task){
        if (task.isBlank())
            return false;
        tasks.add(task);
        return  true;
    }

    public boolean add(int index, String task){
        try{
            tasks.add(index-1,task);
            return true;
        }
        catch (IndexOutOfBoundsException a){
            return false;
        }
    }

    public boolean print() {
        if (tasks.isEmpty()) {
            System.out.println("Empty");
            return true;
        }
        int[] a = new int[1];
        tasks.forEach(task -> {
            System.out.println(++a[0] + " - " + task);
        });
        return true;
    }

    public boolean delete(int index){
        try{
        tasks.remove(index-1);
        return true;
        }
        catch(IndexOutOfBoundsException a){
            return false;
        }
    }

    public boolean edit(int index, String newName){
        try{
            tasks.set(index-1,newName);
            return true;
        }
        catch (IndexOutOfBoundsException a){
            return false;
        }
    }

}
