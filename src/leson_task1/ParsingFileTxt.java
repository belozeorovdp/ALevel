package leson_task1;

public class ParsingFileTxt
{
    public static String[] parsingString(String string)
    {
        String delimiter = " |\\(|\\)|\\):";
        return string.split(delimiter);
    }
}
