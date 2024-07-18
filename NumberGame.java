import java.util.Random;
import java.util.Scanner;

public class NumberGame 
{
    private static final int MAX_ATTEMPTS = 5;
    private static final int MIN = 1;
    private static final int MAX = 100;
    
    public static void main(String arg[])
      {
          Scanner scanner = new Scanner(System.in);
          
          boolean playAgain;
          do 
           {
             int magicNumber = generateRandomNumber();
             int attempts = 0;
             boolean guessedCorrectly = false;

             System.out.println("Welcome to the Number Game!");
             System.out.println("Guess the number between " + MIN + " and " + MAX + ":");
            
             while (attempts < MAX_ATTEMPTS && !guessedCorrectly) 
                {
                  attempts++;
                  System.out.print("Attempt " + attempts + ": ");
                  int userGuess = scanner.nextInt();
                
                  if (userGuess < MIN || userGuess > MAX)
                    {
                       System.out.println("Please enter a number between " + MIN + " and " + MAX + ".");
                       attempts--;
                       continue;
                    }

                  if (userGuess == magicNumber) 
                    {
                       guessedCorrectly = true;
                       System.out.println("Congratulations! You guessed the number correctly.");
                    } 
                  
                  else if (userGuess < magicNumber)
                    {
                    System.out.println("The number you guessed is too low! Please Try again.");
                    }  
                  else 
                    {
                    System.out.println("The number you guessed is too high! Please Try again.");
                    }
                }
            
             if (!guessedCorrectly)
               {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + magicNumber + ".");
               }

             System.out.println("You took " + attempts + " attempt(s).");
             System.out.print("Do you want to play again? (true/false): ");
             String response = scanner.next();
             playAgain = response.equalsIgnoreCase("true");
            
           } while (playAgain);

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
    
    private static int generateRandomNumber()
    {
        int random=((int) (Math.random()*100))+1;
        return random;
    }
}
