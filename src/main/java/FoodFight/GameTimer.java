package FoodFight;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

// Reece Bell did this.

public class GameTimer implements Runnable {

	public static String finalGT = "00:00:00";

	private static volatile boolean exit = false;
	private static boolean paused = true;      // starts paused until startTimer() is called
	private static long banked = 0;            // ms counted before the current stretch
	private static long lastResume = 0;        // when the current stretch began

	public void run() {

		DateFormat df = new SimpleDateFormat("mm:ss:SS");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));   // no more 16-hour offset hack

		while(!exit) {
			if(!isPaused()) {
				finalGT = df.format(getElapsed());
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// begins counting from zero (call once, when the game first starts)
	public static synchronized void startTimer() {
		banked = 0;
		lastResume = System.currentTimeMillis();
		paused = false;
	}

	// freezes the clock
	public static synchronized void pause() {
		if(!paused) {
			banked += System.currentTimeMillis() - lastResume;
			paused = true;
		}
	}

	// continues from where it was frozen
	public static synchronized void resume() {
		if(paused) {
			lastResume = System.currentTimeMillis();
			paused = false;
		}
	}

	// total elapsed ms, not counting paused time
	public static synchronized long getElapsed() {
		if(paused) return banked;
		return banked + (System.currentTimeMillis() - lastResume);
	}

	public static synchronized boolean isPaused() {
		return paused;
	}

	// ends the timer thread for good (e.g. when quitting)
	public static void stop() {
		pause();
		exit = true;
	}
}

