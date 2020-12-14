package d01;

public class STV implements TV {

	@Override
	public void powerOn() {
		System.out.println("STV powerOn");
	}

	@Override
	public void powerOff() {
		System.out.println("STV powerOff");
	}

	@Override
	public void volumeUp() {
		System.out.println("STV volumeUp");
	}

	@Override
	public void volumeDown() {
		System.out.println("STV volumeDown");
	}

}
