package eu.deltasource.cucumber.bread;

import ch.qos.logback.core.util.ExecutorServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Component
public class Bakery {

	private AtomicBoolean isDirty = new AtomicBoolean(false);

	private final ScheduledExecutorService executorService = Executors
		.newSingleThreadScheduledExecutor();

	public void bake(Bread bread) {
		executorService.submit(() -> bakeAsynchronously(bread));
	}

	public void bake(Bread bread, int duration) {
		executorService.submit(() -> bakeAsynchronously(bread, duration));
	}

	private void bakeAsynchronously(Bread bread) {
		if(isDirty.get()) {
			throw new RuntimeException("Bakery is dirty!");
		}
		log.info("Baking bread...");
		bread.bakeIt();
		log.info("Bread is baked!");
		isDirty.set(true);
	}

	private void bakeAsynchronously(Bread bread, int duration) {
		if(isDirty.get()) {
			throw new RuntimeException("Bakery is dirty!");
		}
		log.info("Baking bread...");
		bread.bakeIt(duration);
		log.info("Bread is baked!");
		isDirty.set(true);
	}

	public void cleanBakery() {
		log.info("cleaning bakery");
		isDirty.set(false);
	}
}
