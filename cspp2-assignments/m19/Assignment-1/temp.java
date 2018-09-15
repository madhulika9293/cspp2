import java.util.Scanner;

public final class temp {
	temp() {

	}
	public static void main(final String[] args) {
		// instantiate this Quiz
		Quiz q = new Quiz();
		// code to read the test cases input file
		Scanner s = new Scanner(System.in);
		// check if there is one more line to process
		while (s.hasNext()) {
			// read the line
			String line = s.nextLine();
			// System.out.println(line.toString());
			// split the line using space
			String[] tokens = line.split(" ");
			// for (int i=0;i<tokens.length;i++) {
			// 	System.out.println(tokens[i]);
			// }
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
	public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
		// write your code here to read the questions from the console
		// tokenize the question line and create the question object
		// add the question objects to the quiz class
		if (questionCount < 1) {
			System.out.println("Quiz does not have questions");
		} else {
			for (int i = 0; i < questionCount; i++) {
				String[] arg = s.nextLine().split(":");
				question nQ = new question(arg[0], arg[1], arg[2], arg[3],
				                           arg[4]);
			}
			System.out.println(questionCount + " are added to the quiz");
		}
	}

	public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
		// write your code here to display the quiz questions
		// read the user responses from the console
		// store the user respones in the quiz object
		for (int i = 0; i < answerCount; i++) {
			quiz.getQ(i).print();
			String[] tempAns = s.nextLine().split(" ");
			quiz.setA(i, tempAns[1]);
			System.out.println(quiz.getA(i));
		}

	}

	public static void displayScore(final Quiz quiz) {
		// write your code here to display the score report
		int qNumber = 0;
		int totScore = 0;
		for (question q : quiz.getQList()) {
			System.out.println(q.qText);
			if (q.corrChoice.equals(quiz.getAnswers(qNumber))) {
				System.out.println(" Correct Answer! - Marks Awarded: " + q.maxMarks);
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

