package com.astegiano.sante;

import com.astegiano.sante.web.pages.content.ContentHandler;
import com.astegiano.sante.web.pages.home.HomeHandler;
import ratpack.guice.Guice;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;

/**
 * Created by Quentin on 24/04/2016.
 */
public class Server {

    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .serverConfig(b -> b.baseDir(BaseDir.find("webapp/.ratpack")))
                .registry(Guice.registry(b -> b.module(ServerModule.class)))
                .handlers(chain -> chain
                        .files(b -> b.dir("assets"))
                        .get(HomeHandler.class)
                        .get("content", ContentHandler.class)
                )
        );
    }


}
