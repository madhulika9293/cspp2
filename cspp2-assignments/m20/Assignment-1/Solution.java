import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
  /**
   * Text of the question.
   */
  private String questiontext;
  /**
   * Choices.
   */
  private String[] choices;
  /**
   * Correct Answer.
   */
  private int correctAnswer;
  /**
   * Maximum Marks.
   */
  private int maxMarks;
  /**
   * Penalty for wrong answer.
   */
  private int penalty;
  /**
   * Response from the user.
   */
  private String response;
  /**
   * Constructs the object.
   */
  Question() {

  }
  /**
   * Constructs the object.
   *
   * @param      question1       The question 1
   * @param      choices1        The choices 1
   * @param      correctAnswer1  The correct answer 1
   * @param      maxMarks1       The maximum marks 1
   * @param      penalty1        The penalty 1
   */
  Question(final String question1, final String[] choices1,
           final int correctAnswer1, final int maxMarks1, final int penalty1) {
    questiontext = question1;
    choices = choices1;
    correctAnswer = correctAnswer1;
    maxMarks = maxMarks1;
    penalty = penalty1;
  }
  /**
   * Evaluate the response.
   *
   * @param      choice  The choice
   *
   * @return     boolean.
   */
  public boolean evaluateResponse(final String choice) {
    if (choice == getCorrectAnswer()) {
      return true;
    }
    return false;
  }
  /**
   * Gets the correct answer.
   *
   * @return     The correct answer.
   */
  public String getCorrectAnswer() {
    return choices[correctAnswer];
  }
  /**
   * Gets the question text.
   *
   * @return     The question text.
   */
  public String getQuestionText() {
    return questiontext;
  }
  /**
   * Gets the choice.
   *
   * @return     The choice.
   */
  public String[] getChoice() {
    return choices;
  }
  /**
   * Gets the maximum marks.
   *
   * @return     The maximum marks.
   */
  public int getMaxMarks() {
    return maxMarks;
  }
  /**
   * Gets the penalty.
   *
   * @return     The penalty.
   */
  public int getPenalty() {
    return penalty;
  }
  /**
   * Sets the response.
   *
   * @param      answer  The answer
   */
  public void setResponse(final String answer) {
    response = answer;
  }
  /**
   * Gets the response.
   *
   * @return     The response.
   */
  public String getResponse() {
    return response;
  }
  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    System.out.println(questiontext + "(" + maxMarks + ")");
    String s = "";
    for (String c : choices) {
      s += c + "		";
    }
    s = s.substring(0, s.length() - 1) + "\n";
    return s;
  }
}
/**
 * Class for quiz.
 */
class Quiz {
  /**
   * { var_description }.
   */
  private final int onehundred = 100;
  /**
   * List of questions.
   */
  private Question[] questions;
  /**
   * number of questions in the quiz.
   */
  private int size;
  /**
   * Constructs the object.
   */
  Quiz() {
    questions = new Question[onehundred];
    size = 0;
  }
  /**
   * Adds a question.
   *
   * @param      q     The question
   */
  public void addQuestion(final Question q) {
    questions[size] = q;
    size += 1;
  }
  /**
   * Gets the question.
   *
   * @param      index  The index
   *
   * @return     The question.
   */
  public Question getQuestion(final int index) {
    return questions[index];
  }
  /**
   * Shows the report.
   *
   * @return     the report.
   */
  public String showReport() {
    String s = "";
    return s;
  }
  /**
   * Gets the size.
   *
   * @return     The size.
   */
  public int getSize() {
    return size;
  }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
  /**
  * Constructs the object.
  */
  private Solution() {
    // leave this blank
  }
  /**
   * main function to execute test cases.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    // instantiate this Quiz
    Quiz q = new Quiz();
    // code to read the test cases input file
    Scanner s = new Scanner(System.in);
    // check if there is one more line to process
    while (s.hasNext()) {
      // read the line
      String line = s.nextLine();
      // split the line using space
      String[] tokens = line.split(" ");
      // based on the list operation invoke the corresponding method
      switch (tokens[0]) {
      case "LOAD_QUESTIONS":
        System.out.println("|----------------|");
        System.out.println("| Load Questions |");
        System.out.println("|----------------|");
        loadQuestions(s, q, Integer.parseInt(tokens[1]));
        break;
      case "START_QUIZ":
        System.out.println("|------------|");
        System.out.println("| Start Quiz |");
        System.out.println("|------------|");
        startQuiz(s, q, Integer.parseInt(tokens[1]));
        break;
      case "SCORE_REPORT":
        System.out.println("|--------------|");
        System.out.println("| Score Report |");
        System.out.println("|--------------|");
        displayScore(q);
        break;
      default:
        break;
      }
    }
  }
  /**
   * Loads questions.
   *
   * @param      scan       The scan
   * @param      quiz       The quiz
   * @param      q          The question count
   *
   */
  public static void loadQuestions(final Scanner scan,
                                   final Quiz quiz, final int q) {
    // write your code here to read the questions from the console
    // tokenize the question line and create the question object
    // add the question objects to the quiz class
    if (q <= 0) {
      System.out.println("Quiz does not have questions");
      return;
    }
    for (int i = 0; i < q; i++) {

      String[] arg = scan.nextLine().split(":");

      final int num1 = 3;
      final int num2 = 4;

      if (arg[0] == "" || arg[1] == ""
          || arg[2] == "" || arg[num1] == "" || arg[num2] == "") {
        System.out.println("Error! Malformed question");
        return;
      }

      if (arg[1].split(",").length <= 2) {
        System.out.println(arg[0] + " does not have enough answer choices");
        return;
      }

      if (Integer.parseInt(arg[num1]) <= 0) {
        System.out.println("Invalid max marks for " + arg[0]);
        return;
      }

      if (Integer.parseInt(arg[num2]) > 0) {
        System.out.println("“Invalid penalty for " + arg[0]);
        return;
      }

      Question nQ = new Question(arg[0], arg[1].split(","),
                                 Integer.parseInt(arg[2]),
                                 Integer.parseInt(arg[num1]),
                                 Integer.parseInt(arg[num2]));
      quiz.addQuestion(nQ);
    }

    System.out.println(q + " are added to the quiz");
  }
  /**
   * Starts a quiz.
   *
   * @param      scan  The scan
   * @param      quiz  The quiz
   * @param      q     The answer count
   */
  public static void startQuiz(final Scanner scan,
                               final Quiz quiz, final int q) {
    // write your code here to display the quiz questions on the console.
    // read the user responses from the console using scanner object.
    // store the user respone in the question object
    if (quiz.getSize() == 0) {
      return;
    }

  }
  /**
   * Displays the score report.
   *
   * @param      quiz     The quiz object
   */
  public static void displayScore(final Quiz quiz) {
    // write your code here to display the score report using quiz object.
    if (quiz.getSize() == 0) {
      return;
    }
  }
}
