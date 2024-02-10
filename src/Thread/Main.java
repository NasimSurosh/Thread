package Thread;

class ThreadExample extends Thread {
  
  public void run() {
    
    for(int i = 0; i < 3; i++) {
      try {
        Thread.sleep(1000);
        System.out.println("Crrent Thread: " + Thread.currentThread().getName());
      } catch (InterruptedException e) {
        System.out.println(e);
      }
      System.out.println(i);
    }
  }
}

public class Main {

  public static void main(String[] args) {
    
       
    ThreadExample thread1 = new ThreadExample();
    ThreadExample thread2 = new ThreadExample();
    ThreadExample thread3 = new ThreadExample();
    
    thread1.start();
    
    try {  
      System.out.println("Crrent Thread: " + Thread.currentThread().getName());
      thread1.join();
    } catch (Exception e) {
      System.out.println(e);
    }
    thread2.start();
    
    try {
      System.out.println("Crrent Thread: " + Thread.currentThread().getName());
      thread2.join();
    } catch (Exception e) {
      System.out.println(e);
    }
    
    thread3.start();

  }

}
