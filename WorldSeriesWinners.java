import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class WorldSeriesWinners
{
   public static void main(String[] args) throws IOException
   {
      int wins = 0;
      int year = 1903;                                         //Variable used to show the year each team won
      String team;
         
      ArrayList<Integer> yearsWon = new ArrayList<Integer>();  //ArrayList that holds the years each team won
      
      team = userInput();
      String teamLowerCase = team.toLowerCase();               //Creates a lowercase copy of the entered team
      
      File file = new File("WSWinners.txt");                   
      Scanner winnersFile = new Scanner(file);
      
      while (winnersFile.hasNext())
      {
         String tempTeam = winnersFile.nextLine();             //Temporary holds the team to add into the Array List
         tempTeam = tempTeam.toLowerCase();                    //Changes the string from the file to lowercase
         
         if (teamLowerCase.equals(tempTeam))                   //Counts the times the entered team won and adds the year to the ArrayList
         {
            yearsWon.add(year);
            wins++;
         }
            
         year++;
         
         if (year == 1904 || year == 1994)                     //Skips years where no World Series was played
            year++;
      }
      
      winnersFile.close();                                     //Closes the text file
      output(team, wins, yearsWon);
      
   }
    
   public static String userInput()                           
   {
     Scanner keyboard = new Scanner(System.in);
     System.out.println("Enter a Team (ex: St. Louis Cardinals)");
     String teamEntered = keyboard.nextLine();
     keyboard.close();
     
     return teamEntered;
   }
   
   public static void output(String team, int wins, ArrayList<Integer> yearsWon)
   {
      int i = 0;   
      
      System.out.println();
      System.out.println("The " + team + " have won " + wins + " World Series.");
      System.out.print("The years they won are: ");
      
      while (yearsWon.size() > i)                              //Displays the years the entered team won
      {
         System.out.print(yearsWon.get(i) + " ");
         i++;
      }
   }
}
         
