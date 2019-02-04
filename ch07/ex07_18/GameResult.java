public class GameResult {
	private Craps.Status status;
	private int rollCount;
	
	public GameResult(Craps.Status status, int rollCount) {
		this.status = status;
		this.rollCount = rollCount;
	}
	
	public void setStatus(Craps.Status status) {
		this.status = status;
	}
	
	public void setRollCount(int rollCount) {
		this.rollCount = rollCount;
	}
	
	public Craps.Status getStatus() {
		return status;
	}
	
	public int getRollCount() {
		return rollCount;
	}
}