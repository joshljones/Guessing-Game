public class GuessingGame {
  public static void main(String[] args) {
    Jar jar = new Jar(null,0);
    Prompter prompter = new Prompter(jar);
    prompter.promptForInput();
    prompter.guessAmount();
  }
}
