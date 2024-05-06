package MapDrawTest;

import java.awt.Graphics;
import java.awt.Paint;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Pageable;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RectJpanEx extends JFrame {

	static JPanel jPanel = new JPanel();
	Point startP = null;
	Point showP = null;
	Point endP = null;
	boolean flag = false;

	public RectJpanEx() {
		initData();
		setInitLayout();
		DrawEvent();

	}

	private void initData() {
		setTitle("test1");
		setSize(1000, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);

	}

	private void setInitLayout() {
		jPanel.setBounds(0, 0, 1000, 600);
		jPanel.setLayout(null);
		add(jPanel);

	}
	@Override
	public void paint(Graphics g) {
		
		if (showP != null) {
			g.fillRect(startP.x, startP.y, showP.x - startP.x, showP.y - startP.y);
		}
		
	}
	
	public void DrawEvent() {
		System.out.println("mousePressed");
		Graphics g = getGraphics();

		// 마우스 드래그 -> 다른 스레드로 구동
		// pressed 와 dragged => 같은 스레드레서 동작불가
		new Thread(new Runnable() {

			@Override
			public void run() {
				

					jPanel.addMouseMotionListener(new MouseAdapter() {

						@Override
						public void mouseDragged(MouseEvent e) {
							showP = e.getPoint();
							System.out.println("mouseDragged");

							repaint();
							//g.fillRect(startP.x, startP.y, showP.x - startP.x, showP.y - startP.y);
							
							
							try {
								Thread.sleep(5);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					});

				
			}
		}).start();

		jPanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				flag = true;
				startP = e.getPoint();
				System.out.println("mousePressed");

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				flag = false;
				System.out.println("mouseReleased");
				endP = e.getPoint();
				g.drawRect(startP.x, startP.y, endP.x - startP.x, endP.y - startP.y);
			}
		});

	}

	public static void main(String[] args) {
		new RectJpanEx();
	}
}
