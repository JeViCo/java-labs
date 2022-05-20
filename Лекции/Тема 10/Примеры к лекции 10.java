import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class EduCollection {
    // ������ ��������� ��� �������
    private static Collection createFirstCollection() {
        // ������� ��������� �� ������ ������������ ������ ArrayList
        Collection col = new ArrayList();
        // ���������� � ���������
        col.add("1");
        col.add("2");
        col.add("3");
        col.add("4");
        col.add("5");
        col.add("6");
        col.add("7");
        return col;
    }
 
    // ������ ��������� ��� �������
    private static Collection createSecondCollection() {
        // ������� ��������� �� ������ ������������ ������ ArrayList
        Collection col2 = new ArrayList();
        col2.add("1");
        col2.add("2");
        col2.add("3");
        return col2;
    }

    public static void main(String[] args) {
        // ������� ��������� ��� ������������
        Collection col1 = createFirstCollection();
        Collection col2 = createSecondCollection();
 
        // ������������ ������� �� ���������
        System.out.println("============= ������ �� ���������");
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
 
        System.out.println();
        // ������������ ������� �� ��������� ����� ��������
        System.out.println("============= ������ �� ��������� ����� ��������");
        for (Iterator it = col1.iterator(); it.hasNext(); ) {
            String s = (String)it.next();
            System.out.println("Item:" + s);
        }
        System.out.println();
 
        // ������������ ��������� ��������
        System.out.println();
        System.out.println("============= ��������� ��������");
        // ����� ��������� ����������� �� ��� �������� col2 � col
        if(col1.containsAll(col2)) {
            System.out.println("��������� col �������� ��� �� col2");
        }
        
        System.out.println("============= ���������� ���� ��������� � col1 �� col2");
        // ����� �������� �������� �� col2 � col1
        col1.addAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        
        System.out.println("============= �������� ���� ��������� col2, ������� ���� � col1");
        // ����� ������� ��� �������� col2, ������� ���� � col1
        col1.removeAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        
        // ����������� ��������� ��� ����������� ������������
        col1 = createFirstCollection();
        col2 = createSecondCollection();
        System.out.println("============= �������� ��������� �� col1, ������� ��� � col2");
        col1.retainAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println("============= ������� ��������� - �� ����� ���������");
        col1.clear();
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println();
 
        // �������� �������� ���������
        // ����� ������� ��������� ��� ������������
        col1 = createFirstCollection();
        // ������� ���� �������
        col1.remove("1");
        System.out.println("============= ������� ������� '1' - ��� �� ����� � ������");
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
 
        // �������� ��������� ����� ��������
        // ����� ������� ��������� ��� ������������
        col1 = createFirstCollection();
        System.out.println("============= �������� ����� ��������");
        while(!col1.isEmpty()) {
            Iterator it = col1.iterator();
            Object o = it.next();
            System.out.println("�������:" + o);
            // ������� �������
            it.remove();
        }
    }
 
}

//***��������� ��� ������ � �����������

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
 
    // ��� ������� equals � hashCode �� ����� ������ � �������
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
 
        list.add(new MyClass("�������"));
        list.add(new MyClass("�����"));
        list.add(new MyClass("������"));
        list.add(new MyClass("������"));
        list.add(new MyClass("����"));
        list.add(new MyClass("��������"));
 
        printCollection("��������", list);
 
        // ����������
        Collections.shuffle(list);
        printCollection("����������", list);
 
        // �������� �������
        Collections.reverse(list);
        printCollection("�������� �������", list);
 
        // "��������������" �� ������������ ����������
        Collections.rotate(list, 2); // ����� ����� ���� ������������� - ����� ������� ����� ��������
        printCollection("��������������", list);
 
        // ����� ���������
        Collections.swap(list, 0, list.size()-1);
        printCollection("����� ���������", list);
 
        // ������
        Collections.replaceAll(list, new MyClass("������"), new MyClass("�������"));
        printCollection("������", list);
 
        // ����������� - ����� ����������� ���� ����� ������ �������
        List<MyClass> list2 = new ArrayList<MyClass>(list.size());
        // ������� ��������� ������. ���� ���-������.
        for(MyClass mc : list) {
            list2.add(null);
        }
        // ��������� �� ������� ��������� � �����
        Collections.copy(list2, list);
        printCollection("�����������", list2);
 
        // ������ ������
        Collections.fill(list2, new MyClass("�����"));
        printCollection("������ ������", list2);

    }
    
}

//*** ����������
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
 
    // ���� ����� ��� ��� � ���������� ������� ������ � ������,
    // ������� ���������� � �������� ���������
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
        System.out.println("������� ���������� ����� Comparator");
        List<MyClassCompare> listSort = new ArrayList<MyClassCompare>();
        listSort.add(new MyClassCompare("�������"));
        listSort.add(new MyClassCompare("�����"));
        listSort.add(new MyClassCompare("������"));
        listSort.add(new MyClassCompare("������"));
        listSort.add(new MyClassCompare("����"));
        listSort.add(new MyClassCompare("��������"));
        // ���������� ����� Comparable
        printCollection1("��� ����������", listSort);
        Collections.sort(listSort);
        printCollection1("����� ����������", listSort);
 
        System.out.println("������� ���������� ����� Comparator");
        List<MyClass> list = new ArrayList<MyClass>();
        list.add(new MyClass("�������"));
        list.add(new MyClass("�����"));
        list.add(new MyClass("������"));
        list.add(new MyClass("������"));
        list.add(new MyClass("����"));
        list.add(new MyClass("��������"));
        // ���������� � ������� Comparator
        printCollection2("��� ����������", list);
        Collections.sort(list, new MyClassComparator());
        printCollection2("����� ����������", list);
        
    }
    
}

