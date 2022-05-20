18
Human h = new Human();   
int i=h.age;   

19
public class Human {
   private int age;
   // метод, возвращающий значение age
   public int getAge() {
      return age;
   }
   // метод, устанавливающий значение age 
   public void setAge(int a) {
      age=a;
   }
}

20
Human h = new Human();   
int i=h.getAge();   // обращение через метод 

21
public class Human {

   // поле получает новый тип double
   private /*int*/ double age;

   // старые методы работают с округлением 
   // значения
   
   public int getAge() {
      return (int)Math.round(age);
   }
   public void setAge(int a) {
      age=a;
   }
   // добавляются новые методы для работы 
   // с типом double
   
   public double getExactAge() {
      return age;
   }
   public void setExactAge(double a) {
   age=a;
   }
}

22
Human h = getHuman();
double d=h.getExactAge();   
   // точное значение возраста

23
public void setAge(int a) {
   if (a>=0) {
      age=a;
   }
}

24
public class Wheel {
   private double radius;
   public double getRadius() {
      return radius;
   }
}

25
package first;

// Некоторый класс Parent
public class Parent {
}

package first;

// Класс Child наследуется от класса Parent,
// но имеет ограничение доступа по умолчанию
class Child extends Parent {
}

public class Provider {
   public Parent getValue() {
      return new Child();
   }
}

26
package second;

import first.*;

public class Test {
  public static void main(String s[]) 
  {
   Provider pr = new Provider();
   Parent p = pr.getValue();
   System.out.println(p.getClass().getName());
   // (Child)p - приведет к ошибке компиляции!
  }
}

27
public class Point {
  private int x, y;

  public boolean equals(Object o) {
    if (o instanceof Point) {
      Point p = (Point)o;
      return p.x==x && p.y==y;
    }
    return false;
  }
}

---------Статические элементы

class Human {
   private String name;
   public static int totalCount;
   Human {
	  totalCount++;
   }
}

//* main
Human h1 = new Human(),h2 = new Human();
System.out.println(Human.totalCount);
h3 = new Human;
System.out.println(h2.totalCount);

class Human {
   private static int totalCount;

   public static int getTotalCount() {
      return totalCount;
   }
}

//main
Human h=null;
h.getTotalCount();      // два эквивалентных 
Human.getTotalCount();  // обращения к одному 
                        // и тому же методу
//* Стат.метод
class Human {
   static {
      System.out.println("Class Human loaded");
   }
}

---

class Test {
   static int a;
   static {
      a=5;
      // b=7;   // Нельзя использовать до 
                // объявления!
   }
   static int b=a;
}

//Это правило распространяется только на обращения к полям по простому имени. Если использовать составное имя, то обращаться к полю можно будет раньше, чем оно будет объявлено:
class Test {
   static int b=Test.a;
   static int a=3;
   static {
      System.out.println("a="+a+", b="+b);
   }
}

						
-----28
public class Test {
   public static void main(String[] args) {
      for (int i=0; i<args.length; i++) {
         System.out.print(args[i]+" ");
      }
      System.out.println();
   }
}

29
public int doubler(int x) {
   return x+x;
}

public void test() {
   int x=3;
   x=doubler(x);
}

30
public void process(Point p) {
   p.x=3;
}

public void test() {
   Point p = new Point(1,2);
   process(p);
   print(p.x);
}

31
public void process(Point p) {
   p = new Point(4,5);
}

public void test() {
   Point p = new Point(1,2);
   process(p);
   print(p.x);
}
   
32
void process(Parent p, Child c) {}
void process(Child c, Parent p) {}

process(new Child(), new Child());
33
process(Object o) {}
process(String s) {}

//и примеры вызовов:
process(new Object());
process(new Point(4,5));
process("abc");

34
process((Parent)(new Child()), new Child());
// или
process(new Child(),(Parent)(new Child()));

process((Parent)null, null);
// или
process(null,(Parent)null);