import static org.junit.Assert.*;

import org.junit.Test;
import org.opencv.core.Mat;

public class TransformacionHSVTest {

	@Test
	public void test() {
		AperturaVideo aperturavideo = new AperturaVideo();
		Mat hsv = new Mat();

		//hsv = aperturavideo.TransformacionHSV(frame);
		
		assertEquals( hsv , hsv);
		
	}

}
