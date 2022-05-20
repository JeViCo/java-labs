//*** Создание подкласса ***

package extends1;

class A { // Суперкласс

    int i, j;

    void showij() {
        System.out.println("Поля i и j: " + i + " и " + j);
    }
}

class B extends A { // Подкласс

    int k;

    void showk() {
        System.out.println("Поле k: " + k);
    }

    void sum() {
// Обращение к наследуемым полям:
        System.out.println("Сумма i+j+k=" + (i + j + k));
    }
}

public class Extends1 {

    public static void main(String[] args) {

// Объект суперкласса:
        A SuperObj = new A();
// Объект подкласса:
        B SubObj = new B();
        SuperObj.i = 10;
        SuperObj.j = 20;
        SuperObj.showij();
        SubObj.i = 7;
        SubObj.j = 8;
        SubObj.k = 9;
        SubObj.showij();
        SubObj.showk();
        SubObj.sum();

    }
}

//*** Доступ к элементам суперкласса ***

class MySuperClass{ // Суперкласс
    // Закрытое поле:
    private int a;
    // Закрытый метод:
    private void showa(){
    System.out.println("Поле a: "+a);}
    // Открытый метод:
    void seta(int n){
    a=n;
    showa();}
    }
    class MySubClass extends MySuperClass{ // Подкласс
    int b;
    void setall(int i,int j){
    seta(i);
    b=j;
    System.out.println("Поле b: "+b);}
    }
	
    class PrivateSuperDemo{
    public static void main(String arg[]){
    // Объект подкласса:
    MySubClass obj=new MySubClass();
    obj.setall(1,5);}
    }

//*** Конструкторы и наследование ***

// Суперкласс:
class MySuperClass{
int a;
void showa(){
System.out.println("Объект с полем a="+a);}
// Конструкторы суперкласса:
MySuperClass(){
a=0;
showa();}
MySuperClass(int i){
a=i;
showa();}
}
// Подкласс:
class MySubClass extends MySuperClass{
double x;
void showx(){
System.out.println("Объект с полем x="+x);}
// Конструкторы подкласса:
MySubClass(){
super(); // Вызов конструктора суперкласса
x=0;
showx();}
MySubClass(int i,double z){
super(i); // Вызов конструктора суперкласса
x=z;
showx();}
}
class SuperConstrDemo{
public static void main(String[] args){
System.out.println("Первый объект:");
MySubClass obj1=new MySubClass();
System.out.println("Второй объект:");
MySubClass obj2=new MySubClass(5,3.2);}
}

//*** Ссылка на элемент суперкласса ***

// Суперкласс:
class MyClassA{
// Поле:
int number;
// Конструктор суперкласса:
MyClassA(){
number=0;
System.out.println("Создан объект суперкласса с полем "+number);}
// Отображение значения поля:
void showA(){
System.out.println("Поле number: "+number);}
}
// Подкласс:
class MyClassB extends MyClassA{
// Поле с тем же именем:
int number;
// Конструктор подкласса:
MyClassB(){
super(); // Вызов конструктора суперкласса
number=100;
System.out.println("Создан объект подкласса с полем "+number);}
// Отображение значения поля:
void showB(){
System.out.println("Поле number: "+number);}
}
class TwoFieldsDemo{
public static void main(String[] args){
// Создание объекта подкласса:
MyClassB obj=new MyClassB();
// Изменение значения поля:
obj.number=50;
// Отображение значения поля:
obj.showA();
obj.showB();
}}

//*** переделка с super. ***

// Суперкласс:
class MyClassA{
// Поле:
int number;
// Конструктор суперкласса:
MyClassA(int a){
number=a;
System.out.println("Создан объект суперкласса с полем "+number);}
// Отображение значения поля:
void showA(){
System.out.println("Поле number: "+number);}
}
// Подкласс:
class MyClassB extends MyClassA{
// Поле с тем же именем:
int number;
// Конструктор подкласса:
MyClassB(int a){
super(a-1); // Вызов конструктора суперкласса
number=a; // Поле из подкласса
// Обращение к полю из суперкласса и подкласса:
System.out.println("Создан объект с полями: "+super.number+" и "+number);}
// Отображение значения поля:
void showB(){
// Обращение к полю из суперкласса и подкласса:
System.out.println("Поля объекта "+super.number+" и "+number);}
}

class TwoFieldsDemo2{
public static void main(String[] args){
// Создание объекта подкласса:
MyClassB obj=new MyClassB(5);
// Изменение значения поля:
obj.number=10;
// Отображение значений полей:
obj.showA();
obj.showB();
}}

//*** Переопределение методов при наследовании ***

class ClassA{
static int count=0;
private int code;
int number;
ClassA(int n){
set(n);
count++;
code=count;
System.out.println("Объект №"+code+" создан!");}
void set(int n){
number=n;}
void show(){
System.out.println("Для объекта №"+code+":");
System.out.println("Поле number: "+number);}
}
class ClassB extends ClassA{
char symbol;
ClassB(int n,char s){
super(n);
symbol=s;}
void set(int n,char s){
number=n;
symbol=s;}
void show(){
super.show();
System.out.println("Поле symbol: "+symbol);}
}

class MyMethDemo{
public static void main(String[] args){
ClassA objA=new ClassA(10);
ClassB objB=new ClassB(-20,'a');
objA.show();
objB.show();
objB.set(100);
objB.show();
objB.set(0,'z');
objB.show();}
}

//*** 
	