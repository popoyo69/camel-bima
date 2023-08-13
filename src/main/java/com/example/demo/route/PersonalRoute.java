package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class PersonalRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        from("rest:get:hello")
                .process(exchange -> {
                   String name = exchange.getIn().getHeader("name", String.class);
//                    System.out.println("HELLO " + name);
                    exchange.getIn().setBody("HELLO " + name);
                });
//                .to("file:inbox?fileName=hello.txt");
//        from("file:inbox?fileName=hello.txt")
//                .setBody(simple("HELLO"));
//                .transform().constant("Bye World");
    }
}
