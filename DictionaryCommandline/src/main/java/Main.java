import Dict.DictionaryCommandline;

public class Main {
    public static void main(String[] args)  throws Exception
    {
        boolean isContinue;
        DictionaryCommandline cmdDict = new DictionaryCommandline();

        do
        {
            isContinue = cmdDict.dictionaryAdvanced();
        } while (isContinue);
    }
}