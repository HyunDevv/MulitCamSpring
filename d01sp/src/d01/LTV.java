package d01;

public class LTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LTV powerOn");
	}

	@Override
	public void powerOff() {
		System.out.println("LTV powerOff");
	}

	@Override
	public void volumeUp() {
		System.out.println("LTV volumeUp");
	}

	@Override
	public void volumeDown() {
		System.out.println("LTV volumeDown");
	}

}
