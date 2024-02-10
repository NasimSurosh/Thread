package assignment1;

class ParallelTask extends Thread{
  
  int calculation;

  public ParallelTask(int calculation) {
    this.calculation = calculation;
  }
  public void run() {
    try {
      Thread.sleep(600);
      long fact = factorial(calculation);
      System.out.println("factorial of: " + calculation + " is " + fact );
    } catch (InterruptedException e) {
     System.out.println(e);
    }
    
  }
    
  
  public long factorial(long number) {
    if(number <=1) {
     return 1;
  }
    else {
      return number*factorial(number-1);
    }
  }
}

public class ParallelTaskExercise {

  public static void main(String[] args) {
    
    ParallelTask pt = new ParallelTask(5);
    ParallelTask pt1 = new ParallelTask(6);
    ParallelTask pt2 = new ParallelTask(14);

    Thread th =new Thread(pt);
    Thread th1 =new Thread(pt1);
    Thread th2 =new Thread(pt2);
    
    th.start();
  
    try {
      th.join();
    }catch(InterruptedException e) {
      System.out.println(e);
    }
    th1.start();
    try {
      th1.join();
    }catch(InterruptedException e) {
      System.out.println(e);
    }
    th2.start();
    try {
      th2.join();
    }catch(InterruptedException e) {
      System.out.println(e);
    }
    System.out.println("Finished");
  }

}
