package eu.deltasource.cucumber.bread;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Bread {

	@Getter
	private boolean isBaked = false;

	@SneakyThrows
	public void bakeIt() {
		TimeUnit.SECONDS.sleep(10);
		isBaked = true;
	}
}
