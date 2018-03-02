package hw9;

import java.util.Scanner;

public class ExampleClass
{
    // -----------------------------------------------------------------
    // 1. ClassCastException
    // -----------------------------------------------------------------
    public class ClassA
    {
        private int a;

        public int getA()
        {
            return a;
        }

        public void setA(int a)
        {
            this.a = a;
        }
    }

    public class ClassB1 extends ClassA
    {
        private int b;

        public int getB()
        {
            return b;
        }

        public void setA(int b)
        {
            this.b = b;
        }
    }

    public class ClassB2 extends ClassA
    {
        private int b;

        public int getB()
        {
            return b;
        }

        public void setA(int b)
        {
            this.b = b;
        }
    }

    // Исключение java.lang.ClassCastException возникает при попытке приведения объекта к подклассу,
    // экземпляром которого он не является.
    // Решение: Всякий раз при приведении типов делается проверка на возможность приведения
    // (проверка осуществляется с помощью instanceof)
    public void Metod1()
    {
        // Ситуация ошибки
        /*
        ClassA   a = new ClassB1();
        // Exception in thread "main" java.lang.ClassCastException: hw9.ExampleClass$ClassB1 cannot be cast to hw9.ExampleClass$ClassB2
        ClassB2 b2 = (ClassB2)a;
        */
        // Решение без try/catch блока
        ClassA   a = new ClassB1();
        // Exception in thread "main" java.lang.ClassCastException: hw9.ExampleClass$ClassB1 cannot be cast to hw9.ExampleClass$ClassB2
        if ( a instanceof ClassB2)
        {
            ClassB2 b2 = (ClassB2) a;
        }
        else
        {
            System.out.println("a не является ClassB2" );
        }

        // Пример из учебника "Исключение ClassCastException" оставил для себя
        Object ch = new Character('*');
        try
        {
            System.out.println((Byte)ch);
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
    // -----------------------------------------------------------------
    // -----------------------------------------------------------------
    // 2. NullPointerException
    // -----------------------------------------------------------------

    // Если попытаться использовать в программе ссылку, содержащую значение null,
    // возникнет исключение NullPointerException (ссылка на объект, к которому вы обращаетесь хранит null)

    // пример 1. ошибки из Main1() этого ДЗ перенесен сюда
    // решение проверка null
    public String Metod21()
    {
        // Ситуация ошибки
        /*
        StringBuilder stringBuilder = null;
        return stringBuilder.toString();
        */
        // решение
        StringBuilder stringBuilder = null;
        if (stringBuilder ==  null)
        {
            return null;
        }
        else
        {
            return stringBuilder.toString();
        }
    }

    // пример 2. Верен для Java 7. Возникновение ошибки
    /*
    public void doSomething(Integer i)
    {
        // Работаем с i
    }
    public void Medod22()
    {
        Integer i = null;
        doSomething(i);
    }
    */
    // решение ошибки
    public void doSomething(Integer i)
    {
        if (i != null)
        {
            // Работаем с i
        }
        else
        {
            throw new IllegalArgumentException("i не должен быть null");
            // Работаем с i
        }
    }
    public void Metod22()
    {
        Integer i = null;
        i = new Integer(10);
        doSomething(i);
    }
    // -----------------------------------------------------------------
    // -----------------------------------------------------------------
    // 3. NumberFormatException
    // -----------------------------------------------------------------

    // Исключение NumberFormatException появляется при попытке распарсить строку как число, если это строка содержит
    // неверные символы.

    public void Metod3()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        String nameNumber = scanner.nextLine();
        // появление ошибки при попытке преобразовать символ в число
        // Exception in thread "main" java.lang.NumberFormatException: For input string: "q"
        /*
        int i = Integer.parseInt(nameNumber);
        */

        // решение  без try/catch
        // (int от -2147483648 до 2147483647)
        // '-' 45
        // '0' 48
        // '1' 49
        // '2' 50
        // '3' 51
        // '4' 52
        // '5' 53
        // '6' 54
        // '7' 55
        // '8' 56
        // '9' 57
        boolean indexError = false;
        for (int j = 0; j < nameNumber.length(); j++)
        {
            char ch = nameNumber.charAt(j);
            if ((ch >= 48 && ch <= 57) || (j == 0 && ch == 45))
            {
                indexError = true;
            }
            else
            {
                indexError = false;
                break;
            }
        }
        // проверка диапазона в лоб
        if ((nameNumber.charAt(0) == 45 && nameNumber.length() < 11) || nameNumber.charAt(0) != 45 && nameNumber.length() < 10)
        {
            indexError = true;
        }
        else if ((nameNumber.charAt(0) == 45 && nameNumber.length() > 11) || nameNumber.charAt(0) != 45 && nameNumber.length() > 10)
        {
            indexError = false;
        }
        else if ((nameNumber.charAt(0) == 45 && nameNumber.length() == 11) || nameNumber.charAt(0) != 45 && nameNumber.length() == 10)
        {
                if ((nameNumber.charAt(0) == 45 && nameNumber.charAt(1) > 50) || (nameNumber.charAt(0) != 45 && nameNumber.charAt(0) > 50))
                {
                    indexError = false;
                }
                else if ((nameNumber.charAt(0) == 45 && nameNumber.charAt(2) > 49) || (nameNumber.charAt(0) != 45 && nameNumber.charAt(1) > 49))
                {
                    indexError = false;
                }
                else if ((nameNumber.charAt(0) == 45 && nameNumber.charAt(3) > 52) || (nameNumber.charAt(0) != 45 && nameNumber.charAt(2) > 52))
                {
                    indexError = false;
                }
                else if ((nameNumber.charAt(0) == 45 && nameNumber.charAt(4) > 55) || (nameNumber.charAt(0) != 45 && nameNumber.charAt(3) > 55))
                {
                    indexError = false;
                }
                else if ((nameNumber.charAt(0) == 45 && nameNumber.charAt(5) > 52) || (nameNumber.charAt(0) != 45 && nameNumber.charAt(4) > 52))
                {
                    indexError = false;
                }
                else if ((nameNumber.charAt(0) == 45 && nameNumber.charAt(6) > 56) || (nameNumber.charAt(0) != 45 && nameNumber.charAt(5) > 56))
                {
                    indexError = false;
                }
                else if ((nameNumber.charAt(0) == 45 && nameNumber.charAt(7) > 51) || (nameNumber.charAt(0) != 45 && nameNumber.charAt(6) > 51))
                {
                    indexError = false;
                }
                else if ((nameNumber.charAt(0) == 45 && nameNumber.charAt(8) > 54) || (nameNumber.charAt(0) != 45 && nameNumber.charAt(7) > 54))
                {
                    indexError = false;
                }
                else if ((nameNumber.charAt(0) == 45 && nameNumber.charAt(9) > 52) || (nameNumber.charAt(0) != 45 && nameNumber.charAt(8) > 52))
                {
                    indexError = false;
                }
                else if ((nameNumber.charAt(0) == 45 && nameNumber.charAt(10) > 56) || (nameNumber.charAt(0) != 45 && nameNumber.charAt(9) > 55))
                {
                    indexError = false;
                }
        }

        int i;
        if (indexError)
        {
            i = Integer.parseInt(nameNumber);
            System.out.println("i = " + i);
        }
        else
        {
            System.out.println("Ошибка! Не правильно ввели число.");
        }

    }
    // -----------------------------------------------------------------
    // -----------------------------------------------------------------
    // 4. ArrayIndexOutOfBoundsException
    // -----------------------------------------------------------------
    // ArrayIndexOutOfBoundsException исключение вызывается в случае попытки доступа к элементу массива используя
    // неверный индекс, отрицательный (-1) или больший или равный размеру массива, или если размер массива задан
    // нулевым, любой индекс.

    public void Metod4()
    {

        // пример 1: Массив с нулевым размером
        // ошибка: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
        /*
        int n = 0;
        int a[] = new int[n]; // здесь компилятор не выдает ошибки

        int b = 7;
        a[0] = b;             // ошибка
        */

        // решение
        int n = 0;
        int a[] = new int[n];

        int b = 7;

        int index = 0;
        if (a.length == 0 || index < 0 || index >= a.length)
        {
            System.out.println("Error!");
        }
        else
        {
            a[index] = b;
        }

        // пример 2: Отрицательный индекс
        // ошибка: java.lang.ArrayIndexOutOfBoundsException: -1
        /*
        n = 10;
        int a2[] = new int[n];
        index = -1;
        a2[index] = b;
        */

        // решение аналогичное
        n = 10;
        int a2[] = new int[n];

        index = -1;
        if (a2.length == 0 || index < 0 || index >= a2.length)
        {
            System.out.println("Error!");
        }
        else
        {
            a2[index] = b;
        }

        // пример 3: Индекс превышает длину массива
        // ошибка: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 11
        /*
        n = 10;
        int a7[] = new int[n];
        index = n + 1;
        a7[index] = b;
        */

        // решение аналогичное
        n = 10;
        int a7[] = new int[n];
        index = n + 1;

        if (a7.length == 0 || index < 0 || index >= a7.length)
        {
            System.out.println("Error!");
        }
        else
        {
            a7[index] = b;
        }
    }
    // -----------------------------------------------------------------
}
