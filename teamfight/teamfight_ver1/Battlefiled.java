package teamfight_ver1;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Battlefiled {

	static String[][] field = new String[4][10];

	public static void main(String[] args) {

		Random random = new Random();
		int posA;
		int posB;
		boolean flag1;// 전사 사망확인
		boolean flag2;// 아처 사망 확인

		Warrior[][] warrior = new Warrior[2][10]; // 2*10 총 20개의 Warrior 를 메모리 stack 공간에 미리 생성함
		Archor[][] archor = new Archor[2][10];

		creatField();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 2; j++) {

				//System.out.println(warrior[i]);
				warrior[j][i] = new Warrior(100, 10);// 위에서 미리선언한 Warrior의 값을 할당 시킴
				archor[j][i] = new Archor(100, 10);

			}

		}

		
		while(true) {
			check();
			flag1 = true;
			while (flag1) {
				posA = random.nextInt(2);
				posB = random.nextInt(10);
				flag1 = !(warrior[posA][posB].getIsDie());// 살아있는 여부 가져와서 저장
				if (flag1 == true) {
					warrior[posA][posB].warriorGA("아처", 10, posA, posB);
					System.out.println(warrior[0][0].getWarriorCount());
					break;
				}
				// System.out.println(posA +"a"+ posB );
			}
			check();
			flag2 = true;
			while (flag2) {
				posA = random.nextInt(2);
				posB = random.nextInt(10);
				flag2 = !(archor[posA][posB].getIsDie());// 살아있는 여부 가져와서 저장
				if (flag2 == true) {
					archor[posA][posB].archorGA("전사", 10, posA, posB);
					break;
				}
				// System.out.println(posA +"a"+ posB );
			}
		
		}
		
		
		
	}
	static void check() {
		int a = Warrior.count;
		int b = Archor.count;
		if(a == 0) {
			System.out.println("| 아처 승리 |  아처 생존자 수 : " +b);
			System.exit(0);
			
		}else if(b ==0) {
			System.out.println("| 전사 승리 |  전사 생존자 수 : " +a);
			System.exit(0);
			
		}
		
	}

	static void creatField() {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 2; j++) {

				field[j][i] = new String("[o]");
				System.out.print(field[j][i]);

			}
			System.out.print("\t\t");
			for (int j = 0; j < 2; j++) {

				field[j + 2][i] = new String("[ㅁ]");
				System.out.print(field[j + 2][i]);

			}

			System.out.println();
		}
	}

	static void showField() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 2; j++) {

				System.out.print(field[j][i]);

			}
			System.out.print("\t\t");
			for (int j = 0; j < 2; j++) {

				System.out.print(field[j + 2][i]);

			}

			System.out.println();
		}
	}

}
