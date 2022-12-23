package com.baeldung.testconainers;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.DockerComposeContainer;

public class DockerComposeContainerLiveTest {
    /*@ClassRule
    public static DockerComposeContainer compose = 
      new DockerComposeContainer(
        new File("src/test/resources/test-compose.yml"))
          .withExposedService("simpleWebServer_1", 80);
    */
    @Test
    public void givenSimpleWebServerContainer_whenGetReuqest_thenReturnsResponse()
      throws Exception {
        /*
        String address = "http://" + compose.getServiceHost("simpleWebServer_1", 80)
          + ":" + compose.getServicePort("simpleWebServer_1", 80);
        */
        String address = "http://ip172-18-0-70-ceilpum0qau000do64t0-8888.direct.labs.play-with-docker.com/";
        String response = simpleGetRequest(address);
        
        assertNotNull(response);
    }

    @Test
    public void givenSimpleWebServerContainer_whenSelect_thenReturnsResponse() {

        final String url = "";

        try (Connection connection = DriverManager.getConnection(
                url, "test", "test"
        )) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private String simpleGetRequest(String address) throws Exception {
        URL url = new URL(address);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return content.toString();
    }
}
