package CrazyArcade;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player1KeyListener implements Runnable {

	MainFrame mContext;
	Player1 player1;

	public Player1KeyListener(MainFrame mContext, Player1 player1) {
		this.mContext = mContext;
		this.player1 = player1;

	}

	@Override
	public void run() {
		mContext.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getKeyCode());

				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					// 왼쪽 누르고 있다면
					// key 이벤트가 계속 <-<-<-<-
					if (!player1.isLeft() && !player1.isLeftWallCrash()) {
						player1.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player1.isRight() && !player1.isRightWallCrash()) {
						player1.right();
					}
					break;
				case KeyEvent.VK_UP:
					if (!player1.isUp()) {
						player1.up();
					}

					break;
				case KeyEvent.VK_DOWN:
					if (!player1.isDown()) {
						player1.down();
					}
					break;
				case KeyEvent.VK_SPACE:

					break;
				default:
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					player1.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player1.setRight(false);
					break;
				case KeyEvent.VK_UP:
					player1.setUp(false);
					break;
				case KeyEvent.VK_DOWN:
					player1.setDown(false);
					break;
				default:
					break;
				}
			}

		});

	}

}
