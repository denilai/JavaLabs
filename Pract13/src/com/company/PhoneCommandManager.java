package com.company;

public class PhoneCommandManager implements ICommandManager {
    PhoneList phoneList;

    PhoneCommandManager(PhoneList phoneList){
        this.phoneList = phoneList;
    }


    @Override
    public boolean execute(String command) {
        if (command.equals("q"))
            return true;
        if (command.equals("LIST")){
            if(!phoneList.print())
                System.out.println("List is empty");
            else
                return true;
        }
        return phoneList.handleRequest(command);
    }
}
