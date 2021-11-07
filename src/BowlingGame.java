import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringJoiner;
import java.util.TreeSet;

public class BowlingGame {

	private static BowlingInputHandler bowlingInputHandler = new BowlingInputHandler();
	private static ScoreCalculator scoreCalculator = new ScoreCalculator();
	private static String line;
	private static ArrayList<Frame> frames = new ArrayList<>();
	private static Set<String> YES_ANSWERS = null;
	private static Set<String> NO_ANSWERS = null;
	private static Set<String> EXIT_ANSWERS = null;
	private static String CONFIRM_TEXT = "Confirm by entering one of these answers %s";
	private static String CHANGE_TEXT = "Change line by entering one of these answers %s";
	private static String EXIT_TEXT = "Terminate Programm by entering one of these answers %s";

	public static void main(String[] args) {

//		Scanner scanner = new Scanner(System.in);
//		String line = scanner.nextLine();
//		scanner.close();
//		BowlingInputHandler bowlingInputHandler = new BowlingInputHandler(line);
//		System.out.println(String.format("Given input is: %s", bowlingInputHandler.getLine()));
//		bowlingInputHandler.normalizeLine();
//		System.out.println(String.format("Given input is: %s", bowlingInputHandler.getLine()));
//		bowlingInputHandler.convertLineToFrames();
//		ArrayList<Frame> frames = bowlingInputHandler.getFrames();
//		System.out.println(frames);
//		ScoreCalculator scoreCalculator = new ScoreCalculator();
//		scoreCalculator.setFramesToCalculate(frames);
//		System.out.println(scoreCalculator.calculate());
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.run();

	}

	/**
	 * 
	 */
	private void run() {
		setUpAnswers();
		askForLine();

	}

	public static void askForLine() {
		System.out.println("Please enter a valid Bowling line to calculate the corresponding score:");
		try {
			Scanner scanner = new Scanner(System.in);
			if (scanner.hasNextLine()) {
				line = scanner.nextLine();
			}
			System.out.println(String.format(
					"Your input is: %s" + "\r\n" + "Are you sure to calcalute the score for this line?" + "\r\n",
					line));
			System.out.println(String.format(CONFIRM_TEXT, YES_ANSWERS));
			System.out.println(String.format(CHANGE_TEXT, NO_ANSWERS));
			System.out.println(String.format(EXIT_TEXT, EXIT_ANSWERS));
			String answer = scanner.nextLine();
			handleAnswer(answer, scanner);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void setUpAnswers() {
		final SortedSet<String> yesCommands = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		yesCommands.addAll(Arrays.asList("y", "yes", "si", "sure"));
		YES_ANSWERS = Collections.unmodifiableSortedSet(yesCommands);

		final SortedSet<String> noCommands = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		noCommands.addAll(Arrays.asList("n", "no", "abort"));
		NO_ANSWERS = Collections.unmodifiableSortedSet(noCommands);

		final SortedSet<String> exitCommands = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		exitCommands.addAll(Arrays.asList("exit", "quit", "q"));
		EXIT_ANSWERS = Collections.unmodifiableSortedSet(exitCommands);
	}

	public static void handleAnswer(String answer, Scanner scanner) {
		if (YES_ANSWERS.contains(answer)) {
			bowlingInputHandler.setLine(line);
			bowlingInputHandler.convertLineToFrames();
			frames = bowlingInputHandler.getFrames();
			scoreCalculator.setFramesToCalculate(frames);
			scoreCalculator.calculate();
			printResultString();
			bowlingInputHandler.setFrames(new ArrayList<>());
			askForLine();
		} else if (NO_ANSWERS.contains(answer)) {
			askForLine();
		} else if (EXIT_ANSWERS.contains(answer)) {
			scanner.close();
			System.exit(0);
		} else {
			System.out.println("No valid answer." + "\r\n" + "Please reply with one of the suggested answers.");
			String newAnswer = scanner.nextLine();
			handleAnswer(newAnswer, scanner);
		}
	}
	//struggles with lines that get early to 3-digit scores and more than 10 frames
	public static void printResultString() {
		String frameNumber = "1  2  3  4  5  6  7  8  9  10 total";
		StringJoiner helper = new StringJoiner(" ");
		int accumaltedScore = 0;
		for (int frameIndex = 0; frameIndex < 10; frameIndex++) {
			accumaltedScore += frames.get(frameIndex).getScore();
			if (accumaltedScore < 10) {
				helper.add("");
			}
			helper.add(Integer.toString(accumaltedScore));
		}

		helper.add(Integer.toString(accumaltedScore));
		System.out.println(frameNumber + "\r\n" + line + "\r\n" + helper.toString() + "\r\n");
	}

}
