package CrazyArcade;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	MainFrame mContext = this;
	private JLabel backgroundMap;
	private Player1 player1;
	private Player1KeyListener player1KeyListener;
	
	private int[][] Map;
	Color MapColor;

	private BufferedImage mapImage;
	private String mapAdress = "IMG/background_test5_1010.png";

	private final int PIXEL_COLOR_WHITE = 0;
	private final int PIXEL_COLOR_RED = 1;
	private final int PIXEL_COLOR_BLUE = 2;

	public MainFrame() {
		// TODO Auto-generated constructor stub
		initDat();
		setInitLayout();

		addEventListener();
		// TODO Auto-generated method stub
		mapArrayAdd();
		// 백그라운드 서비스 시작

		// new Thread(new BackgroundPlayerService(player)).start();
	}

	private void initDat() {
		Icon icon = new ImageIcon("IMG/main_background.png");	
		backgroundMap= new JLabel(icon);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setContentPane(backgroundMap);
		setSize(1017, 1040);
		
		
		backgroundMap.setSize(1000,1000);
		backgroundMap.setLocation(0,0);

		player1 = new Player1(mContext);

	}

	private void setInitLayout() {
		setLayout(null);
		// setResizable(false);
		setLocationRelativeTo(null);// jframe 모니터 가운데 자동 배치
		setVisible(true);
		add(backgroundMap);
		backgroundMap.add(player1);

	}

	private void addEventListener() {
		new Thread(new Player1KeyListener(mContext, player1)).start();

	}

	private void mapArrayAdd() {
		try {
			mapImage = ImageIO.read(new File(mapAdress));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				// int x = 50 + 100 * j;
				// int y = 50 + 100 * i;
				// System.out.println(x+" "+y);
				Map[i][j] = getColor(50 + 100 * j, 50 + 100 * i);
				if (Map[i][j] == 1) {
					backgroundMap.add(new Box(mContext, i, j));

				} else if (Map[i][j] == 2) {
					backgroundMap.add(new BreakBox(mContext, i, j));
				}
				// System.out.println(j+"|||"+i);
				System.out.print("[" + Map[i][j] + "]");
			}
			System.out.println();

		}
		repaint();
	}

	public int getColor(int x, int y) {
		MapColor = new Color(mapImage.getRGB(x, y));

		if (MapColor.getRed() == 255 && MapColor.getGreen() == 0 && MapColor.getBlue() == 0) {

			return PIXEL_COLOR_RED;// 빨강
		} else if (MapColor.getRed() == 0 && MapColor.getGreen() == 0 && MapColor.getBlue() == 255) {
			return PIXEL_COLOR_BLUE;// 파랑
		} else if (MapColor.getRed() == 255 && MapColor.getGreen() == 255 && MapColor.getBlue() == 255) {
			return PIXEL_COLOR_WHITE;// 흰색
		} else {
			return 5;// 흰색

		}
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
