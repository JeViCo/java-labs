// *** ��������� ������ Thread
public class MyThread extends Thread {
   public void run() {
      // ��������� ������ ��������, ����������
      long sum=0;
      for (int i=0; i<1000; i++) {
         sum+=i;
      }
      System.out.println(sum);
   }
}

MyThread t = new MyThread();
t.start();

// *** ��������� Runnable
public class MyRunnable implements Runnable {
   public void run() {
      // ��������� ������ ��������, ����������
      long sum=0;
      for (int i=0; i<1000; i++) {
         sum+=i;
      }
      System.out.println(sum);
   }
}

Runnable r = new MyRunnable();
Thread t = new Thread(r);
t.start();

// *** ������ � ������������
public class ThreadTest implements Runnable {
  public void run() {
    double calc;
    for (int i=0; i<50000; i++) {
      calc=Math.sin(i*i);
      if (i%10000==0) {
        System.out.println(getName()+ " counts " + i/10000);
      }
    }
  }
 
  public String getName() {
     return Thread.currentThread().getName();
  }
 //------
  public static void main(String s[]) {
    // ���������� �������
    Thread t[] = new Thread[3];
    for (int i=0; i<t.length; i++) {
      t[i]=new Thread(new ThreadTest(), "Thread "+i);
    }
    // ������ �������
    for (int i=0; i<t.length; i++) {
      t[i].start();
      System.out.println(t[i].getName()+" started");
    }
  }
}
//-------
public static void main(String s[]) {
// ���������� �������
   Thread t[] = new Thread[3];
   for (int i=0; i<t.length; i++) {
      t[i]=new Thread(new ThreadTest(), "Thread "+i);
      t[i].setPriority(Thread.MIN_PRIORITY + 
      (Thread.MAX_PRIORITY - Thread.MIN_PRIORITY)/t.length*i);
   }
 
// ������ �������
   for (int i=0; i<t.length; i++) {
      t[i].start();
      System.out.println(t[i].getName()+" started");
   }
}

// *** �������������
public class ThreadTest {
  private int a=1, b=2;
  public void one() {
    a=b;
  }
  public void two() {
    b=a;
  }
 
  public static void main(String s[]) {
    int a11=0, a22=0, a12=0;
    for (int i=0; i<500; i++) {
      final ThreadTest o = new ThreadTest();
 
      // ��������� ������ �����, ������� �������� ���� �����
      new Thread() {
          public void run() {
            o.one();
          }
      }.start();
 
      // ��������� ������ �����, ������� �������� ������ �����
      new Thread() {
         public void run() {
           o.two();
         }
      }.start();
 
      // ���� ������� ����� ���������� 
      try {
         Thread.sleep(100);
      } catch (InterruptedException e) {}
 
      // ����������� ��������� ��������
      if (o.a==1 && o.b==1) a11++;
      if (o.a==2 && o.b==2) a22++;
      if (o.a!=o.b) a12++;
    }
    System.out.println(a11+" "+a22+" "+a12);
  }
}

// *** ���������� �������� ��������, ��������� ��� ������� ��� ������ � �������:
use � ������ �������� ���������� �� ������� ������ ������;
assign � ������ �������� ���������� � ������� ������ ������;
read � ��������� �������� ���������� �� ��������� ���������;
load � ���������� �������� ����������, ������������ �� ��������� ���������, � ������� ������;
store � �������� �������� ���������� �� ������� ������ � �������� ��������� ��� ����������� ��������;
write � ��������� � �������� ��������� �������� ����������, ���������� �������� store.

// *** ����������
public class ThreadTest implements Runnable {
   private static ThreadTest shared = new ThreadTest();
   public void process() {
      for (int i=0; i<3; i++) {
         System.out.println(
                    Thread.currentThread().getName()+" "+i);
         Thread.yield();
      }
   }
 
   public void run() {
      shared.process();
   }
   public static void main(String s[]) {
      for (int i=0; i<3; i++) {
         new Thread(new ThreadTest(),"Thread-"+i).start();
      }
   }
}

// *** Deadlock
public class DeadlockDemo {
 
  // ��� �������-�������
  public final static Object one=new Object(), two=new Object();
 
  public static void main(String s[]) {
 
    // ������� ��� ������, ������� �����
    // ������������� �� ������ � �������� 
	// one � two
    Thread t1 = new Thread() {
      public void run() {
        // ���������� ������� �������
        synchronized(one) {
        Thread.yield();
          // ���������� ������� �������
          synchronized (two) {
            System.out.println("Success!");
          }
        }
      }
    };
    Thread t2 = new Thread() {
      public void run() {
        // ���������� ������� �������
        synchronized(two) {
          Thread.yield();
          // ���������� ������� �������
          synchronized (one) {
            System.out.println("Success!");
          }
        }
      }
    };
 
    // ��������� ������
    t1.start();
    t2.start();
  }
}

// *** Wait
public class WaitThread implements Runnable {
      private Object shared;
 
      public WaitThread(Object o) {
         shared=o;
}
 
public void run() {
   synchronized (shared) {
      try {
         shared.wait();
      } catch (InterruptedException e) {}
      System.out.println("after wait");
   }
}
 
public static void main(String s[]) {
   Object o = new Object();
   WaitThread w = new WaitThread(o);
   new Thread(w).start();
   try {
      Thread.sleep(100);
   } catch (InterruptedException e) {}
   System.out.println("before notify");
   synchronized (o) {
      o.notifyAll();
   }
   }
}

// wait ��� 3 �������
public class Thread3Test implements Runnable {
      final static private Object shared=new Object();
      private int type;
      public Thread3Test(int i) {
         type=i;
      }
 
public void run() {
   if (type==1 || type==2) {
      synchronized (shared) {
         try {
            shared.wait();
         } catch (InterruptedException e) {}
         System.out.println("Thread "+type+" after wait()");
   }
} else {
   synchronized (shared) {
      shared.notifyAll();
      System.out.println("Thread "+type+" after notifyAll()");
      }
   }
}
 
public static void main(String s[]) {
   Thread3Test w1 = new Thread3Test(1);
   new Thread(w1).start();
   try {
      Thread.sleep(100);
   } catch (InterruptedException e) {}
   Thread3Test w2 = new Thread3Test(2);
   new Thread(w2).start();
   try {
      Thread.sleep(100);
   } catch (InterruptedException e) {}
   Thread3Test w3 = new Thread3Test(3);
   new Thread(w3).start();
   }
}


