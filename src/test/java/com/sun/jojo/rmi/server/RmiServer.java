package com.sun.jojo.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiServer {
    public static void main(String[] agrs) throws MalformedURLException, RemoteException, InterruptedException {
        IPersonService personService = new PersonServiceImpl();
        LocateRegistry.createRegistry(12312);
        Naming.rebind("rmi://localhost:12312/personService",personService);

        System.out.println("Rmi Service is ready ...");
        Thread.sleep(20000);
    }

}
