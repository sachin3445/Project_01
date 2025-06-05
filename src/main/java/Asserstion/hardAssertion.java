package Asserstion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class hardAssertion {
	
	@Test
	void testTitle()
	{
		String actualTitle=("Amazon");
		String expectedTitle=("Amazon");
		Assert.assertEquals(actualTitle, expectedTitle);
	}
		
}
