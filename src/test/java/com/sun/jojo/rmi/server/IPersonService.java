package com.sun.jojo.rmi.server;

import java.rmi.Remote;

public interface IPersonService  extends Remote{
    /**
     * sayWhat
     * @param what
     */
    void sayWhat(String what);
}
