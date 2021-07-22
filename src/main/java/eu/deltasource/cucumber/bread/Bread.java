package eu.deltasource.cucumber.bread;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Bread {

	@Getter
	private boolean isBaked = false;

	@SneakyThrows
	public void bakeIt() {
		TimeUnit.SECONDS.sleep(10);
		isBaked = true;
	}

	@SneakyThrows
	public void bakeIt(int duration) {
		TimeUnit.SECONDS.sleep(duration);
		if(duration >= 10) {
			log.info("bread has baked completely");
			isBaked = true;
		} else {
			log.warn("bread is not baked yet!");
		}
	}
}
