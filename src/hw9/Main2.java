package hw9;

// Написать свой собственный код (в отдельном файле), который будет приводить к возникновению следующих исключений:
// - ClassCastException
// - NullPointerException
// - NumberFormatException (подсказка – преобразование строки в число)
// - ArrayIndexOutOfBoundsException
// Подумать и написать в комментарии, какие из этих исключений нужно обрабатывать в try/catch блоке.
// Отрефакторите код так, чтобы избежать возникновения исключений, если это возможно.Закоммитьте.


public class Main2
{
    public static void main(String[] args)
    {
        ExampleClass exampleClass = new ExampleClass();
        exampleClass.Metod1();
        String str = exampleClass.Metod21();
        exampleClass.Metod22();
        exampleClass.Metod3();
        exampleClass.Metod4();
    }

}
