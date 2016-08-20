
import java.util.ArrayList;

import org.opencv.core.*;
import org.opencv.features2d.DMatch;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.FeatureDetector;
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
		    	    	    
		    	    	    Mat imagen = new Mat();
		    	    	    imagen = Highgui.imread("Imagen 1.jpg");

		    	    	    int contador = 0;
		    	    	    for( int j = 0; j < frame.rows() ; j++ )
		    	    	     { 
		    	    	         for( int i = 0; i < frame.cols(); i++ )
		    	    	          {
		    	    	        	 
		    	    	        	 contador += frame.row(j).col(i).nativeObj;
		    	    	          }
		    	    	         
		    	    	     }
		    	    	    
		    	    	    double[] data = null;
		    	    	    double r = 0;
		    	    	    double g = 0;
		    	    	    double b = 0;
		    	    	    		
		    	    	    for (int i = 0; i < frame.height(); i++)
		    	    	        for (int j = 0; j < frame.width(); j++) {
		    	    	            r += frame.get(i, j)[0];
		    	    	            g += frame.get(i, j)[1];
		    	    	            b += frame.get(i, j)[2];
		    	    	    }
		    	    	    
		    	    	    System.out.println(r);
		    	    	    System.out.println(g);
		    	    	    System.out.println(b);
		    	    	    
		    	            break;


		    	    	}
		    	    }	
		    	}
		    	camera.release();
		    	
			}

	}
