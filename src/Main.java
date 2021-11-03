import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		scanner.close();
		BowlingInputHandler bowlingInputHandler = new BowlingInputHandler(line);
		System.out.println(String.format("Given input is: %s",bowlingInputHandler.getLine()));
		bowlingInputHandler.normalizeLine();
		System.out.println(String.format("Given input is: %s",bowlingInputHandler.getLine()));
		bowlingInputHandler.convertLineToFrames();
		ArrayList<Frame> frames = bowlingInputHandler.getFrames();
		System.out.println(frames);
	}

}
