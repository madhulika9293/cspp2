// import java.util.Scanner;
import java.util.*;

/**
 * Class for show.
 */
class Show {
	/**
	 * class variable for name of the movie.
	 */
	private String movieName;
	/**
	 * time of the movie.
	 */
	private String movieTime;
	/**
	 * Seats available for the show.
	 */
	private String[] movieSeats;

	Show(final String mve, String sTime, String[] seats) {
		movieName = mve;
		movieTime = sTime;
		movieSeats = seats;
	}

	String getMovie() {
		return movieName;
	}
	String getMovieTime() {
		return movieTime;
	}
	String[] getSeats () {
		return movieSeats;
	}

	void setSeats(int index) {
		movieSeats[index] = "N/A";
	}

	public String toString() {
		return movieName + "," + movieTime;
	}
}

/**
 * Class for patron.
 */
class Patron {

	private String patName;
	private String patNumber;

	/**
	 * Constructs the object.
	 */
	Patron(String nm, String mob) {
		patName = nm;
		patNumber = mob;
	}

	String getName() {
		return patName;
	}

	String getNumber() {
		return patNumber;
	}

	public String toString() {
		return patName + " " + patNumber;
	}

}

class BookYourShow {
	ArrayList<Show> showList;
	ArrayList<String> ticketList;

	BookYourShow() {
		showList = new ArrayList<>();
		ticketList = new ArrayList<>();
	}

	void addAShow(Show shw) {
		showList.add(shw);
	}

	Show getAShow(String mve, String mvetime) {
		for (Show show : showList)
			if (show.getMovie().equals(mve) && show.getMovieTime().equals(mvetime))
				return show;
		return null;
	}

	void bookAShow(String movie, String showTime, Patron patron, String[] seats) {
		Show show = getAShow(movie, showTime);
		if (show == null) {
			System.out.println("No show");
			return;
		}
		boolean flag = false;
		String[] sseats = show.getSeats();
		for (String seat : seats) {
			for (int i = 0; i < seats.length; i++) {
				if (seat.equals(sseats[i])) {
					show.setSeats(i);
					flag = true;
				}
			}
		}
		if (flag) {
			ticketList.add(patron.getNumber() + " " + movie + " " + showTime);
		}
	}

	void printTicket(String movie, String showTime, String number) {
		String t = number + " " + movie + " " + showTime;
		boolean flag = true;
		for (String ticket : ticketList ) {
			if (t.equals(ticket)) {
				System.out.println(t);
				flag = false;
			}
		}
		if (flag) {
			System.out.println("Invalid");
		}

	}

	void showAll() {
		for (Show show : showList ) {
			System.out.println(show.toString() + "," + Arrays.toString(show.getSeats()).replace(" ", ""));
		}
	}

}

/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * main method to drive program.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		BookYourShow bys = new BookYourShow();
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < testCases; i++) {
			String[] tokens = scan.nextLine().
			                  replace("[", "").replace("]", "").split(",");
			String[] check = tokens[0].split(" ");
			switch (check[0]) {
			case "add":
				int k = 2;
				String[] seats = new String[tokens.length - 2];
				for (int j = 0; j < seats.length; j++) {
					seats[j] = tokens[k++];
				}
				bys.addAShow(new Show(check[1], tokens[1], seats));
				break;

			case "book":
				k = 2 + 2;
				seats = new String[tokens.length - 2 - 2];
				for (int j = 0; j < seats.length; j++) {
					seats[j] = tokens[k++];
				}
				bys.bookAShow(check[1], tokens[1],
				              new Patron(tokens[2], tokens[2 + 1]), seats);
				break;

			case "get":
				Show show = bys.getAShow(check[1], tokens[1]);
				if (show != null) {
					System.out.println(show);
				} else {
					System.out.println("No show");
				}
				break;

			case "print":
				bys.printTicket(check[1], tokens[1], tokens[2]);
				break;

			case "showAll":
				bys.showAll();
				break;

			default:
				break;
			}
		}
	}
}

