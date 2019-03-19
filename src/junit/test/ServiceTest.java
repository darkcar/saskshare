package junit.test;

import org.junit.jupiter.api.Test;

import ca.saskshare.utils.ServiceUtils;

public class ServiceTest {
	
	// Test md5
	@Test
	public void testMd5() {
		System.out.println(ServiceUtils.md5("ganggang123"));
	}
}
