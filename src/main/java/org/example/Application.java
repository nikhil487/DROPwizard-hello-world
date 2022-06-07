package org.example;

import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.example.resource;

public class Application extends io.dropwizard.Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception{
        new Application().run(args);
    }
    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {
      resource r = new resource(configuration.getTemplate(),configuration.getDefaultName());
      environment.jersey().register(r);
    }
}