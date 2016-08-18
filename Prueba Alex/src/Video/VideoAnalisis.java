package Video;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Core;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import org.opencv.highgui.Highgui;

public class VideoAnalisis {
	
	 public static void main( String[] args ){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		   	
	   	VideoCapture camera = new VideoCapture("src//Video.MP4");
		   				
	   	if(camera.isOpened()){
	   		Mat frame = new Mat();
	   	    while(true){
	   	    	if (camera.read(frame)){
	   	    		System.out.println("Frame Capturado");
	
		            
	   	    	}
	   	    }
	   	}
	}

}
