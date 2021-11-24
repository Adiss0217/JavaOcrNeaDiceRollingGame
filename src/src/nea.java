package src;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;
public class nea
{
    static Random random;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //[StartLogin]
        System.out.println("Enter Login player 1");
        player p1 = login(scanner);
        
        System.out.println("Login for player 2");
        player p2 = login(scanner);

        //[EndLogin]
        for (int i = 0; i < 5; i++) 
        {
            System.out.println("Player 1's roll");
            p1.score += RollDice();
            System.out.println("player 1s Current Score is " + p1.score);
            System.out.println("Player 2's roll");
            p2.score += RollDice();
            System.out.println("player 2s Current Score is " + p2.score);
        }
        if(p1.score > p2.score){System.out.println("P1 Won");}else if(p1.score < p2.score){System.out.println("P2 Won");}else if(p1.score == p2.score){System.out.println("Tie");}
        scanner.close();
    }
    static player login(Scanner scanner)
    {
        final int maxguesscount = 5;
        int guesscount = 0;
        player p = null;
        // waiting for the guesscount to exceed the amount
        //login process
        while(guesscount < maxguesscount)
        {
            System.out.println(guesscount + "/" + maxguesscount);    
            System.out.println("Enter your name");
            String p1name = scanner.nextLine();
            System.out.println("Enter your password");
            String p1password = scanner.nextLine();
            try 
            {
                if(loginclass.login(p1name, p1password))
                {
                    System.out.println("The player has been returned");
                    p = new player(p1name,0);
                    break;
                }else
                {
                    guesscount++;
                }
            } catch (IOException e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(guesscount == maxguesscount)
        {
            p = null;
        }
        
        return p;
    }
    static int RollDice() 
    {
        TimeUnit tm = TimeUnit.SECONDS;
        int c = 0;
        try
        {
            
            int b = roll();
            System.out.print("You have rolled ");
            tm.sleep(1);
            System.out.print(" " + b);

            int s = roll();
            System.out.print(" Your second roll ");

            tm.sleep(1);
            System.out.println(" " + c);
            System.out.println("");
            c += b;
            c += s;
        }
        catch(InterruptedException e)
        {

        }
        return c;
    }
    static int roll()
    {
        random = new Random();
        int r = random.nextInt(6) + 1;
        if(r % 2 == 0)
        {
            //case is even
            r += 10;
        }else{ r -= 5;}
        return r;
    }    
} 

