package com.sun.jojo.stringintern;

public class TestMain implements  Test{
    public TestMain(){

    }
    private static int food;
    public static void main(String[] agrs){
        int i;
        for ( i = 2; i <=10 ; i++) {
            //System.out.println("For: "+i);

        }
        //System.out.println("Out: "+i);

        int a;
        a= 6;
        System.out.println(a);
        System.out.println(++a);
        System.out.println(a);

        //((TestMain)null).haha();


        //String s ;
        //System.out.println("S+" + s);
        System.out.println(++food);

        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));

        int[] aa = null;
       // aa[0] =1;

        //int aaa = 1/0;

        //int number=[]={1,2,3};

       // System.out.println(aa);

        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.print("ping");

        System.out.println(Math.floor(-8.5));







        int  ii = 10;
        do
        {
            ii /= 2;
        }while(ii-->1);

        System.out.println(ii);
    }


    static void pong() {
        System.out.print("pong");
    }



    public  void haha(){
        System.out.println("haha");
    }
}
