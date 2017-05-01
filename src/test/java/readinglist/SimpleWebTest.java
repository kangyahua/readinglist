package readinglist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReadinglistApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleWebTest {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void loginRedirection() {

            RestTemplate rest = new RestTemplate();
            String response = rest.getForObject(
                    "http://localhost:{port}/", String.class, port);
            assert response.contains("<title>Login</title>");
    }
}