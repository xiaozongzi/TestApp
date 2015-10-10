package com.example.TestApp;

/**
 *
 * Date: 14-1-16  下午4:50
 */
public class Test {
     interface NewClass{
        int test();
    }
   protected  int myTest(NewClass test){
      int a = 8 +  test.test();
       return  a;
    }
    interface  Listener{
        void click();
    }
    void doit(Listener listener)   {

    }
}
