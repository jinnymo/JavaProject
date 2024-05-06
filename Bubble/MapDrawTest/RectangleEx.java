package MapDrawTest;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RectangleEx extends JFrame {

	JPanel jPanel;
	
	public RectangleEx() {

		initData();
		setInitLayout();

	}

	private void initData() {
		jPanel = new JPanel();
		setContentPane(new MyPanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
	}

	private void setInitLayout() {
		setLayout(null);
		setVisible(true);
		setResizable(false);

	}

	class MyPanel extends JPanel {
		Point startP = null;
		Point showP = null;
		Point endP = null;
		Boolean flag = true;

		@Override
		public void setBounds(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			super.setBounds(0, 0, 1000, 600);
		}

		@Override
		public void setLayout(LayoutManager mgr) {
			// TODO Auto-generated method stub
			super.setLayout(null);
		}

		public MyPanel() {
			this.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					flag = true;
					startP = e.getPoint();

					Graphics g = getGraphics();

				}

				@Override
				public void mouseMoved(MouseEvent e) {

					new Thread(new Runnable() {

						@Override
						public void run() {
							while (flag) {
								System.out.println(e.getPoint());
								showP = e.getPoint();
								// System.out.println(e.getPoint());
								// g.drawRect(startP.x, startP.y, showP.x - startP.x, showP.y - startP.y);
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}

						}
					}).start();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					flag = false;
					endP = e.getPoint();
					Graphics g = getGraphics();

					g.drawRect(startP.x, startP.y, endP.x - startP.x, endP.y - startP.y);

				}

			});
		}
	}

	public static void main(String[] args) {
		new RectangleEx();
	}
}
