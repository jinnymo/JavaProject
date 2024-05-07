package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import bubble.test.ex10.BackgroundPlayerService;



public class MainFrame extends JFrame{
	
	private JLabel backgroundMap;
	
	public MainFrame() {
		// TODO Auto-generated constructor stub
		initDat();
		setInitLayout();
		addEventListener();

		// 백그라운드 서비스 시작

		new Thread(new BackgroundPlayerService(player)).start();
	}

	private void initDat() {
		backgroundMap = new JLabel(new ImageIcon("IMG/background_test1_1010.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(1000, 1000);
	}

	private void setInitLayout() {
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);// jframe 모니터 가운데 자동 배치
		setVisible(true);		
		
	}

	private void addEventListener() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
