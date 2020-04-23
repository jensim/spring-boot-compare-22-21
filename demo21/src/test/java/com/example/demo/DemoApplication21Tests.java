package com.example.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class DemoApplication21Tests {

	@Autowired
	private TestRestTemplate restTemplate;
	//language=TEXT
	private final String getUri = "/" +
			"?foo01=foo1" +
			"&foo02=ASC" +
			"&foo03=3" +
			"&foo05=5.2" +
			"&foo06=6" +
			"&foo07=DES" +
			"&foo08=8" +
			"&foo09=null" +
			"&foo11=VER,HOR,FAR" +
			"&foo12=ASC" +
			"&foo13=3" +
			"&foo15=5.2" +
			"&foo16=6" +
			"&foo17=DES" +
			"&foo18=8" +
			"&foo19=null" +
			"&foo21=VER,HOR,FAR,ASC,DES,NEA,VER,VER,HOR";
	private RequestEntity<String> postEntity;
	private final List<Integer> cpuList = new ArrayList<Integer>();

	@Test
	public void testGet() {
		ResponseEntity<Void> request = restTemplate.getForEntity(getUri, Void.class);
		assertThat(request.getStatusCode(), is(OK));
	}

	@Test
	public void testGetRequired() {
		ResponseEntity<Void> request = restTemplate.getForEntity("/?foo01=foo01", Void.class);
		assertThat(request.getStatusCode(), is(BAD_REQUEST));
	}

	@Test
	public void testGetWithDefaults() {
		ResponseEntity<Void> request = restTemplate.getForEntity("/defaults/", Void.class);
		assertThat(request.getStatusCode(), is(OK));
	}
}
