package com.sun.jojo.rmi.client;



import com.sun.jojo.rmi.server.IPersonService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class client {

    public static void main(String[] agrs){
        try {
            IPersonService personService = (IPersonService) Naming.lookup("rmi://localhost:12312/personService");
            personService.sayWhat("JOJO...");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
