package hw5;

// Задача № 141
// Лабиринт задан квадратной матрицей А. Аk = 0, если клетка "проходима"; Аk = 1, если клетка
// "непроходима". Начальное положение путника задается в проходимой клетке А = 0. Путник может перемещаться
// из одной проходимой клетки в другую, если они имеют общую сторону. Путник выходит из лабиринта, когда
// попадает в граничную клетку. Может ли путник выйти из лабиринта? Если может, то напечатать путь от выхода
// (в виде координат точек на маршруте) до начального положения путника. Путь должен иметь минимальную длину.

// Недостатки решения:
// - сделано немного кастыльно
// - алгоритм возможно не самый оптимальный, преследовалась цель хотя решить правильно
// - для того что бы понять, как решить данную задачу использовалась литература, где объяснялся алгоритм решения
//   подобных задач

import java.util.Arrays;

public class Labyrinth
{
    // поле лабиринта, можно задать матрицу и большего значения, для проверки выбрана такая
    static int [][] massifLabyrinth =
            {
                    {1, 1, 1, 0, 1},
                    {1, 0, 0, 0, 1},
                    {1, 0, 1, 0, 1},
                    {1, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1}
            };
    // массив для показа решения выхода из лабиринта по шагово
    static int [][] massifSolution = null;
    // массив для отображения координат шагов выгода
    static int [][]coordinates = null;
    // первоначальноен значение для минимального количества шагов для выхода
    static int min = (int)Math.pow(2,30);
    // первоначальное значения начала поиска выхода из лабиринта
    static int k = 2;
    // первоначальная координата элемента, для которой находится выход ("Начальное положение путника")
    static int i1 = 3, j1 = 2;
    // для суженной задачи, если необходимо найти выкод к конкретной координате
    // static int i2 = 0, j2 = 3;

    public static void main(String[] args)
    {
        // Массив massifLabyrinth задан таким образом, что выход есть
        // Массив massifSolution совпадает по размерности с massifLabyrinth (фактически карта выхода)
        massifSolution = new int[massifLabyrinth.length][massifLabyrinth[0].length];
        printMassif(massifLabyrinth);
        // Поиск решения
        move(i1, j1);
        // Ответ
        System.out.println("Решение:");
        System.out.println("Координаты:");
        printCoordinatesMassif();
        System.out.println("Шаги кратчайшего выхода:");
        printMassif(massifSolution);
    }
    // печать массива на консоль
    public static void printMassif(int [][] massif)
    {
        int n = massif.length;
        for (int i = 0; i < n; i++)
        {
            System.out.println(Arrays.toString(massif[i]));
        }
        System.out.println();
    }
    // печать массива с координатными ходов
    public static void printCoordinatesMassif()
    {
        if (coordinates != null)
        {
            System.out.println(Arrays.toString(coordinates[0]));
            System.out.println(Arrays.toString(coordinates[1]));
        }
    }
    // поиск координат пошагового выхода из лабиринта для возможности отображения их в консоли через массив coordinates
    public static void findCoordnates(int [][] mas)
    {
        for (int k = 2; k < mas[0].length + 2; k++)
        {
            for(int i = 0; i < massifLabyrinth.length; i++)
            {
                for(int j = 0; j < massifLabyrinth[0].length; j++)
                {
                    if (massifLabyrinth[i][j] == k)
                    {
                        mas[0][k - 2] = i;
                        mas[1][k - 2] = j;
                        break;
                    }
                }
            }
        }
    }
    // копирование двухмерной матрицы в двухмерную
    public static void copyTwodimensionalArray(int a[][], int[][] b)
    {
        int n = a.length;
        int m = a[0].length;
        for (int i = 0 ; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                b[i][j] = a[i][j];
            }
        }
    }
    // ход поиска
    public static void move(int i, int j)
    {
        int boundary  = massifLabyrinth[i][j];
        massifLabyrinth[i][j] = k;
        k++;
        printMassif(massifLabyrinth);
        if((i == 0 || i == massifLabyrinth.length - 1 || j == 0 || i == massifLabyrinth[0].length - 1)&& boundary == 0)
        // if ((i == i2) && (j == j2)) // для поиска по кооординате к конкретному выходу
        {
            System.out.println("Выход найден");
            printMassif(massifLabyrinth);

            if (min > massifLabyrinth[i][j])
            {
                coordinates = new int[2][];
                int m = massifLabyrinth[i][j];
                for (int z = 0 ; z < 2; z++)
                {
                    coordinates[z]= new int[m - 1];
                }
                min = massifLabyrinth[i][j];
                findCoordnates(coordinates);
                copyTwodimensionalArray(massifLabyrinth, massifSolution);
            }
            massifLabyrinth[i][j] = 0;
            return;
        }
        else
        {
            if ((i + 1 <= massifLabyrinth.length)&&(massifLabyrinth[i + 1][j] == 0))
            {
                move(i + 1, j);
            }
            if ((j + 1 <= massifLabyrinth.length)&&(massifLabyrinth[i][ j + 1] == 0))
            {
                move(i,j + 1);
            }
            if ((j - 1 >= 0)&&(massifLabyrinth[i][j - 1] == 0))
            {
                move(i,j - 1);
            }
            if ((i - 1 >= 0)&&(massifLabyrinth[i - 1][j] == 0))
            {
                move(i - 1, j);
            }
        }
        massifLabyrinth[i][j] = 0;
        k--;
        System.out.println("-----");
        printMassif(massifLabyrinth);
    }
}
