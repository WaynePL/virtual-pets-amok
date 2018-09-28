package virtualPetsAmok;

import org.hamcrest.Matchers;
import org.junit.Assert;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RobotTest {

	@Test
	public void shouldDecreaseOil() {
		Robot underTest = new Robot("", "");
		underTest.decreaseOil();
		int actual = underTest.getOilLevel();
		assertThat(actual, is(80));
	}

	@Test
	public void shouldGetOiled() {
		Robot underTest = new Robot("", "");
		underTest.decreaseOil();
		underTest.fillOil();
		int actual = underTest.getOilLevel();
		assertThat(actual, is(100));
	}

}
