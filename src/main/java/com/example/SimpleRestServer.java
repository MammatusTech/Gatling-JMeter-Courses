package com.example;

import io.advantageous.boon.core.Sys;
import io.advantageous.qbit.annotation.RequestMapping;
import io.advantageous.qbit.server.EndpointServerBuilder;
import io.advantageous.qbit.server.ServiceEndpointServer;

import java.util.Collections;
import java.util.List;

/**
 * Created by fadi on 7/1/15.
 */

@SuppressWarnings("ALL")
public class SimpleRestServer {


    public static void main(String... args) throws Exception {


        final ServiceEndpointServer serviceEndpointServer = new EndpointServerBuilder().setPort(6060)
                .build().initServices(new MyService()).startServer();

        Sys.sleep(1_000_000_000);
    }

    public static class MyService {

        /*
        curl http://localhost:6060/services/myservice/ping -H "X_USER_ID: RICK"
         */
        @RequestMapping
        public List ping() {
            return Collections.singletonList("Hello World!");
        }

        @RequestMapping
        public List puke() {

            throw new IllegalStateException("Garbage");
        }


    }
}
