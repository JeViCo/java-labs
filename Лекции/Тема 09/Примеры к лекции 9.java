//Объектная переменная суперкласса ссылается на объект подкласса
class ClassA{
 double Re;
 void set(double x){
 Re=x;
 }
 void show(){ 
	System.out.println("Класс A:"); 
	System.out.println("Поле Re: "+Re);}
 }

class ClassB extends ClassA{
 double Im;
 void set(double x,double y){ 
	Re=x;
	Im=y;
 }
 void show(){ 
	System.out.println("Класс B:"); 
	System.out.println("Поле Re: "+Re); 
	System.out.println("Поле Im: "+Im);
 }
}

public class SuperRefs {
 public static void main(String[] args) {
  ClassA objA;
  ClassB objB=new ClassB(); 
  objA=objB;
  bjB.set(1,5);
  objB.show();
  objA.set(-10);
  objA.show();
 }
}

//***********

// Динамическое управление методами

class A {

    void show() {
        System.out.println("Класс А");
    }
}

class B extends A {

    void show() {
        System.out.println("Класс В");
    }
}

class C extends A {

    void show() {
        System.out.println("Класс C");
    }
}

public class Dispatch {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        A ref;
        ref = a;
        ref.show();
        ref = b;
        ref.show();
        ref = c;
        ref.show();
    }
}

//*********************

// Абстрактный суперкласс:
abstract class A {
// Абстрактный метод:
    abstract void callme();
// Неабстрактный метод:
    void callme2() {
        System.out.println("Второй метод");
    }
}
// Подкласс:
class B extends A {
// Определение наследуемого абстрактного метода:
    void callme() {
        System.out.println("Первый метод");
    }
}

public class Abstr {
    public static void main(String[] args) {
// Объект подкласса:
        B obj = new B();
        obj.callme();
        obj.callme2();
    }
}

//********************

//пример задания интерфейса:
public interface IScalable {
public int getSize();
public void setSize(int newSize);
}

//********************

// Интерфейс:
interface MyMath{
// Сигнатура метода:
double Sinus(double x);
// Константа:
double PI=3.14159265358979;
}
// Класс реализует интерфейс:
class MyClass implements MyMath{
// Реализация метода (вычисление синуса):
public double Sinus(double x){
int i,n=1000;
double z=0,q=x;
for(i=1;i<=n;i++){
z+=q;
q*=(-1)*x*x/(2*i)/(2*i+1);
}
return z;
}
}

class MyMathDemo{
public static void main(String args[]){
MyClass obj=new MyClass();
// Использование константы:
double z=MyClass.PI/6;
// Вызов метода:
System.out.println("sin("+z+")="+obj.Sinus(z));
}
}

//*******

//интерфейсные ссылки:
// Интерфейс:
interface Base{
int F(int n);
}
// Класс A реализует интерфейс Base:
class A implements Base{
// Двойной факториал числа:
public int F(int n){
if(n==1||n==2) return n;
else return n*F(n-2);}
}
// Класс B реализует интерфейс Base:
class B implements Base{
// Факториал числа:
public int F(int n){
if(n<1) return 1;
else return n*F(n-1);}
}
class ImplDemo{
public static void main(String args[]){
// Интерфейсные переменные и создание объектов:
Base refA=new A();
Base refB=new B();
// Объектные переменные и создание объектов:
A objA=new A();
B objB=new B();
// Проверка работы методов:
System.out.println("1: "+refA.F(5));
System.out.println("2: "+refB.F(5));
System.out.println("3: "+objA.F(5));
System.out.println("4: "+objB.F(5));
// Изменение интерфейсных ссылок:
refA=objB;
refB=objA;
// Проверка результата:
System.out.println("5: "+refA.F(5));
System.out.println("6: "+refB.F(5));}
}

//******

//один класс реализует несколько интерфейсов:
// Первый интерфейс:
interface One{
void setOne(int n);
}
// Второй интерфейс:
interface Two{
void setTwo(int n);
}
// Суперкласс:
class ClassA{
int number;
void show(){
System.out.println("Поле number: "+number);}
}
// Подкласс наследует суперкласс и реализует интерфейсы:
class ClassB extends ClassA implements One,Two{
int value;
// Метод первого интерфейса:
public void setOne(int n){
number=n;}
// Метод второго интерфейса:
public void setTwo(int n){
value=n;}
// Переопределение метода суперкласса:
void show(){
super.show();
System.out.println("Поле value: "+value);}
}
class MoreImplDemo{
public static void main(String[] args){
	
// Создание объекта и использование объекта:
ClassB b = new ClassB();        
b.setOne(100);
b.setTwo(200);
b.show();
	
// Интерфейсные переменные:
One ref1;
Two ref2;
// Создание объекта:
ClassB obj=new ClassB();
// Интерфейсные ссылки:
ref1=obj;
ref2=obj;
// Вызов методов:
ref1.setOne(10);
ref2.setTwo(-50);
// Проверка результата:
obj.show();}
}

//******

//Расширение интерфейса
// Интерфейс:
interface BaseA{
int FunA(int n);
}
// Расширение интерфейса:
interface BaseB extends BaseA{
int FunB(int n);
}
// Реализация интерфейса:
class MyClass implements BaseB{
public int FunA(int n){
if(n<1) return 1;
else return n*FunA(n-1);}
public int FunB(int n){
if(n==1||n==2) return n;
else return n*FunB(n-2);}
}
class ImplExtDemo{
public static void main(String args[]){
MyClass obj=new MyClass();
System.out.println("1: "+obj.FunA(5));
System.out.println("2: "+obj.FunB(5));}
}

//****
//константы из разных интерфейсов 
public interface I1 {
Double PI=3.14;
}
public interface I2 {
Double PI=3.1415;
}
class C1 implements I1,I2 {
void m1(){
System.out.println("I1.PI="+ I1.PI);
System.out.println("I2.PI="+ I2.PI);
}
}

//Пусть у нас имеются: класс Car (Автомобиль), класс Driver (Шофер) и класс Speed (Скорость), и пусть это совершенно независимые классы. Зададим класс MovingCar (Движущийся автомобиль):
public class MovingCar extends Car{
Driver driver;
Speed speed;
...
}

