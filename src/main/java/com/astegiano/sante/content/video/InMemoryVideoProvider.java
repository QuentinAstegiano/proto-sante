package com.astegiano.sante.content.video;

import com.google.inject.Singleton;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by Quentin on 25/04/2016.
 */
@Singleton
public class InMemoryVideoProvider implements VideoProvider {

    private final Random random = new Random();
    private final Map<String, Video> videos = new LinkedHashMap<>();

    public InMemoryVideoProvider() {
        load();
    }

    @Override
    public List<Video> getAll() {
        return new ArrayList<>(videos.values());
    }

    @Override
    public Optional<Video> get(String id) {
        return Optional.ofNullable(videos.get(id));
    }

    private void load() {
        Video v = make("https://player.vimeo.com/video/45050045",
                "Crème angélique de courgettes (vegan - sans gluten)",
                "https://i.vimeocdn.com/video/448244356_130x73.jpg"
        );
        videos.put(v.getId(), v);

        v = make("https://player.vimeo.com/video/80875283",
                "Tapenade d’algues. C’est bon, c’est bio !",
                "https://i.vimeocdn.com/video/80875283_130x73.jpg"
        );
        videos.put(v.getId(), v);

        v = make("https://player.vimeo.com/video/18751690",
                "Cuisine au balcon avec Natacha",
                "https://i.vimeocdn.com/video/18751690_130x73.jpg"
        );
        videos.put(v.getId(), v);

        v = make("https://player.vimeo.com/video/113025003",
                "Tiradito et Château L’Hospital",
                "https://i.vimeocdn.com/video/113025003_130x73.jpg"
        );
        videos.put(v.getId(), v);
    }

    private Video make(String url, String title, String thumbnail) {
        return new Video.Builder()
                .withTitle(title)
                .withUrl(url)
                .withThumbnail(thumbnail)
                .withId(String.valueOf(random.nextLong()))
                .withDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                .withDate(LocalDate.now())
                .build();

    }
}
