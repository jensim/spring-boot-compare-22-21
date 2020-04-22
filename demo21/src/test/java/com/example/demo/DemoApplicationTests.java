package com.example.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

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
	private final MyRequestBody postRequest = new MyRequestBody("foo1", "foo2", "foo3", "foo4", "foo5", "foo6", "foo7", "foo8", "foo9");
	private final String postUri = "/";
	private final String getUri = "/?foo1=foo1&foo2=foo2&foo3=foo3&foo4=foo4&foo5=foo5&foo6=foo6&foo7=foo7&foo8=foo8&foo9=foo9";
	private final List<Integer> cpuList = new ArrayList<Integer>();

	private ResponseEntity<Void> postRequest() {
		return restTemplate.postForEntity(postUri, postRequest, Void.class);
	}

	private ResponseEntity<Void> getRequest() {
		return restTemplate.getForEntity(getUri, Void.class);
	}

	@Test
	void testGet() {
		ResponseEntity<Void> request = getRequest();
		assertThat(request.getStatusCode(), is(OK));
	}

	@Test
	void testPost() {
		ResponseEntity<Void> request = postRequest();
		assertThat(request.getStatusCode(), is(OK));
	}

	@Test
	public void testBench() {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
		int period = 1;

		System.out.println("Running POST 30s");
		ScheduledFuture<?> futurePost = executorService.scheduleAtFixedRate(this::postRequest, 0, period, TimeUnit.MILLISECONDS);
		cancelAfter(futurePost, 30);

		System.out.println("Running GET 30s");
		ScheduledFuture<?> futureGet = executorService.scheduleAtFixedRate(this::getRequest, 0, period, TimeUnit.MILLISECONDS);
		cancelAfter(futureGet, 30);

		System.out.println("Running POST 30s");
		futurePost = executorService.scheduleAtFixedRate(this::postRequest, 0, period, TimeUnit.MILLISECONDS);
		cancelAfter(futurePost, 30);

		System.out.println("Running GET 30s");
		futureGet = executorService.scheduleAtFixedRate(this::getRequest, 0, period, TimeUnit.MILLISECONDS);
		cancelAfter(futureGet, 30);
	}

	private void cancelAfter(Future future, int seconds) {
		try {
			for (int i = 0; i < seconds; i++) {
				var cpu = (int) (meterRegistry.find("process.cpu.usage").gauge().value() * 100);
				cpuList.add(cpu);
			}
			Thread.sleep(seconds * 1000);
			future.cancel(true);
			printCpu();
			cpuList.clear();
		} catch (Exception e) {
			// Nothing
		}
	}

	private void printCpu() {
		try {
			System.out.println("All CPU measures: " + cpuList);
			var average = cpuList.stream().collect(Collectors.averagingInt(i -> i));
			System.out.println("Average CPU at: " + average + "%");
		} catch (Exception e) {
			System.out.println("Average CPU at: _%");
		}
	}
}
