package com.sun.jojo.rmi.server;

import java.io.Serializable;

public class PersonServiceImpl  implements IPersonService ,Serializable{
    private static final long serialVersionUID = -271947229644133464L;

    /**
     * implements sayWhat
     * @param what
     */
    public void sayWhat(String what) {
        System.out.println("Hello " + what);
    }
}
