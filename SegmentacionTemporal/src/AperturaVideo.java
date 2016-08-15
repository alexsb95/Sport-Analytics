




import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
   
        
public class AperturaVideo {
	
	
		public static void main(String[] args) {
			
			
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
			
			    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			    	
			    	VideoCapture camera = new VideoCapture("src//Video.MP4");
			    	
			    	if(!camera.isOpened()){
			    		System.out.println("Error");
			    	}
			    	else {
			    		Mat frame = new Mat();
			    	    while(true){
			    	    	if (camera.read(frame)){
			    	    		System.out.println("Frame Obtained");
			    	    		System.out.println("Captured Frame Width " + 
			    	    		frame.width() + " Height " + frame.height());
			    	    		Highgui.imwrite("camera.jpg", frame);
			    	    		System.out.println("OK");

			    	    	}
			    	    }	
			    	}
			    	camera.release();
			    }
		
	}
