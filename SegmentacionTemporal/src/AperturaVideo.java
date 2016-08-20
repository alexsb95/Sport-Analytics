
import java.util.ArrayList;

import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
   
        
public class AperturaVideo {
	
			public Mat TransformacionHSV (Mat frame){
					
					Mat HSV = new Mat();				    
				    Imgproc.cvtColor(frame, HSV, Imgproc.COLOR_RGB2HSV);
					
					return HSV;
			}
	
			
			public Mat ExtracionCapaH (Mat HSV){
				
				ArrayList<Mat> listaHSV = new ArrayList <Mat>();
		        
		        Core.split(HSV, listaHSV);
		        
		        listaHSV.toString();
		        
		        Mat capaH = listaHSV.get(0); 
		        
		        System.out.println("Capa H extraida");
				
		        return capaH;
			}
			
			public Mat SacarFrame(String nombrevideo){
				
				
				VideoCapture video = new VideoCapture(nombrevideo);
				
				Mat Frame = new Mat();
				if(!video.isOpened()){
		    		System.out.println("Error");
		    	}
		    	else {
		    		
		    	    while(true){
		    	    	if (video.read(Frame)){
		    	    		return Frame;
		    	    	}
		    	    }
		    	}
				return null;
			}
			
			public void CapturarVideo(String nombrevideo){
				
				VideoCapture camera = new VideoCapture(nombrevideo);

				int numeroframe = 0;
				if(!camera.isOpened()){
		    		System.out.println("Error");
		    	}
		    	else {
		    		Mat frame = new Mat();
		    	    while(true){
		    	    	numeroframe +=1;
		    	    	if (camera.read(frame)){
		    	    		
		    	    		System.out.println("Frame: "+ numeroframe);
		    	    		System.out.println("Frame Width " + 
		    	    		frame.width() + " Height " + frame.height());
		    	    		
		    	    		Highgui.imwrite("Frame.jpg", frame);

		    	    	    /*Esta clase con este metodo hacen la transformacion del RGB a HSV
		    	    	     */
		    	    	    Mat HSV = new Mat();
		    	    	    HSV = TransformacionHSV(frame);
		    	    	    
		    	    	    Highgui.imwrite("HSV.jpg", HSV);
		    	    	    
		    	    	    //Esta clase con este metodo separa la capa de H de las demas
		    	    	    Mat capaH = new Mat();
		    	    	    capaH = ExtracionCapaH(HSV);
		    	            
		    	    	    Highgui.imwrite("capaH.jpg", capaH);
		    	    	    
		    	    	    double h = 0;
		    	    	    double s = 0;
		    	    	    double v = 0;
		    	    	    		
		    	    	    for (int i = 0; i < HSV.height(); i++)
		    	    	        for (int j = 0; j < HSV.width(); j++) {
		    	    	            h += HSV.get(i, j)[0];
		    	    	            s += HSV.get(i, j)[1];
		    	    	            v += HSV.get(i, j)[2];
		    	    	    }
		    	    	    
		    	    	    System.out.println(h);
		    	    	    System.out.println(s);
		    	    	    System.out.println(v);
		    	    	    
		    	    	    Mat imagen = new Mat();
		    	    	    imagen = Highgui.imread("HSV.jpg");
		    	    	    
		    	    	    double h2 = 0;
		    	    	    double s2 = 0;
		    	    	    double v2 = 0;
		    	    	    		
		    	    	    for (int i = 0; i < imagen.height(); i++)
		    	    	        for (int j = 0; j < imagen.width(); j++) {
		    	    	            h2 += imagen.get(i, j)[0];
		    	    	            s2 += imagen.get(i, j)[1];
		    	    	            v2 += imagen.get(i, j)[2];
		    	    	    }
		    	    	    
		    	    	    System.out.println(h2);
		    	    	    System.out.println(s2);
		    	    	    System.out.println(v2);
		    	    	    
		    	    	    int totalFramenHSV = (int)h  + (int)s  +(int)v;
		    	    	    int totalimagenHSV = (int)h2 + (int)s2 +(int)v2;
		    	    	    
		    	    	    System.out.println(totalFramenHSV);
		    	    	    System.out.println(totalimagenHSV);
		    	            break;


		    	    	}
		    	    }	
		    	}
		    	camera.release();
		    	
			}

	}
