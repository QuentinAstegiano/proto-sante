package com.astegiano.sante.web.pages.home;

import com.google.inject.Singleton;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.thymeleaf.Template;

/**
 * Created by Quentin on 25/04/2016.
 */
@Singleton
public class HomeHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.render(Template.thymeleafTemplate("home"));
    }
}
