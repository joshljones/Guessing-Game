import java.util.Scanner;

public class Prompter {
  private Jar jar;
  public int guessItemAmount;
  public int numberOfTries = 0;
  public int repeat = 1;
  
  public Prompter(Jar jar){
    this.jar = jar;
  }
  
  
  public void promptForInput() {
    Scanner scanner = new Scanner(System.in);
    System.out.printf("------Welcome to the Guessing Game------%n%n");
    System.out.println("What type of item");
    jar.setItemsInJar(scanner.nextLine());
    do {
      try {
        System.out.printf("What is the maximum amount of %s?%n",
                          jar.getItemsInJar());
        jar.setItemCapacity(scanner.nextInt());
        repeat = 1;
      } catch(IllegalArgumentException iae) {
          System.out.println(iae.getMessage());
          repeat = 0;
      }
    } while (repeat == 0);
  }
  
  
  public void guessAmount() {
    Scanner scanner = new Scanner(System.in);
    jar.fillJar();
    System.out.printf("How many %s are in the jar? Pick a number between 1 and %d.%n",
                      jar.getItemsInJar(),
                      jar.getItemCapacity());
    guessItemAmount = scanner.nextInt();
    numberOfTries = 1;
    while (guessItemAmount != jar.getItemCount()) {
      if(guessItemAmount > jar.getItemCapacity()){
        System.out.printf("Your guess must be less than %d.%nTry again! Guess how many items are in the jar?%nPick a number from 1 to %d: ",
                            jar.getItemCapacity(),
                            jar.getItemCapacity());
        guessItemAmount = scanner.nextInt();
      } else {
        if(guessItemAmount > jar.getItemCount()) {
          System.out.printf("That was too high. Try again! Guess how many items are in the jar?%nPick a number from 1 to %d: ",
                            jar.getItemCapacity());
        }
        if (guessItemAmount < jar.getItemCount()) {
          System.out.printf("That was too low. Try again! Guess how many items are in the jar?%nPick a number from 1 to %d: ",
                            jar.getItemCapacity());
        }
        numberOfTries++;
        //System.out.printf("%n(%d)%n",numberOfTries);
        guessItemAmount = scanner.nextInt();
      }
      
    }
    System.out.printf("You got it in %d attempt(s)!%n%n",
                      numberOfTries);
  }
}