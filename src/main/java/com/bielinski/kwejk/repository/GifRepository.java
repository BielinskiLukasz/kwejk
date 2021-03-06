package com.bielinski.kwejk.repository;

import com.bielinski.kwejk.model.Gif;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GifRepository {
    private static List<Gif> ALL_GIFS = new ArrayList<>();

    static {
        ALL_GIFS.add(new Gif("android-explosion", true, 1, "Rafal"));
        ALL_GIFS.add(new Gif("ben-and-mike", false, 1, "Lukas"));
        ALL_GIFS.add(new Gif("book-dominos", false, 2, "Bogdan"));
        ALL_GIFS.add(new Gif("compiler-bot", true, 2, "Stefan"));
        ALL_GIFS.add(new Gif("cowboy-coder", false, 3, "Lukas"));
        ALL_GIFS.add(new Gif("infinite-andrew", true, 3, "Maciek"));
    }

    public List<Gif> findAll() {
        return ALL_GIFS;
    }

    public List<Gif> findFavorites() {
        return ALL_GIFS.stream().filter(p -> p.isFavorite()).collect(Collectors.toList());
    }

    public Optional<Gif> findByName(String name) {
        return ALL_GIFS.stream().filter(p -> p.getName().equals(name)).findFirst();
    }

    public static List<Gif> findByCategoryId(int categoryId) {
        return ALL_GIFS.stream().filter(p -> p.getCategoryId() == categoryId).collect(Collectors.toList());
    }

    public List<Gif> findAllByNameIgnoreCase(String name) {
        return ALL_GIFS.stream().filter(p -> p.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }
}
