package com.example.demo;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class DemoApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private SimpleMeterRegistry meterRegistry;

	private ResponseEntity<Void> postRequest() {
		MyRequestBody postRequest = new MyRequestBody();
		postRequest.setFoo1("foo1");
		postRequest.setFoo2("foo2");
		postRequest.setFoo3("foo3");
		postRequest.setFoo4("foo4");
		postRequest.setFoo5("foo5");
		postRequest.setFoo6("foo6");
		postRequest.setFoo7("foo7");
		postRequest.setFoo8("foo8");
		postRequest.setFoo9("foo9");
		return restTemplate.postForEntity("/", postRequest, Void.class);
	}

	private ResponseEntity<Void> getRequest() {
		return restTemplate.getForEntity("/?foo1=foo1" +
				"&foo2=foo2" +
				"&foo3=foo3" +
				"&foo4=foo4" +
				"&foo5=foo5" +
				"&foo6=foo6" +
				"&foo7=foo7" +
				"&foo8=foo8" +
				"&foo9=foo9", Void.class);
	}

	@Test
	public void testBench() {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
		int period = 1;

		var cpuList = new ArrayList<Integer>();

		executorService.scheduleAtFixedRate(() -> {
			var cpu = (int) (meterRegistry.find("process.cpu.usage").gauge().value() * 100);
			cpuList.add(cpu);
			// DO NOTHING
		}, 0, 1, SECONDS);

		cpuList.clear();
		System.out.println("Running POST 30s");
		ScheduledFuture<?> futurePost = executorService.scheduleAtFixedRate(this::postRequest, 0, period, TimeUnit.MILLISECONDS);
		cancelAfter(futurePost, 30);
		printCpu(cpuList);

		cpuList.clear();
		System.out.println("Running GET 30s");
		ScheduledFuture<?> futureGet = executorService.scheduleAtFixedRate(this::getRequest, 0, period, TimeUnit.MILLISECONDS);
		cancelAfter(futureGet, 30);
		printCpu(cpuList);

		cpuList.clear();
		System.out.println("Running POST 30s");
		futurePost = executorService.scheduleAtFixedRate(this::postRequest, 0, period, TimeUnit.MILLISECONDS);
		cancelAfter(futurePost, 30);
		printCpu(cpuList);

		cpuList.clear();
		System.out.println("Running GET 30s");
		futureGet = executorService.scheduleAtFixedRate(this::getRequest, 0, period, TimeUnit.MILLISECONDS);
		cancelAfter(futureGet, 30);
		printCpu(cpuList);
	}

	private void cancelAfter(Future future, int seconds) {
		try {
			Thread.sleep(seconds * 1000);
			future.cancel(true);
		} catch (Exception e) {
			// Nothing
		}
	}

	private void printCpu(List<Integer> cpuValues) {
		try {
			System.out.println("All CPU measures: " + cpuValues);
			var average = cpuValues.stream().collect(Collectors.averagingInt(i -> i));
			System.out.println("Average CPU at: " + average + "%");
		} catch (Exception e) {
			System.out.println("Average CPU at: _%");
		}
	}
}
