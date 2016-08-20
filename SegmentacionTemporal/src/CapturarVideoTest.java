import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class CapturarVideoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		AperturaVideo aperturavideo = new AperturaVideo();
		
		aperturavideo.CapturarVideo("src//Video.MP4");
		
		Mat frameSacado = new Mat();
		frameSacado = Highgui.imread("Frame.jpg");
		
		double r = 0;
	    double g = 0;
	    double b = 0;
	    		
	    for (int i = 0; i < frameSacado.height(); i++)
	        for (int j = 0; j < frameSacado.width(); j++) {
	            r += frameSacado.get(i, j)[0];
	            g += frameSacado.get(i, j)[1];
	            b += frameSacado.get(i, j)[2];
	    }
	    
	    System.out.println(r);
	    System.out.println(g);
	    System.out.println(b);
	    
	    Mat frameLeido = new Mat();
	    frameLeido = Highgui.imread("1 Frame.jpg");
	    
	    double r2 = 0;
	    double g2 = 0;
	    double b2 = 0;
	    		
	    for (int i = 0; i < frameLeido.height(); i++)
	        for (int j = 0; j < frameLeido.width(); j++) {
	            r2 += frameLeido.get(i, j)[0];
	            g2 += frameLeido.get(i, j)[1];
	            b2 += frameLeido.get(i, j)[2];
	    }
	    
	    System.out.println(r2);
	    System.out.println(g2);
	    System.out.println(b2);

	    Highgui.imwrite("Test 3.jpg", frameSacado);
		Highgui.imwrite("Test 4.jpg", frameLeido);
	    
	    int totalFramenHSV = (int)r  + (int)g  +(int)b;
	    int totalimagenHSV = (int)r2 + (int)g2 +(int)b2;

	    assertEquals( totalimagenHSV , totalFramenHSV);
	    
	}

}
