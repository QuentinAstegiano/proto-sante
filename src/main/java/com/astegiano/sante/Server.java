package com.astegiano.sante;

import ratpack.server.RatpackServer;

/**
 * Created by Quentin on 24/04/2016.
 */
public class Server {

    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .handlers(chain -> chain
                        .get(ctx -> ctx.render("Hello World!"))
                        .get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name") + "!"))
                )
        );
    }
}
