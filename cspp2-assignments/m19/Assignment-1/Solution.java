import java.util.Scanner;

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
   * @param      s              The scanner object for user input
   * @param      quiz           The quiz object
   * @param      questionCount  The question count
   */
  public static void loadQuestions(final Scanner s,
                                   final Quiz quiz, final int questionCount) {
    // write your code here to read the questions from the console
    // tokenize the question line and create the question object
    // add the question objects to the quiz class

    if (questionCount < 1) {
      System.out.println("Quiz does not have questions");
    } else {
      for (int i = 0; i < questionCount; i++) {
        String[] arg = s.nextLine().split(":");
        final int num1 = 3;
        final int num2 = 4;
        question nQ = new question(arg[0], arg[1], arg[2], arg[num1],
                                   arg[num2]);
        if (nQ.errQues) {
          System.out.println("Error! Malformed question");
          break;
        } else {
          quiz.addToQuiz(nQ);
          System.out.println(questionCount + " are added to the quiz");
        }
      }
    }
  }

  /**
   * Starts a quiz.
   *
   * @param      s            The scanner object for user input
   * @param      quiz         The quiz object
   * @param      answerCount  The answer count
   */
  public static void startQuiz(final Scanner s,
                               final Quiz quiz, final int answerCount) {
    // write your code here to display the quiz questions
    // read the user responses from the console
    // store the user respones in the quiz object
    int i = 0;
    for (question q : quiz.getQList()) {
      if (!q.errQues) {
        quiz.getQ(i).print();
        // String[] tempAns = s.nextLine();
        quiz.setA(i, s.nextLine());
      }
      i += 1;
    }

  }

  /**
   * Displays the score report.
   *
   * @param      quiz     The quiz object
   */
  public static void displayScore(final Quiz quiz) {
    // write your code here to display the score report
    int qNumber = 0;
    int totScore = 0;
    for (question q : quiz.getQList()) {
      if (!q.errQues) {
        System.out.println(q.qText);
        if (q.corrChoice.equals(quiz.getAnswers(qNumber))) {
          System.out.println(
            " Correct Answer! - Marks Awarded: " + q.maxMarks);
          totScore += Integer.parseInt(q.maxMarks);
        } else {
          System.out.println(" Wrong Answer! - Penalty: " + q.penalty);
          totScore += Integer.parseInt(q.penalty);
        }
        qNumber += 1;
      }
      System.out.println("Total Score: " + totScore);

    }
  }
}


