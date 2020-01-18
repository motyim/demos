package me.motyim.docker.pageviewclient.service;

import me.motyim.demo.docker.model.events.PageViewEvent;

public interface PageViewService {
    void sendPageViewEvent(PageViewEvent pageViewEvent);
}
