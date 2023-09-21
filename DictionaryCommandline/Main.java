import java.io.IOException;

public class Main {
    // clear the screen
    private static void cls() throws IOException, InterruptedException 
    { 
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void main(String[] args)  throws Exception
    {
        cls();

        boolean isContinue = false;
        
        do
        {

        } while (isContinue);
    }
}