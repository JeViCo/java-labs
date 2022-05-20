int a[];
int[] a;
int[] a[];
Point p, p1[], p2[][];

-------

int a[]=new int[5];
Point[] p = new Point[10];

int array[]=new int[5];
   for (int i=0; i<5; i++) {
     array[i]=i*i;
}
for (int j=0; j<5; j++) {
   System.out.println(j+"*"+j+"="+array[j]);
}

---------

int i[]=new int[5];
i[-2]=0;   // ошибка! индекс не может быть отрицательным

//------- Переменная длина
int i[]=new int[5];
...
i=new int[7];   // переменная та же, длина массива другая

//--------- Длина массива
Point p[]=new Point[5];
for (int i=0; i<p.length; i++) {
   p[i]=new Point(i, i);
} 

//--------- Объектный тип данных
Object o = new int[4];

Object arr[] = new Object[3];
arr[0]=new Object();
arr[1]=null;
arr[2]=arr;   // Элемент ссылается на весь массив!

//-------Инициализация массива
Point p[]=new Point[5];
for (int i=0; i<p.length; i++) {
   System.out.println(p[i]);
}

int i[]={1, 3, 5};
int j[]={};   // эквивалентно new int[0]


//Аналогично можно порождать массивы на основе объектных типов, например:
Point p=new Point(1,3);
Point arr[]={p, new Point(2,2), null, p};
// или
String sarr[]={"aaa", "bbb", "cde"+"xyz"};

