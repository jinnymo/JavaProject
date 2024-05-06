package MapDrawTest;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
	/*패널1*/
	static JPanel page1=new JPanel() {
		/*이미지*/
		Image background=new ImageIcon("img/backgroundMap.png").getImage();
		public void paint(Graphics g) {//그리는 함수
				g.drawImage(background, 0, 0, null);//background를 그려줌		
		}
	};
	public Main() {
		homeframe();//homeframe함수를 실행
		setpanel();//setpanel함수를 실행
		mgps();
	}
	
	/*프레임 설정*/
	public void homeframe() {
		setTitle("1");//타이틀
		setSize(400,400);//프레임의 크기
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		setLayout(null);//레이아웃 설정
		setVisible(true);//창이 보이게	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게
	}
	/*패널 관련 설정*/
	public void setpanel() {
		/*위치 설정*/
		page1.setBounds(0, 0, 400, 400);//패널1의 위치 설정
		/*레이아웃 지정*/
		page1.setLayout(null);//레이아웃 설정
		/*패널이나 프레임에 추가*/
		add(page1);//프레임에 패널을 추가
	}
	public void mgps() {
		page1.addMouseMotionListener(new MouseAdapter() { // 마우스 이벤트 
			@Override 
			public void mouseMoved(MouseEvent e) { // 마우스 움직일때. 
				System.out.println(e.getX()+" "+e.getY());//x좌표,y좌표 출력
			} 
		});
	}
	/*메인함수*/
	public static void main(String[] args){
		new Main(); //실행하면 생성자가 실행됨.
	}
}