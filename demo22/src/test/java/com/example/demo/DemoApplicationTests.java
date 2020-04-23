package com.example.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class DemoApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	private final String postBody = "{ \"foo01\": \"foo1\", " +
			"\"foo02\": \"ASC\", " +
			"\"foo03\": 3, " +
			"\"foo05\": 5.2, " +
			"\"foo06\": 6, " +
			"\"foo07\": \"DES\", " +
			"\"foo08\": 8, " +
			"\"foo09\": \"null\", " +
			"\"foo11\": [\"VER\",\"HOR\",\"FAR\"] " +
			"}";
	private final String getUri = "/?foo01=foo1&foo02=ASC&foo03=3&foo05=5.2&foo06=6&foo07=DES&foo08=8&foo09=null" +
			"&foo11=VER,HOR,FAR";
	private RequestEntity<String> postEntity;
	private final List<Integer> cpuList = new ArrayList<Integer>();

	@BeforeEach
	public void setUp() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE);
		postEntity = new RequestEntity<String>(postBody, headers, HttpMethod.POST, URI.create("/"), Void.TYPE);
	}

	@Test
	public void testGet() {
		ResponseEntity<Void> request = restTemplate.getForEntity(getUri, Void.class);
		assertThat(request.getStatusCode(), is(OK));
	}

	@Test
	public void testPost() {
		ResponseEntity<Void> request = restTemplate.exchange(postEntity, Void.class);
		assertThat(request.getStatusCode(), is(OK));
	}
}
