package de.floriansymmank.apigateway;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:300")
@RestController()
public class ApiController {

    private int n = 0;
    @GetMapping("/increment")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody int getN() {
        System.out.println("Someone asked me on ok");
        return ++n;
    }
}
