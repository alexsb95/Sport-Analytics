package SegmentacionTemporal;

import org.opencv.core.Core;

public class Main {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		AperturaVideo video = new AperturaVideo();

		video.CapturarVideo("src//Video.MP4");

	}

}
