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
		
		//Abre el video   	
	   	VideoCapture video = new VideoCapture("src//Video.MP4");
		   				
	   	if(video.isOpened()){
	   		//La matriz donde se almacena al frame
	   		Mat matrizRGB = new Mat();
	   		
	   		//Itera los frames
	   	    while(true){
	   	    	if (video.read(matrizRGB)){
	   	    		System.out.println("Frame Capturado");
	   	    		
	   	    		//Transforma la matriz RGB a HSV
		            Mat matrizHsv = new Mat();
		            Imgproc.cvtColor(matrizRGB, matrizHsv, Imgproc.COLOR_RGB2HSV);
		            
	   	    	}
	   	    }
	   	}
	}

}
