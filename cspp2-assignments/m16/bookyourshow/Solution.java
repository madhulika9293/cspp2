/**
 * Class for show.
 */
class Show {
	/**
	 * class variable for name of the movie.
	 */
	protected String movieName;
	/**
	 * time of the movie.
	 */
	protected String movieTime;
	/**
	 * Seats available for the show.
	 */
	protected String[] movieSeats;

	protected Show() {
		movieName = "";
		movieTime = "";
		final int max = 200;
		movieSeats = new String[max];
	}
}


