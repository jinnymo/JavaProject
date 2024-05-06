package Test1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/*
 * 배경 이미지의 각 픽셀별 rgb 값을
 * int[][] 에 전체 저장
 */
public class ImageDoubleArrayMapTest  {

	private BufferedImage image;
	private int[][] Map;
	private int x;
	private int y;
	Color MapColor;
	private final int PIXEL_COLOR_WHITE = 0;
	private final int PIXEL_COLOR_RED = 1;
	private final int PIXEL_COLOR_BLUE = 2;
	
	public int getMap(int x,int y ) {
		return Map[y][x];
	}
	
	public ImageDoubleArrayMapTest() {
		
		try {
			image= ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map = new int[600][1000];
		
		for (int i = 0; i < 600; i++) {
			for (int j = 0; j < 1000; j++) {
				
				Map[i][j]=getColor(j,i);
				//System.out.print("["+ Map[i][j]+"]");
				
			}
			//System.out.println();
			
		}
		System.out.println("성공");
		
		
		
	}
	public int getColor(int x, int y) {
		MapColor = new Color(image.getRGB(x, y));
		if (MapColor.getRed() ==255&&MapColor.getGreen() ==0&&MapColor.getBlue() ==0 ) {
			return PIXEL_COLOR_RED;//빨강
		}else if (MapColor.getRed() ==0&&MapColor.getGreen() ==0&&MapColor.getBlue() ==255 ) {
			return PIXEL_COLOR_BLUE;//파랑
		}else {
			return PIXEL_COLOR_WHITE;//흰색
		}
		
	}

	
	
	public static void main(String[] args) {
		new ImageDoubleArrayMapTest();
		
		
	}
	
}
