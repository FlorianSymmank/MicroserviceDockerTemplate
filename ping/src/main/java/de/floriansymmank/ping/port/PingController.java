package de.floriansymmank.ping.port;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "ping")
public class PingController {
    @Autowired
    PingProducer pingProducer;

    @GetMapping("ping")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String triggerPingQueue() {
        try {
            pingProducer.sendMessage("Ping");
        } catch (Exception e) {
        }

        return "OK";
    }

    @GetMapping("pang")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String yoyo() {
        return "YOYO";
    }
}
