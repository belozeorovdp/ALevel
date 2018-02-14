package hw4;

// Ханойские башни: переместить n дисков со стержня 1 на стержень 3, используя промежуточный
// стержень 2 и соблюдая законы Брамы:
//	1)диски можно перемещать с одного стержня на другой только по одному;
//	2) нельзя класть больший диск на меньший;
//	3) нельзя откладывать диски в сторону, при переносе дисков с одного стержня на другой можно
//     использовать промежуточный третий стержень, на котором диски должны находиться тоже только
//     в виде пирамиды, сужающейся кверху.
//  Программа должна выводить какой диск откуда куда переместить - для каждого шага.

// Материалы используемые для решения задачи
// http://algolist.manual.ru/maths/combinat/hanoi.php
// http://aliev.me/runestone/Recursion/TowerofHanoi.html
// http://alexandrsoldatkin.com/c-hanoi-tower/

import java.util.Scanner;

public class HanoiTower
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество дисков: ");
        int number = in.nextInt();
        if(number < 0)
        {
            System.out.println("Error! Вы ввели отрицательное число.");
            return;
        }

        int amount = number;
        int rows = amount;
        final int cols = 3;
        int board [][] = new int [rows][cols];
        showBoard(board);
        moveTower( amount, 'A', 'B', 'C', board, rows, cols);
    }

    /**
     * <p> Метод move - Вывод массива на консоль </p>
     *
     * @param board  Исходный массив
     * @return       Выход из метода
     */
    public  static void showBoard(int [][] board )
    {

        for (int i = 0; i < board.length; i++)
        {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] == 0)
                {
                    System.out.print(" " + "|");
                }
                else
                {
                    System.out.print(board[i][j] + "|");
                }
            }
            System.out.println();
        }
        System.out.print("-------");
        System.out.println();
        System.out.println();
    }

    /**
     * <p>Метод isEmpty - проверка массива на заполненность</p>
     *
     * @param board  Исходный массив
     * @return true - массив пустой, false - массив заполненный
     */
    public static boolean isEmpty (int [][] board)
    {
        int lastRowIndex = board.length - 1;
        for (int j = 0; j < board[0].length; j++)
        {
            if (board[lastRowIndex][j] != 0)
            {
                return false;
            }
        }

        return true;
    }

    /**
     * <p>Метод initBoard - заполнение первой строки массива дисками разного веса
     *
     * @param diskCount  Количество дисков разного веса
     * @param board      Исходный массив
     * @param nCol       Номер столбца заполнения
     * @return выход из метода
     */
    public static void initBoard (int diskCount, int [][] board, int nCol)
    {
        // индекс последней строки
        int lastRowIndex = board.length - 1;
        for (int i = lastRowIndex; diskCount > 0; i--)
        {
            board[i][nCol] = diskCount;
            diskCount--;
        }
    }

    /**
     * <p> Метод getRow - возвращение "высоты" для диска в колонке </p>
     *
     * @param nCol    Колонка
     * @return        Возвращаем значение
     */
    public static int getRow(int [][]board, int nCol)
    {
        int nRow = -1;
        for(int i = 0; i < board.length;i++)
        {
            if(board[i][nCol] != 0)
            {
                nRow = i;
                break;
            }
        }
        return nRow;
    }

    /**
     * <p> Метод move - передвигаем диск </p>
     *
     * @param point1  Начальная точка перемещения диска
     * @param point2  Конечная точка перемещения
     * @return        Выход из метода
     */
    public static void move(char point1, char point2, int [][]board)
    {
        System.out.println("Из позиции " + point1 + " в позицию " + point2);
        // 'A' 0
        // 'B' 1
        // 'C' 2
        int col1 = (int)point1 - (int)'A';
        int col2 = (int)point2 - (int)'A';
        int row1 = getRow(board,col1);
        int row2 = getRow(board,col2);

        // row2  -1,    row2 = row - 1;
        // row2  != -1, row2--;
        if (row2 == -1)
        {
            row2 = board.length - 1;
        }
        else
        {
            row2--;
        }
        int buf = board[row1][col1];
        board[row1][col1] = 0;
        board[row2][col2] = buf;
        showBoard(board);
    }

    /**
     * <p>Метод moveTower - передвигаем вю башню</p>
     *
     * @param amount  Количество дисков
     * @param point1  Начпльная очка перемещения диска
     * @param point2  Конечная точка перемещения
     * @param temp    Вспомагательная точка для перемещения
     * @return        Выход из метода
     */
    public static void moveTower( int amount, char point1, char point2, char temp, int  [][] board, int rows, int cols)
    {
        if (amount == 0)
        {
            return;
        }
        if (isEmpty(board))
        {
            int n = amount;
            initBoard (n > board.length?board[0].length:n,  board,  0);
            System.out.println("Исходная позиция");
            showBoard(board);
        }
        moveTower(amount - 1, point1, temp, point2, board, rows, cols);
        move(point1, point2, board);
        moveTower(amount - 1, temp, point2, point1, board, rows, cols);
    }
}