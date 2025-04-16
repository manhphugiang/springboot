package ca.sheridancollege.giangma.web.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.giangma.domain.Shirt;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/shirts")
public class restShirtController {

    private final String REST_URL = "http://localhost:8082/api/shirts";
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping(value = {"", "/"}, headers = {"Content-type=application/json"})
    public Shirt addShirt(@RequestBody Shirt shirt) {
        HttpEntity<Shirt> request = new HttpEntity<>(shirt);
        return restTemplate.postForObject(REST_URL, request, Shirt.class);
    }

    @GetMapping(value = {"", "/"}, headers = {"Content-type=application/json"})
    public List<Shirt> getShirt() {
        ResponseEntity<Shirt[]> response = restTemplate.getForEntity(REST_URL, Shirt[].class);
        return Arrays.asList(response.getBody());
    }

    @GetMapping(value = {"/{id}"}, headers = {"Content-type=application/json"})
    public Shirt getShirtById(@PathVariable long id) {
        return restTemplate.getForObject(REST_URL + "/" + id, Shirt.class);
    }

    @PostMapping(value = {"/edit/{id}"}, headers = {"Content-type=application/json"})
    public Shirt editShirt(@RequestBody Shirt shirt, @PathVariable long id) {
        HttpEntity<Shirt> request = new HttpEntity<>(shirt);
        return restTemplate.postForObject(REST_URL + "/edit/" + id, request, Shirt.class);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        restTemplate.delete(REST_URL + "/" + id);
    }
}
