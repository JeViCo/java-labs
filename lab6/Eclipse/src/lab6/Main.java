package lab6;

public class Main {

	public static void main(String[] args) {
		BouncingBallsPlane plane = new BouncingBallsPlane();
		for (int i = 0; i < 5; i++) {
			plane.add(new Ball());	
		}
		plane.show();
	}

}
