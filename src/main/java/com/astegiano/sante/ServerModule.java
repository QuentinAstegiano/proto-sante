package com.astegiano.sante;

import com.astegiano.sante.content.video.InMemoryVideoProvider;
import com.astegiano.sante.content.video.VideoProvider;
import com.astegiano.sante.web.pages.content.ContentHandler;
import com.astegiano.sante.web.pages.home.HomeHandler;
import com.google.inject.AbstractModule;
import ratpack.thymeleaf.ThymeleafModule;

/**
 * Created by Quentin on 24/04/2016.
 */
public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        ThymeleafModule thymeleafModule = new ThymeleafModule();
        thymeleafModule.setTemplatesPrefix("templates");
        install(thymeleafModule);

        bind(VideoProvider.class).to(InMemoryVideoProvider.class);

        bind(ContentHandler.class);
        bind(HomeHandler.class);
    }
}
