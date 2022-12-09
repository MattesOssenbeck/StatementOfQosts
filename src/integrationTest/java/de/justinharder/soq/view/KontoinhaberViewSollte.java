package de.justinharder.soq.view;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;

@QuarkusTest
@DisplayName("KontoinhaberView sollte")
class KontoinhaberViewSollte extends ViewSollte
{
	@Test
	@DisplayName("Liste aufrufen")
	void test01()
	{
		given()
			.when()
			.get(BANKVERBINDUNGEN)
			.then()
			.statusCode(Response.Status.OK.getStatusCode())
			.header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML);
	}
}
