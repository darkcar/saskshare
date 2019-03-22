package junit.test;

import org.junit.jupiter.api.Test;

import ca.saskshare.utils.WebUtils;

public class WebUtilTest {

	@Test
	public void testAddDate() {
		WebUtils.addOneWeek();
	}
}
