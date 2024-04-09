package matala02;
/**
 * This is a template for assignment 2 solution of introduction to compute
 * science course. Ariel University, 2021-2022.
 * 
 * Note: All the given 3D arrays (img) below represents a RGB image where img[0] - Red channel, 
 * img[1] - Green channel, img[2] - Blue channel,
 *  which can be acquired by readImageFromFile function in the attached file (MyImageIO.java).
 * 
 */

public class Editor_Functions {
	/**
	 * 
	 * @param img - an RGB image.
	 * @return a grayscale image of (im) as a 2D array.
	 */
	public static int[][] rgb2gray(int[][][] img) {
		int [][] gray = new int [img[0].length][img[0][0].length];
		for (int i = 0; i<img[0].length; i++) {
			for (int j = 0; j<img[0][0].length; j++) {
				gray[i][j] = (int)(((0.3 * img[0][i][j])+(0.59*img[1][i][j])+(0.11*img[2][i][j])))*255;
			}
		}
		return gray;
	}


	/**
	 * 
	 * @param img     - an RGB image.
	 * @param CroppedImg 
	 * @param i_1,    j_1 - indicies of upper left pixel of the crop range.
	 * @param i_2,j_2 - indicies of lower right pixel of the crop range.
	 * @return an RGB cropped image starting from pixel (i_1, j_1) to pixel
	 *         (i_2,j_2) as 3D array.
	 */
	public static int[][][] crop(int[][][] img, int i_1, int j_1, int i_2, int j_2, int[][][] CroppedImg) {
		int [][][] crop = new int [3][(i_2 - i_1)+1][(j_2 - j_1)+1];
		for (int c = 0; c<3; c++) {
			for (int i = 0; i<(i_2 - i_1 + 1); i++) {
				for (int j = 0; j <(j_2 - j_1+ 1); j++) {
					crop [c][i][j] = CroppedImg [c][i_1 + i][j_1 + j]; 
				}
			}
		}
		return crop;
	}

	/**
	 * 
	 * @param img   - an RGB image.
	 * @param alpha - An angle we want to rotate the image with.
	 * @return a rotated image (img) by alpha degrees.
	 */
	public static int[][][] rotate_alpha(int[][][] img, double alpha) {
		int  [][][] Rotate = new int [3][img[0].length][img[0][0].length];
		double rad = Math.toRadians(alpha);
		int i_m = img[0].length/2;
		int j_m = img[0][0].length/2;
		for (int c = 0; c < 3; c++) {
			for (int i = 0; i < img[0].length; i++) {
				for (int j = 0; j < img[0][0].length; j++) {
					int i2 = (int)((Math.cos(rad) * (i - i_m) - Math.sin(rad)* (j-j_m))) + i_m;
					int j2 = (int)((Math.sin(rad) * (i - i_m) + Math.cos(rad)* (j-j_m))) + j_m;
					if (i2 >= 0 && i2< img[0].length && j2 >= 0 && j2 < img[0][0].length)
						Rotate [c][i2][j2] = img [c][i][j];
				}
			}
		}
		return Rotate;
	}
	public static int Avg(int img [][][], int c, int i, int j, int n) {
		int Avg = 0;
		int counter = 0;
		for (int x = Math.max(i-n, 0); x<Math.min(i+n, img[0].length-1); x++) {
			for (int z = Math.max(j-n, 0); z<Math.min(j+n, img[0][0].length -1); z++) {
				counter ++;
				Avg = Avg + img[c][x][z];
			}
		}
		Avg = (int)(Avg/counter);
		return Avg;
	}
	/**
	 * 
	 * @param img - an RGB image.
	 * @param n   - the sliding window length to smooth the image by.
	 * @return a smoothed RGB image.
	 */
	public static int[][][] Smooth(int[][][] img, int n) {
		int  [][][] Smooth = new int [3][img[0].length][img[0][0].length];
		double start = System.currentTimeMillis();
		for (int c = 0; c<3; c++) {
			for (int i = 0; i< img[0].length; i++) {
				for (int j = 0; j< img[0][0].length; j++) {
					Smooth [c][i][j] = Avg(img, c, i, j, n);
				}
			}
		}
		double end = System.currentTimeMillis();
		System.out.println((end - start)+ "ms");
		return Smooth;
	}

	/**
	 * 
	 * @param factor_h - height scale factor of the image.
	 * @param factor_w - width scale factor of the image.
	 * @param im       - a grayscale image to be scaled.
	 * @return a scaled up\down image by the given factors.
	 */
	public static int[][] scaleImg(double factor_h, double factor_w, int[][] im) {
		int Scale [][] = new int [(int) (im.length*factor_h)][(int) (im[0].length * factor_w )];
		for (int i = 0; i<Scale.length; i++) {
			for (int j = 0; j<Scale[0].length; j++) {
				int i_h = (int) ((i) / factor_h);
				int j_w = (int)	((j) / factor_w);
				Scale [i][j] = im [i_h][j_w];
			}
		}
		return Scale;
	}
	
}
