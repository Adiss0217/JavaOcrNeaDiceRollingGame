import java.io.*;

public final class loginclass 
{

    public static Boolean login(String Name, String Password) throws IOException
    {
        String path = "Nea\\Files\\authplayers.csv";
        BufferedReader rd = null;
        String line= "";
        
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
                        return true;
                    }
                    else
                    {
                        System.out.println("The Password was a fail");
                        return false;
                    }
                }
            } 
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
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