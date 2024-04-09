package matala02;

import java.util.Iterator;

public class test {

	public static void main(String[] args) {
		int [][][] img = MyImageIO.readImageFromFile("C:/Users/barva/Desktop/Matala2/cat.jpg");
		for (int c = 0; c < img.length; c++) { // c = chanel of color
			for (int i = 0; i < img[c].length; i++) { 
				for (int j = 0; j < img[c][i].length; j++) { 
				}
			}
		}
		int [][][] img2 = new int [3][500][500];
		for (int c = 0; c < img2.length; c++) { // c = chanel of color
			for (int i = 0; i < img2[c].length; i++) { 
				for (int j = 0; j < img2[c][i].length; j++) { 
					img2 [c][i][j] = (int)(Math.random()*256);
				}
			}
		}
		MyImageIO.writeImageToFile("Random", img2);
		int [][][] cat = MyImageIO.readImageFromFile("C:/Users/barva/Desktop/Matala2/cat.jpg");

	}
}
