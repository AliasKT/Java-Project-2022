import javax.swing.*;
import java.security.SecureRandom;

public class Magic8Ball {

    private final static SecureRandom randomNumber = new SecureRandom();
    private final static String[] answers = {
            "It is certain.",
            "It is decidedly so.",
            "Without a doubt.",
            "Yes - definitely.",
            "You may rely on it.",
            "As I see it, yes.",
            "Most likely.",
            "Outlook good.",
            "Signs point to yes.",
            "Yes.",
            "Reply hazy, try again.",
            "Ask again later.",
            "Better not tell you now.",
            "Cannot predict now.",
            "Concentrate and ask again.",
            "Don't count on it.",
            "My reply is no.",
            "My sources say no.",
            "Outlook not so good.",
            "Very doubtful."};

    public static void main(String[] args) {
        boolean askQuestion = true;

        while (askQuestion) {
            String question = getUserQuestion();
            String randomAnswer = getRandomAnswer();

            displayAnswer(question, randomAnswer);

            askQuestion = userWantsToAskAnotherQuestion();
        }

        showExitMessage();
    }

    private static String getUserQuestion() {
        return JOptionPane.showInputDialog(null,
                "Enter a yes/no question:",
                "Ask the Magic 8 ball.",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static String getRandomAnswer() {
        return answers[randomNumber.nextInt(answers.length)];
    }

    private static void displayAnswer(String question, String randomAnswer) {
        JOptionPane.showMessageDialog(null, question + "\n" + randomAnswer, "The Magic 8 Ball has responded.", JOptionPane.PLAIN_MESSAGE);
    }

    private static boolean userWantsToAskAnotherQuestion() {
        return 0 == JOptionPane.showConfirmDialog(null, "Have another question?", "Ask again?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    private static void showExitMessage() {
        JOptionPane.showMessageDialog(null, "Have a good day.", "Your questions have been answered.", JOptionPane.PLAIN_MESSAGE);
    }
}