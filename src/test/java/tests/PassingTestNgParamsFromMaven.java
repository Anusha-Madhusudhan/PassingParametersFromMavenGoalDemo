/**
 * 
 */
package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 
 */
public class PassingTestNgParamsFromMaven {
	
	@Test
	@Parameters({"browser","URL"})
	void testPassingTestNgParamsFromMaven(String br,String url) {
		System.out.println(br);
		System.out.println(url);
	}

}
