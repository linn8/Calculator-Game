import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	int score = 0;
	int answer;
	Equation equation;
	do {
	    equation = new Equation(rand);
	    answer = sc.nextInt();
	    if (answer != -1) {
		if (answer == equation.solution()) {
		    score++;
		    System.out.println("Correct answer.");
		} else {
		    System.out.println("WRong number, the correct number being " + equation.solution());
		    score--;
		    System.out.println("Enter -1 to quit");
		}
	    }
	} while(answer != -1);
	System.out.println("YOU Scored " + score + "!");
    }

}
