package org.example;

import com.codahale.metrics.annotation.Timed;
import org.example.Saying;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Path("/Nikhil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class resource {
    private String template;
    private String defaultName;
    private AtomicLong counter;
    public resource(String template,String defaultName){
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying say(@QueryParam("name") Optional<String>name){
        final String value = template + " " + name.orElse(defaultName);
        return new Saying(counter.incrementAndGet(), value);
    }

}
