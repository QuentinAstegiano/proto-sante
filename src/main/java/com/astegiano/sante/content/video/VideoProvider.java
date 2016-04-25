package com.astegiano.sante.content.video;

import java.util.List;
import java.util.Optional;

/**
 * Created by Quentin on 25/04/2016.
 */
public interface VideoProvider {

    List<Video> getAll();

    Optional<Video> get(String id);
}
