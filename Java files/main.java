package matala02;

public class main {

	public static void main(String[] args) {
			int [][][] img = MyImageIO.readImageFromFile("cat.jpg");
			int [][][] img2 = MyImageIO.readImageFromFile("butterfly.jpg");
			int [][] grayCat = Editor_Functions.rgb2gray(img);
			int [][] grayButterfly = Editor_Functions.rgb2gray(img2);
		    MyImageIO.writeImageToFile("grayCat", Editor_Functions.rgb2gray(img));
			MyImageIO.writeImageToFile("CroppedButterfly", Editor_Functions.crop(img2, 30, 600, 2303, 2303, img2));
			MyImageIO.writeImageToFile("SmoothButterfly", Editor_Functions.Smooth(img2, 1));
			MyImageIO.writeImageToFile("RotatedCat", Editor_Functions.rotate_alpha(img, 90));
			MyImageIO.writeImageToFile("ScaledCat", Editor_Functions.scaleImg(-1, -3, grayCat));
			
		}
	}

