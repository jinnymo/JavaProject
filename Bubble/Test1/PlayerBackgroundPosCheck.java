package Test1;

public class PlayerBackgroundPosCheck implements Runnable {
	private PlayerTest player;

	public PlayerBackgroundPosCheck(PlayerTest player) {
		this.player = player;
	}

	@Override
	public void run() {
		player.setPlayerPosition(player.getLocation());
		
	}
}
