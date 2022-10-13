package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
class FilmverwaltungsappOtsRestJavaSpringComApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void getFilmeByNutzer() throws IOException {
		String pathVar = "user";
		URL url = new URL("http://localhost:8080/service/rest/" + pathVar);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

//Getting the response code
		int responsecode = conn.getResponseCode();

		System.out.println(responsecode);

	}

}
