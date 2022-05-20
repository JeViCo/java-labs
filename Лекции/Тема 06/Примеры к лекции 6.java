
-----------Перегруженные методы

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

--
process((Parent)(new Child()), new Child());
// или
process(new Child(),(Parent)(new Child()));

process((Parent)null, null);
// или
process(null,(Parent)null);

--------------Ключевое слово this

class MyClass{
// Поля класса:
double Re,Im;
void set(double Re,double Im){
// Использование ссылки this:
this.Re=Re;
this.Im=Im;}
void get(){
// Инструкция перехода на новую строку \n:
System.out.println("Значения полей:\nRe="+this.Re+" и Im="+this.Im);}
}

class ThisDemo{
public static void main(String[] args){
MyClass obj=new MyClass();
obj.set(1,5);
obj.get();}
}

--------------Внутренние классы

class MyOuter{
// Поле внешнего класса:
int number=123;
// Метод внешнего класса:
void show(){
// Создание объекта внутреннего класса:
MyInner InnerObj=new MyInner();
// Вызов метода объекта внутреннего класса:
InnerObj.display();}
// Внутренний класс:
class MyInner{
// Метод внутреннего класса:
void display(){
System.out.println("Поле number="+number);}
}
}

class InnerDemo{
public static void main(String args[]){
// Создание объекта внешнего класса:
MyOuter OuterObj=new MyOuter();
// Вызов метода объекта внешнего класса:
OuterObj.show();}
}

---------------------Анонимные объекты

class MyClass{
void show(String msg){
System.out.println(msg);}
}

class NamelessDemo{
public static void main(String args[]){
// Использование анонимного объекта:
new MyClass().show("Этот объект не имеет имени");}
}

--------------------Способы передачи аргументов

class Base{
int a,b;
void show(){
System.out.println(a+":"+b);}
}

class Test{
void f(int x,int y){
x*=2;
y/=2;
System.out.println(x+":"+y);}
void f(Base obj){
obj.a*=2;
obj.b/=2;
System.out.println(obj.a+":"+obj.b);}
}

class TestDemo{
public static void main(String args[]){
Base obj=new Base();
Test tstFunc=new Test();
obj.a=10;
obj.b=200;
tstFunc.f(obj.a,obj.b);
obj.show();
tstFunc.f(obj);
obj.show();
}

----------Параметры методов (НЕОБЯЗАТЕЛЬНО)
int x=3;
process(x);
print(x);

public void process(int x) {
   x=5;
}

public int doubler(int x) {
   return x+x;
}

public void test() {
   int x=3;
   x=doubler(x);
}

public void process(Point p) {
   p.x=3;
}

public void test() {
   Point p = new Point(1,2);
   process(p);
   print(p.x);
}


public void process(Point p) {
   p = new Point(4,5);
}

public void test() {
   Point p = new Point(1,2);
   process(p);
   print(p.x);
}


---------------Бинарное дерево

//Бинарное дерево объектов
class ObjectTree{
// Количество цифр в ID-коде объекта:
private static int IDnum=8;
// Уровень объекта (буква):
private char Level;
// Номер объекта на уровне:
private int Number;
// Код объекта (массив цифр):
private int[] ID;
// Ссылка на первый объект:
ObjectTree FirstRef;
// Ссылка на второй объект:
ObjectTree SecondRef;
// Метод для генерирования ID-кода объекта:
private void getID(){
ID=new int[IDnum];
for(int i=0;i<IDnum;i++)
ID[i]=(int)(Math.random()*10);
}
// Метод для отображения ID-кода объекта:
private void showID(){
for(int i=0;i<IDnum;i++)
System.out.print("|"+ID[i]);
System.out.print("|\n");
}
// Метод для отображения параметров объекта:
void show(){
System.out.println("Уровень объекта: \t"+Level);
System.out.println("Номер на уровне: \t"+Number);
System.out.print("ID-код объекта: \t");
showID();
}
// Конструктор создания бинарного дерева:
ObjectTree(int k,char L,int n){
System.out.println("\tСоздан новый объект!");
Level=L;
Number=n;
getID();
show();
if(k==1){
FirstRef=null;
SecondRef=null;
}
else{
// Рекурсивный вызов конструктора:
FirstRef=new ObjectTree(k-1,(char)((int)L+1),2*n-1);
SecondRef=new ObjectTree(k-1,(char)((int)L+1),2*n);}
}}

class ObjectTreeDemo{
public static void main(String[] args){
// Дерево объектов:
ObjectTree tree=new ObjectTree(4,'A',1);
System.out.println("\tПроверка структуры дерева объектов!");
// Проверка структуры дерева объектов:
tree.FirstRef.SecondRef.FirstRef.show();
}
}
