import static org.junit.Assert.*;


import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class TransformacionHSVTest {

	@Test
	public void test() {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		AperturaVideo aperturavideo = new AperturaVideo();
		
		Mat Frame = new Mat();
		Frame = aperturavideo.SacarFrame("src//Video.MP4");
		
		Mat HSV = new Mat();
		HSV = aperturavideo.TransformacionHSV(Frame);
	
		
	    
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
	    
	    Highgui.imwrite("Test 1.jpg", imagen);
		Highgui.imwrite("Test 2.jpg", HSV);
	    
	    int totalFramenHSV = (int)h  + (int)s  +(int)v;
	    int totalimagenHSV = (int)h2 + (int)s2 +(int)v2;

	    assertEquals( totalimagenHSV , totalFramenHSV);
	    
	}

}
