package com.astegiano.sante;

import ratpack.guice.Guice;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;
import ratpack.thymeleaf.Template;
import ratpack.thymeleaf.ThymeleafModule;

/**
 * Created by Quentin on 24/04/2016.
 */
public class Server {

    public static void main(String... args) throws Exception {

        ThymeleafModule thymeleafModule = new ThymeleafModule();
        thymeleafModule.setTemplatesPrefix("templates");

        RatpackServer.start(server -> server
                .serverConfig(b -> b.baseDir(BaseDir.find("webapp/.ratpack")))
                .registry(Guice.registry(b -> b.module(ServerModule.class)))
                .registry(Guice.registry(b -> b.module(thymeleafModule)))
                .handlers(chain -> chain
                        .files(b -> b.dir("assets"))
                        .get(ctx -> ctx.render(Template.thymeleafTemplate("home")))
                        .get("videos", ctx -> ctx.render(Template.thymeleafTemplate("videos")))
                )
        );
    }


}
