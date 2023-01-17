import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author wolfu
 *
 */
class RadioTest {

	@Test
	void test_isOn() {
		Radio miRadio = new Radio();
		boolean resultado = miRadio.isOn();
		assertEquals(false, resultado);
	}
	@Test
	void test_getFreq() {
		Radio miRadio = new Radio();
		String resultado = miRadio.getFrequence();
		assertEquals("AM", resultado);
	}
	@Test
	void test_getAMStation() {
		Radio miRadio = new Radio();
		int resultado = miRadio.getAMActualStation();
		assertEquals(530, resultado);
	}

}
