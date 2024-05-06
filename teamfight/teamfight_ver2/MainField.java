package teamfight_ver2;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainField extends JComponent{
	
	private JLabel background;
	private JLabel archors, warriors;
	private JFrame jFrame;
	
	private final int MAIN_WIDTH = 800;
	private final int MAIN_HEIGHT = 500;
	
	
	public MainField() {
		initData();
		setInitLayout();
		addEventListener();
		
	}
	
	public void initData(){
		jFrame = new JFrame();
		jFrame.setTitle("TeamFight Ver2");
		setSize(MAIN_WIDTH,MAIN_HEIGHT);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Icon archorIcon = new ImageIcon("images/archor.png");
		Icon warriorIcon = new ImageIcon("images/warrior.jpeg");
		
		
		archors = new JLabel(archorIcon);
		//warriors = new JLabel(warriorIcon);
	
		archors.setSize(50,50);
		archors.setLocation(100, 100);
	
	}
	
	public void setInitLayout() {
		setLayout(null);
		add(archors);
		setVisible(true);
	}
	
	public void addEventListener() {
		
	}
	
	public static void main(String[] args) {
		new MainField();
	}
}
