package eu.deltasource.cucumber.bread;

import ch.qos.logback.core.util.ExecutorServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Slf4j
@Component
public class Bakery {

	private final ScheduledExecutorService executorService = Executors
		.newSingleThreadScheduledExecutor();

	public void bake(Bread bread) {
		executorService.submit(() -> bakeAsynchronously(bread));
	}

	private void bakeAsynchronously(Bread bread) {
		log.info("Baking bread...");
		bread.bakeIt();
		log.info("Bread is baked!");
	}
}
