package virtualPetsAmok;

import org.hamcrest.Matchers;
import org.junit.Assert;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RobotTest {

	@Test
	public void shouldGetOiled() {
		Robot underTest = new Robot("", "", "");
		underTest.needsOil();
		underTest.oilChange();
		boolean actual = underTest.getOilState();
		assertThat(actual, is(true));
	}

	@Test
	public void shouldNotNeedOil() {
		Robot underTest = new Robot("", "", "");
		underTest.oilChange();
		boolean actual = underTest.getOilState();
		assertThat(actual, is(true));
	}
}
