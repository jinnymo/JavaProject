package Test1;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class PlayerTest extends JLabel implements Moveable {

	
	private int x;
	private int y;
	private ImageIcon playerR, playerL;
	
	private Point playerPosition;
	private Point playerPosTop;
	private Point playerPosBottom;
	private Point playerPosLeft;
	private Point playerPosRight;
	
	
	
	

	public int getX() {
		
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Point getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(Point point) {
		this.playerPosTop = new Point(point.x +25,point.y);
		this.playerPosBottom = new Point(point.x +25,point.y+50);
		this.playerPosLeft = new Point(point.x,point.y+25);
		this.playerPosRight = new Point(point.x +50,point.y+25);
	}


	// 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean spaceKey;

	private boolean leftWallCrash;
	private boolean rightWallCrash;
	private boolean blueWallCrash;

	private boolean lastStandingAreaRed;

	PlayerWay playerWay;

	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;

	public PlayerTest() {
		initData();
		setInitLayout();

	}

	private void initData() {

		playerR = new ImageIcon("img/playerR.png");
		playerL = new ImageIcon("img/playerL.png");

		// 처음 실행시 초기값 셋팅
		x = 355;
		y = 536;
		// 플레이어 가만히 멈춘 상태
		left = false;
		right = false;
		up = false;
		down = false;

		playerWay = PlayerWay.RIGHT;

		
		leftWallCrash = false;
		rightWallCrash = false;
		blueWallCrash = false;
		lastStandingAreaRed = true;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);

	}

	private void setInitLayout() {

	}

	@Override
	public void left() {
		

		new Thread(new Runnable() {

			@Override
			public void run() {
				

			}
		}).start();
	}

	@Override
	public void right() {
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				
				while(true) {
					x++;
					setLocation(x, y);
					if (blueWallCrash) {
						
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void up() {
		up = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
			
			}
		}).start();

	}

	@Override
	public void down() {
		down = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
	
				
			}
		}).start();
		down = false;
	}

}
