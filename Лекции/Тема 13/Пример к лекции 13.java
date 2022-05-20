//*** save button
package test;
import java.awt.*;
import java.awt.event.*;

public class Test {
 public static void main(String args[]) {
 Frame frame = new Frame("Test Action");
 frame.setSize(400, 300);
 Panel p = new Panel();
 frame.add(p);
 Button save = new Button("Save");
 save.addActionListener(
 new SaveButtonListener(frame));
 p.add(save);
 
 frame.setVisible(true);
 }
}

class SaveButtonListener 
 implements ActionListener {
 private Frame parent;
 public SaveButtonListener(Frame parentFrame)
 {
 parent = parentFrame;
 }
 public void actionPerformed(ActionEvent e) 
 {
 FileDialog fd = new FileDialog(parent, 
	 "Save file", FileDialog.SAVE);
 fd.setVisible(true);
 System.out.println(fd.getDirectory()+
	 fd.getFile());
 }
}

//*** кнопка закрытия
class MyAdapter extends WindowAdapter{
public void windowClosing(WindowEvent we){
System.exit(0);}
}
  // -> вставить в main
MyAdapter  adapter=new  MyAdapter();
frame.addWindowListener(adapter);

//*** Внутренний класс
package test;
import java.awt.*;
import java.awt.event.*;

public class Test {
 public static void main(String args[]) {
 Frame frame = new Frame("Test Action");
 frame.setSize(400, 300);
 Panel p = new Panel();
 frame.add(p);
 Button save = new Button("Save");
 save.addActionListener(new ActionListener() 
{
 public void actionPerformed(ActionEvent e)
 {
 FileDialog fd = new FileDialog(frame, 
	 "Save file", FileDialog.SAVE);
 fd.setVisible(true);
 System.out.println(fd.getDirectory()+
	 fd.getFile());
 }
});

 p.add(save);
 frame.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent we){
    System.exit(0);}
  });
 frame.setVisible(true);
 }
}

//*** Простое окно Swing
package myframe;
import javax.swing.*;
// Расширение класса JFrame: 
class JustAFrame extends JFrame{
// Конструктор класса:
public JustAFrame(int a,int b){
// Заголовок окна - аргумент конструктора суперкласса: 
super("Простое графическое окно");
// Размеры окна: 
setSize(a,b);
// Реакция на попытку закрыть окно: 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Отображение окна: 
setVisible(true);}
}
class MyFrame{
public static void main(String args[]){
// Создание окна:
JustAFrame frame=new JustAFrame(300,200);
}}

//*** Окна по кнопке
package demoswingbutton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class MyFrame extends JFrame{
// Счетчик окон:
public static int count=0;
// Конструктор:
MyFrame(int a,int b){
count++; // Количество открытых окон
// Название окна:
setTitle("Окно с кнопкой: "+count);
// Создание панели:
MyPanel panel=new MyPanel();
setSize(300,200); // Размер окна
// Закрытие окна:
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocation(a,b); // Положение окна
add(panel); // Добавление панели
setVisible(true); // Отображение окна
}}
// Класс панели:
class MyPanel extends JPanel{
// Конструктор:
MyPanel(){
// Создание кнопки:
JButton button=new JButton("Создать новое окно");
add(button); // Добавление кнопки на панель
button.addActionListener(listener);} // Регистрация обработчика
// Обработчик для кнопки - объект анонимного класса:
ActionListener listener=new ActionListener(){
public void actionPerformed(ActionEvent event){
Random rnd=new Random();
// Создание окна со случайными координатами размещения на экране:
MyFrame frame=new MyFrame(rnd.nextInt(800),rnd.nextInt(500));}};
}

public class Demoswingbutton {
    public static void main(String[] args) {
// Создание окна:
MyFrame frame=new MyFrame(100,100);
    }
}    
 