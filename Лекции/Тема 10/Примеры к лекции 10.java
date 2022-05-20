import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class EduCollection {
    // Первая коллекция для примера
    private static Collection createFirstCollection() {
        // Создать коллекцию на основе стандартного класса ArrayList
        Collection col = new ArrayList();
        // Добавление в коллекцию
        col.add("1");
        col.add("2");
        col.add("3");
        col.add("4");
        col.add("5");
        col.add("6");
        col.add("7");
        return col;
    }
 
    // Вторая коллекция для примера
    private static Collection createSecondCollection() {
        // Создать коллекцию на основе стандартного класса ArrayList
        Collection col2 = new ArrayList();
        col2.add("1");
        col2.add("2");
        col2.add("3");
        return col2;
    }

    public static void main(String[] args) {
        // Создаем коллекции для демонстрации
        Collection col1 = createFirstCollection();
        Collection col2 = createSecondCollection();
 
        // Демонстрация прохода по коллекции
        System.out.println("============= Проход по коллекции");
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
 
        System.out.println();
        // Демонстрация прохода по коллекции через итератор
        System.out.println("============= Проход по коллекции через итератор");
        for (Iterator it = col1.iterator(); it.hasNext(); ) {
            String s = (String)it.next();
            System.out.println("Item:" + s);
        }
        System.out.println();
 
        // Демонстрации групповых операций
        System.out.println();
        System.out.println("============= Групповые операции");
        // Можно проверить сожержаться ли ВСЕ элементы col2 в col
        if(col1.containsAll(col2)) {
            System.out.println("Коллекция col содержит все от col2");
        }
        
        System.out.println("============= Добавление всех элементов в col1 из col2");
        // Можно добавить элементы из col2 в col1
        col1.addAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        
        System.out.println("============= Удаление всех элементов col2, которые есть в col1");
        // Можно удалить ВСЕ элементы col2, которые есть в col1
        col1.removeAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        
        // Пересоздаем коллекции для дпальнейшей демонстрации
        col1 = createFirstCollection();
        col2 = createSecondCollection();
        System.out.println("============= Удаление элементов из col1, которых нет в col2");
        col1.retainAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println("============= Очистка коллекции - не будет элементов");
        col1.clear();
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println();
 
        // Удаление элемента коллекции
        // Снова создаем коллекцию для демонстрации
        col1 = createFirstCollection();
        // Удаляем один элемент
        col1.remove("1");
        System.out.println("============= Удаляем элемент '1' - его не будет в списке");
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
 
        // Удаление коллекции через итератор
        // Снова создаем коллекцию для демонстрации
        col1 = createFirstCollection();
        System.out.println("============= Удаление через итератор");
        while(!col1.isEmpty()) {
            Iterator it = col1.iterator();
            Object o = it.next();
            System.out.println("Удаляем:" + o);
            // Удаляем элемент
            it.remove();
        }
    }
 
}

//***Алгоритмы для работы с коллекциями

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MyClass {
 
    private String name;
 
    public MyClass(String name) {
        this.name = name;
    }
 
    @Override
    public String toString() {
        return name;
    }
 
    // Без методов equals и hashCode не будет замены в списках
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyClass other = (MyClass) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }
}


public class Lists {
    private static void printCollection(String title, List<MyClass> list) {
        System.out.println(title);
        for(MyClass mc : list) {
            System.out.println("Item:" + mc);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<MyClass> list = new ArrayList<MyClass>();
 
        list.add(new MyClass("Василий"));
        list.add(new MyClass("Павел"));
        list.add(new MyClass("Андрей"));
        list.add(new MyClass("Андрей"));
        list.add(new MyClass("Петр"));
        list.add(new MyClass("Анжелика"));
 
        printCollection("Оригинал", list);
 
        // Смешивание
        Collections.shuffle(list);
        printCollection("Смешивание", list);
 
        // Обратный порядок
        Collections.reverse(list);
        printCollection("Обратный порядок", list);
 
        // "Проворачивание" на определенное количество
        Collections.rotate(list, 2); // Число может быть отрицательным - тогда порядок будет обратный
        printCollection("Проворачивание", list);
 
        // Обмен элементов
        Collections.swap(list, 0, list.size()-1);
        printCollection("Обмен элементов", list);
 
        // Замена
        Collections.replaceAll(list, new MyClass("Андрей"), new MyClass("Алексей"));
        printCollection("Замена", list);
 
        // Копирование - здесь обязательно надо иметь нужные размеры
        List<MyClass> list2 = new ArrayList<MyClass>(list.size());
        // Поэтому заполняем список. Хоть чем-нибудь.
        for(MyClass mc : list) {
            list2.add(null);
        }
        // Компируем из правого аргумента в левый
        Collections.copy(list2, list);
        printCollection("Копирование", list2);
 
        // Полная замена
        Collections.fill(list2, new MyClass("Антон"));
        printCollection("Полная замена", list2);

    }
    
}

//*** Сортировка
import java.util.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class MyClass
{
    private String name;
 
    public MyClass(String name) {
        this.name = name;
    }
 
    @Override
    public String toString() {
        return name;
    }
}

class MyClassCompare implements Comparable<MyClassCompare>
{
    private String name;
 
    public MyClassCompare(String name) {
        this.name = name;
    }
 
    // этот метод как раз и сравнивает текущий объект с другим,
    // который передается в качестве аргумента
    public int compareTo(MyClassCompare o) {
        return name.compareTo(name);
    }
 
    @Override
    public String toString() {
        return name;
    }
}

class MyClassComparator implements Comparator
{
    public int compare(Object o1, Object o2) {
        return o1.toString().compareTo(o2.toString());
    }
}


public class Sort {
    private static void printCollection1(String title, List<MyClassCompare> list) {
        System.out.println(title);
        for (MyClassCompare mc : list) {
            System.out.println("Item:" + mc);
        }
        System.out.println();
    }
 
    private static void printCollection2(String title, List<MyClass> list) {
        System.out.println(title);
        for (MyClass mc : list) {
            System.out.println("Item:" + mc);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Вариант сортировки через Comparator");
        List<MyClassCompare> listSort = new ArrayList<MyClassCompare>();
        listSort.add(new MyClassCompare("Василий"));
        listSort.add(new MyClassCompare("Павел"));
        listSort.add(new MyClassCompare("Андрей"));
        listSort.add(new MyClassCompare("Андрей"));
        listSort.add(new MyClassCompare("Петр"));
        listSort.add(new MyClassCompare("Анжелика"));
        // Сортировка через Comparable
        printCollection1("Без сортировки", listSort);
        Collections.sort(listSort);
        printCollection1("После сортировки", listSort);
 
        System.out.println("Вариант сортировки через Comparator");
        List<MyClass> list = new ArrayList<MyClass>();
        list.add(new MyClass("Василий"));
        list.add(new MyClass("Павел"));
        list.add(new MyClass("Андрей"));
        list.add(new MyClass("Андрей"));
        list.add(new MyClass("Петр"));
        list.add(new MyClass("Анжелика"));
        // Сортировка с классом Comparator
        printCollection2("Без сортировки", list);
        Collections.sort(list, new MyClassComparator());
        printCollection2("После сортировки", list);
        
    }
    
}

