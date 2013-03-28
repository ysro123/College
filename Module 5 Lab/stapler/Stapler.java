package stapler;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @author Arthur Laks
 * CSIT 210 - Have You Seen My Stapler()
 * Overview: A class that represents a stapler and keeps track of its position, and the color of the staples.
 * Input: none
 * Output: none
 * Plan: none
 * Variables: double longitude, latitude; Color staple
 * @version: 1.0 2013/03/26
 */
public class Stapler {

/**
 * @author Arthur Laks
 * CSIT 210 - Have you seen my Stapler()
 * Overview: Contains the colors of the staples.
 * input: none.
 * Output: None.
 * Variables: None.
 * Plan: None.
 * @version 1.0 2013/03/26
 */
public enum Color {
	WHITE, BLACK, RED, BLUE, YELLOW
}

	/**
	 * The color the the staples
	 */
	private Color staple; // 3.a
	/**
	 * The position of the stapler
	 */
	private double longitude, latitude; // 3.a

	/**
	 * Initializes a stapler with staples of the specified color in the
	 * specified position.
	 * 
	 * @param staple
	 *            the color of the staples
	 * @param latitude
	 *            the latitude of the stapler
	 * @param longitude
	 *            the longitude of the stapler
	 */
	public Stapler(Color staple, double latitude, double longitude) {	//3.d
		this.staple = staple;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	/**
	 * Constructs a black stapler at with the latitude and longitude of 0.
	 */
	public Stapler() {	//3.d
		staple = Color.BLACK;
		latitude = longitude = 0;
	}

	
	/**
	 * @return the color of the staples
	 */
	public Color getStaple() { // 3.c.i
		return staple;
	}

	/**
	 * @param staple
	 *            the Color that the staples should have
	 */
	public void setStaple(Color staple) { // 3.c.ii
		this.staple = staple;
	}

	/**
	 * @return the longitude of the stapler
	 */
	public double getLongitude() {	//3.a
		return longitude;
	}

	/**
	 * @return the latitude of the stapler
	 */
	public double getLatitude() {	//3.a
		return latitude;
	}

	/**
	 * Moves the stapler to the specified position
	 * 
	 * @param latitude
	 *            the latitude of the position of the stapler.
	 * @param longitude
	 *            the longitude of the position of the stapler.
	 */
	public void move(double latitude, double longitude) { // 3.b, 3.c.iii, 3.c.iv
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Moves the stapler to a random location.
	 */
	public void move() { // 3.b,3.c.iii,3.c.iv
		move(randomLatitude(), randomLongitude());
	}
/**
 * Finds a random latitude between -90 and 90.
 * @return
 */
	private static double randomLatitude() {	//3.c.v
		return ThreadLocalRandom.current().nextDouble(-90, 90);
	}
/**
 * Finds a random longitude between -180 and 180.
 * @return
 */
	private static double randomLongitude() {	//3.c.v
		return ThreadLocalRandom.current().nextDouble(-180, 180);
	}

}
