package assignment;

import java.util.Random;

class SimpleThread extends Thread {

  @Override
  public void run() {
    try {
      Thread.sleep(500);
      String threadName = Thread.currentThread().getName();
      Random rand = new Random();
      int randomNumber = rand.nextInt(100) + 1;
      System.out.println("Random number is: " + randomNumber + " Thread name is: " + threadName + "\n");

    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }
}

public class SimpleThreadExercise {

  public static void main(String[] args) {

    SimpleThread simple = new SimpleThread();
    SimpleThread simple1 = new SimpleThread();
    SimpleThread simple2 = new SimpleThread();

    simple.setName("Joe");
    simple1.setName("Alica");
    simple2.setName("Diana");

    simple.start();
    
    
    try {
      simple.join();
      
      simple1.join();
      simple2.start();
      simple2.join();

    } catch (InterruptedException e) {
      System.out.println(e);
    }
    simple1.start();
    try {
        
      simple1.join();
    } catch (InterruptedException e) {
      System.out.println(e);
    }
    try {
      simple2.join();
    } catch (InterruptedException e) {
      System.out.println(e);
    }
    System.out.println("Thread is done ");
  }

}
