package leson_task1;

public class ParsingFileTable
{
    public static String[] parsingString(String string)
    {
        String delimiter =",";
        return string.split(delimiter);
    }
}
