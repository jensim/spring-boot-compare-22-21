package com.example.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

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

	@Test
	public void postRequest() {
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
		ResponseEntity<Void> postResponse = restTemplate.postForEntity("/", postRequest, Void.class);
		assertThat(postResponse.getStatusCode(), is(OK));
	}

	@Test
	public void getRequest() {
		ResponseEntity<Void> getResponse = restTemplate.getForEntity("/?foo1=foo1" +
				"&foo2=foo2" +
				"&foo3=foo3" +
				"&foo4=foo4" +
				"&foo5=foo5" +
				"&foo6=foo6" +
				"&foo7=foo7" +
				"&foo8=foo8" +
				"&foo9=foo9", Void.class);

		assertThat(getResponse.getStatusCode(), is(OK));
	}
}
