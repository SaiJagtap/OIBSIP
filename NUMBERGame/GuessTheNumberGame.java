import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;
        int rounds = 0;

        Random random = new Random();
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        boolean gameRunning = true;
        while (gameRunning) {
            int attempts = 0;
            rounds++;

            JOptionPane.showMessageDialog(null,
                    "Round " + rounds + "\nGuess a number between " + minRange + " and " + maxRange);

            while (attempts < maxAttempts) {
                String input = JOptionPane.showInputDialog("Attempt " + (attempts + 1) + ": Enter your guess");

                try {
                    int guess = Integer.parseInt(input);

                    if (guess == randomNumber) {
                        score += maxAttempts - attempts;
                        JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in "
                                + (attempts + 1) + " attempts.\nYour score: " + score);
                        break;
                    } else if (guess < randomNumber) {
                        JOptionPane.showMessageDialog(null, "Try a higher number!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Try a lower number!");
                    }

                    attempts++;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }

            if (attempts >= maxAttempts) {
                JOptionPane.showMessageDialog(null, "You've used all your attempts.\nThe number was: " + randomNumber);
            }

            int option = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again?",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION) {
                gameRunning = false;
            } else {
                randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            }
        }

        JOptionPane.showMessageDialog(null, "Game Over!\nYour total score: " + score);
    }
}
