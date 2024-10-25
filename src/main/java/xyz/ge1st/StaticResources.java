package xyz.ge1st;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import jakarta.enterprise.event.Observes;

public class StaticResources {

    void installRoute(@Observes Router router) {

        router.route()
                .path("/compare/*")
                .handler(StaticHandler.create("compare/"));
    }
}
