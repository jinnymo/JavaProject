package teamfight_ver1;

public class Archor {

	
	int health;
	int attackPower;
	boolean isDie;

	public static int count = 0;

	
	public Archor(int he, int at) {
		health = he;
		attackPower = at;
		count++;
		this.isDie = false; 
	} 
	
	public void archorGA(String name, int ap, int a, int b) {//GetAttak ,//attak power
		health -= ap;
		System.out.println(a + "," + b + " 아처가 " + name + "에게" + ap + "데미지를 입었습니다.");
		System.out.println("아처 남은 체력 : " + health);
		if (health <= 0) {
			System.out.println("---------------------------");
			
			System.out.println(a + "," + b + " 아처가 " + name + "에게 죽음");
			System.out.println("---------------------------");
			
			this.isDie = true;// hp 0이하는 죽음으로 처리
			count--;// 생존자 수 -1
			Battlefiled.field[a+2][b] = "[🆇]";//죽은 객체 ㅁ->x로 표현 
			Battlefiled.showField();
			Battlefiled.field[a+2][b] = "[x]";//죽은 객체 ㅁ->x로 표현 
			//System.out.println(count);  //현재 살아있는 객체수
		}
	}
	public boolean getIsDie() {
		return this.isDie;
	}
	public int getArchorCount() {
		return Archor.count;
	}
	
}
