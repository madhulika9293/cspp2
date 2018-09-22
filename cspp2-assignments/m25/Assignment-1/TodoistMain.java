import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */

// class titleException extends Exception {
// 	titleException() {

// 	}
// }
/**
 * Class for task.
 */
class Task {
	/**
	 * title of the task.
	 */
	String title;
	/**
	 * person the task is assigned to.
	 */
	private String assignedTo;
	/**
	 * time taken to complete the task.
	 */
	private int timeToComplete;
	/**
	 * importance of the task.
	 */
	private  boolean important;
	/**
	 * urgency of the task.
	 */
	private boolean urgent;
	/**
	 * status of the task.
	 */
	private String status;

	/**
	 * Constructs the object.
	 */
	Task() {

	}

	/**
	 * Constructs the object.
	 *
	 * @param      title1           The title 1
	 * @param      assignedTo1      The assigned to 1
	 * @param      timeToComplete1  The time to complete 1
	 * @param      important1       The important 1
	 * @param      urgent1          The urgent 1
	 * @param      status1          The status 1
	 */
	Task(final String title1, final String assignedTo1,
	     final int timeToComplete1, final boolean important1,
	     final boolean urgent1, final String status1) throws Exception {

		if (title1.length() > 0) {
			title = title1;
		} else {
			throw new Exception("Title not provided");
		}
		assignedTo = assignedTo1;
		if (timeToComplete1 >= 0) {
			timeToComplete = timeToComplete1;
		} else {
			throw new Exception("Invalid timeToComplete " + timeToComplete1);
		}
		important = important1;
		urgent = urgent1;
		if (status1.equals("todo") || status1.equals("done")) {
			status = status1;
		} else {
			throw new Exception("Invalid status " + status1);
		}
	}

	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String out = "";
		String impStat = "";
		String urgStat = "";

		if (important) {
			impStat = "Important";
		} else {
			impStat = "Not Important";
		}

		if (urgent) {
			urgStat = "Urgent";
		} else {
			urgStat = "Not Urgent";
		}

		out = title + ", " + assignedTo + ", " + timeToComplete + ", "
		      + impStat + ", " + urgStat + ", " + status;
		return out;
	}

	/**
	 * Gets the title.
	 *
	 * @return     The title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * gets the person assigned to.
	 *
	 * @return     assigned to.
	 */
	public String getassignedTo() {
		return assignedTo;
	}

	/**
	 * Gets the important.
	 *
	 * @return     The important.
	 */
	public String getImportant() {
		if (important) {
			return "Important";
		} else {
			return "Not Important";
		}
	}

	/**
	 * Gets the urgent.
	 *
	 * @return     The urgent.
	 */
	public String getUrgent() {
		if (urgent) {
			return "Urgent";
		} else {
			return "Not Urgent";
		}
	}

	/**
	 * Gets the status.
	 *
	 * @return     The status.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Gets the imp.
	 *
	 * @return     The imp.
	 */
	public boolean getImp() {
		return important;
	}

	/**
	 * Gets the urg.
	 *
	 * @return     The urg.
	 */
	public boolean getUrg() {
		return urgent;
	}

}
/**
 * Class for todoist.
 */
class Todoist {

	/**
	 * Array of tasks.
	 */
	private Task[] tasks;
	/**
	 * size of the array.
	 */
	private int size;

	/**
	 * Constructs the object.
	 */
	Todoist() {
		final int max = 100;
		tasks = new Task[max];
		size = 0;
	}

	/**
	 * Adds a task.
	 *
	 * @param      tsk   The tsk
	 */
	public void addTask(final Task tsk) {
		tasks[size] = tsk;
		size += 1;
		System.out.println(tsk);
	}

	public Task getNextTask(final String person) {
		Task out = new Task();
		boolean flag = false;

		for (Task entry : tasks) {
			if (entry.getassignedTo().equals(person)) {
				if (entry.getStatus().equals("todo")
				        && entry.getImp() && !entry.getUrg()) {
					out = entry;
					flag = true;
				}
			}
		}

		if (!flag) {
			for (Task entry : tasks) {
				if (entry.getassignedTo().equals(person)) {
					if (entry.getStatus().equals("todo")
					        && entry.getImp() && !entry.getUrg()) {
						out = entry;
						flag = true;
					}
				}
			}

		}

		if (!flag) {
			out = null;
		}

		return out;
	}
	// /**
	//  * Returns a string representation of the object.
	//  */
	// public String toString() {
	// 	String out = "";
	// 	for (Task entry : tasks) {
	// 		out += entry.toString();
	// 		out += "\n";
	// 	}
	// 	return out;
	// }

}

/**
 * Class for todoist main.
 */
public class TodoistMain {

	/**
	 * Starts a test.
	 */
	public static void startTest() {
		Todoist todo = new Todoist();
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String[] tokens = s.nextLine().split(",");
			switch (tokens[0]) {
			case "task":
				testTask(tokens);
				break;
			case "add-task":
				testAddTask(todo, tokens);
				break;
			// case "print-todoist":
			// 	System.out.println(todo);
			// 	break;
			// case "get-next":
			// 	System.out.println(todo.getNextTask(tokens[1]));
			// 	break;
			// case "get-next-n":
			// 	int n = Integer.parseInt(tokens[2]);
			// 	Task[] tasks = todo.getNextTask(tokens[1], n);
			// 	System.out.println(Arrays.deepToString(tasks));
			// 	break;
			// case "total-time":
			// 	System.out.println(todo.totalTime4Completion());
			// 	break;
			default:
				break;
			}
		}
	}

	/**
	 * method to test add task.
	 *
	 * @param      todo    The todo
	 * @param      tokens  The tokens
	 */
	public static void testAddTask(final Todoist todo, final String[] tokens) {
		try {
			todo.addTask(createTask(tokens));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method to test the creation of task object.
	 *
	 * @param      tokens  The tokens
	 */
	public static void testTask(final String[] tokens) {
		try {
			System.out.println(createTask(tokens));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Creates a task object.
	 *
	 * @param      tokens     The tokens
	 *
	 * @return     Task object
	 *
	 * @throws     Exception  if task inputs are invalid
	 */
	public static Task createTask(final String[] tokens) throws Exception {
		String title = tokens[1];
		String assignedTo = tokens[2];
		int timeToComplete = Integer.parseInt(tokens[3]);
		boolean important = tokens[4].equals("y");
		boolean urgent = tokens[5].equals("y");
		String status = tokens[6];
		return new Task(
		           title, assignedTo, timeToComplete, important, urgent, status);
	}

	/**
	 * main method.
	 *
	 * @param      args  The command line arguments
	 */
	public static void main(final String[] args) {
		startTest();
	}
}
