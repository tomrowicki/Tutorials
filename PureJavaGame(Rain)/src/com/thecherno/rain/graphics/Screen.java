package com.thecherno.rain.graphics;

public class Screen {

	private int width, height;
	public int[] pixels;

	int time = 0;
	int xTime = 0;
	int yTime = 0;
	int counter = 0;

	public Screen(int width, int height) {

		this.width = width;
		this.height = height;
		pixels = new int[width * height]; // creating one integer value for each
											// screen pixel, equals 50400
	}

	public void clear() {

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void render() {

		counter++;
		if (counter % 100 == 0) {
			xTime++;
		}
		if (counter % 80 == 0){
			yTime++;
		}
		for (int y = 0; y < height; y++) {
			if (yTime < 0 || yTime >= height) break; // stops rendering once the indexed pixel reaches the screen border
			for (int x = 0; x < width; x++) {
				if (xTime < 0 || xTime >= width) break;
				pixels[xTime + yTime * width] = 0xff00ff; // the current pixel's
									// index is inside the
														// brackets
				// 20 + (30 * 100) - column 20, row 30, 100 columns in all
			}
		}
	}
}
