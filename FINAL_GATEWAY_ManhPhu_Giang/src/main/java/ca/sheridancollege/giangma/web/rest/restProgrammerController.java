package ca.sheridancollege.giangma.web.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.giangma.domain.Programmer;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/programmers")
public class restProgrammerController {

    private final String REST_URL = "http://localhost:8081/api/programmers";
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping(value = {"", "/"}, headers = {"Content-type=application/json"})
    public Programmer addProgrammer(@RequestBody Programmer programmer) {
        HttpEntity<Programmer> request = new HttpEntity<>(programmer);
        return restTemplate.postForObject(REST_URL, request, Programmer.class);
    }

    @GetMapping(value = {"", "/"}, headers = {"Content-type=application/json"})
    public List<Programmer> getProgrammer() {
        ResponseEntity<Programmer[]> response = restTemplate.getForEntity(REST_URL, Programmer[].class);
        return Arrays.asList(response.getBody());
    }

    @GetMapping(value = {"/{id}"}, headers = {"Content-type=application/json"})
    public Programmer getProgrammerById(@PathVariable long id) {
        return restTemplate.getForObject(REST_URL + "/" + id, Programmer.class);
    }
}
