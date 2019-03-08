public class TrafficLightTest {
	public static void main(String[] args) {
		for(TrafficLight trafficLight : TrafficLight.values()) {
			System.out.printf("%s has a duration of %d secs%n", trafficLight, trafficLight.getDuration());
		}
	}
}

enum TrafficLight {
	RED(120),
	GREEN(60),
	YELLOW(3);
	
	// instance variables
	private int duration;
	
	TrafficLight(int duration) {
		if(duration <= 0) {
			throw new IllegalArgumentException("duration " + duration +
					"cannot be negative");
		}
		this.duration = duration;
	}
	
	// LESSON LEARNED: This implementation would give a stack overflow error!
	// The reason is that %s format specifier invokes implicitly toString() method again
	/*
	public String toString() {
		return String.format("%s has a duration of %d secs", this, duration);
	}*/
	
	public int getDuration() {
		return duration;
	}
}