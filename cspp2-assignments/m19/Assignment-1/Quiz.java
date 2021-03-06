import java.util.Scanner;
import java.util.ArrayList;

class question {
	String qText;
	String cList;
	String corrChoice;
	String maxMarks;
	String penalty;
	boolean errQues;

	question(final String qText1, final String cList1, final String corrChoice1,
	         final String maxMarks1, final String penalty1) {
		qText = qText1;
		cList = cList1;
		corrChoice = corrChoice1;
		maxMarks = maxMarks1;
		penalty = penalty1;
		errQues = false;

		if (qText1.length() == 0 || cList1.length() == 0 || corrChoice1.length() == 0 ||
			maxMarks1.length() == 0 || penalty1.length() == 0) {
			errQues = true;
		}
	}

	public void print() {
		System.out.println(qText + "(" + maxMarks + ")");
		String[] choiceArr = cList.split(",");
		String choices = "";
		for (String choice : choiceArr) {
			choices = choices + choice + "	";
		}
		System.out.println(choices.substring(0, choices.length() - 1) + "\n");
		// System.out.println();
	}

	public boolean getErr() {
		return errQues;
	}

}
/**
 * Class for quiz.
 */
class Quiz {
	private ArrayList<question> qList;
	private String[] answers;

	Quiz() {
		qList = new ArrayList<>();
		answers = new String[20];
	}

	public void addToQuiz(final question ques) {
		qList.add(ques);
	}

	public void print() {
		for (question ques : qList) {
			// System.out.println(ques);
			ques.print();
		}
	}

	public question getQ(final int qNum) {
		return qList.get(qNum);
	}

	public void setA(final int index, final String ans) {
		answers[index] = ans;
	}

	public String getA(final int qNum) {
		return answers[qNum];
	}

	public ArrayList<question> getQList() {
		return qList;
	}

	public String getAnswers(final int qNum) {
		return answers[qNum];
	}

	public int numQues() {
		return qList.size();
	}

	public boolean geterrQues(final int index) {
		return qList.get(index).getErr();
	}

}

