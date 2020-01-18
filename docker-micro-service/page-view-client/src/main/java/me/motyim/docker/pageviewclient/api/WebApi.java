package me.motyim.docker.pageviewclient.api;

import me.motyim.demo.docker.model.events.PageViewEvent;
import me.motyim.docker.pageviewclient.service.PageViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@RestController
public class WebApi {

    PageViewService service;

    @Autowired
    public WebApi(PageViewService service) {
        this.service = service;
    }

    @GetMapping("/api/print/{message}")
    public ResponseEntity<String> print(@PathVariable String message){

        PageViewEvent  event = new PageViewEvent();
        event.setTime(new Date());
        event.setPageUrl("/api/print/"+message);
        event.setCorrelationId(UUID.randomUUID().toString());

        service.sendPageViewEvent(event);

        return ResponseEntity.ok(message);
    }
}
