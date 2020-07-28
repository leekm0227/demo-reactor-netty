package com.example.demo;

import com.example.demo.handler.AbstractHandler;
import com.example.demo.model.RequestBean;
import com.example.demo.publisher.ChatPublisher;
import com.example.demo.publisher.FieldPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Component
public class Dispatcher {

    private static final Logger logger = LoggerFactory.getLogger(Dispatcher.class);

    @Autowired
    ChatPublisher chatPublisher;

    @Autowired
    FieldPublisher fieldPublisher;

    private HashMap<Byte, AbstractHandler<?>> handlers;

    @PostConstruct
    public void init() {
        handlers = new HashMap<>();
    }

    public void register(byte bodyType, AbstractHandler<?> handler) {
        handlers.put(bodyType, handler);
    }

    Flux<byte[]> handle(RequestBean req) {
        AbstractHandler<?> handler = handlers.get(req.getMessage().payloadType());
        return Flux.just(handler == null ? new byte[0] : handler.handle(req))
                .mergeWith(chatPublisher.subscribe(req.getSid()))
                .mergeWith(fieldPublisher.subscribe());
    }
}
