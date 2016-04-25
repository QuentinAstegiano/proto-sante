package com.astegiano.sante.web.pages.content;

import com.astegiano.sante.content.video.Video;
import com.astegiano.sante.content.video.VideoProvider;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.thymeleaf.Template;

import java.util.Optional;

/**
 * Created by Quentin on 25/04/2016.
 */
@Singleton
public class ContentHandler implements Handler {

    private VideoProvider videos;

    @Inject
    public ContentHandler(VideoProvider videos) {
        this.videos = videos;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        Optional<Video> first = videos.getAll().stream().findFirst();
        if (first.isPresent()) {
            ctx.render(Template.thymeleafTemplate("videos", m -> m.put("hero", first.get())));
        } else {
            // TODO
        }
    }
}
