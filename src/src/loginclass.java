package src;
import java.io.*;

public final class loginclass 
{

    public static Boolean login(String Name, String Password) throws IOException
    {
        Boolean b = false;
        BufferedReader rd = null;
        String line= "";
        File path = new File("files\\src\\src\\authplayers.csv"); 
        try 
        {
            
            rd = new BufferedReader(new FileReader(path));
            while((line = rd.readLine()) != null)
            {
                String[] row = line.split(",");
                if(ValidityChecker(row, Name))
                {
                    System.out.println("Name was passed");
                    if(Password.equals(row[LinearSearchIndex(row, Name) + 1])){
                        System.out.println("The Password was a sucess");
                        b = true;
                        break;
                    }
                    else
                    {
                        System.out.println("The Password was a fail");
                        b = false;
                    }

                }else
                {
                    System.out.println("try again mate");
                    b = false;
                }
            } 
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("File Not Found Dickhead");
        }
        return b;
    }
    public void SaveToLeaderBoard(player p1) throws IOException
    {
        File printFile = new File("ScoreBoard.csv");
        PrintWriter out = new PrintWriter(printFile);
        out.printf("%s, %d/n",p1.Name, p1.score);
        /*String path = "Nea\\Files\\ScoreBoard.csv";
        BufferedReader rd = null;
        String line= "";
        
        try 
        {
            rd = new BufferedReader(new FileReader(path));
            while((line = rd.readLine()) != null)
            {
                String[] row = line.split(",");
            } 
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        out.close();

    }
    // a contains function 
    public static <T> Boolean ValidityChecker(final T[] array, final T value)
    {
        if(value == null)
        {
            for (final T t : array) {
                if(t == null)
                    return true;
            }
        }else{
            for (final T t : array) {
                if(t == value || value.equals(t))
                    return true;
            }
        }
        return false;
    }
    // an interator
    public static <T> int LinearSearchIndex(final T[] array, final T Value)
    {
        for (int i = 0; i < array.length; i++) 
        {
            if(Value == array[i])
            {
                return i;
            }else
            {
                return 0;
            }
        }
        return 0;

    }
}
/*
we gotta get the password associated with the person 
*/