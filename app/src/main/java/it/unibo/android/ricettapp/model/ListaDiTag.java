package it.unibo.android.ricettapp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListaDiTag {

    private long id;
    private static ListaDiTag instance = null;

    private List<Tag> tags;

    protected ListaDiTag() {
        tags = new ArrayList<>();
        this.id = System.currentTimeMillis();
    }

    public static ListaDiTag getInstance() {
        if (instance == null) {
            instance = new ListaDiTag();
        }
        return instance;
    }

    public boolean aggiungiTag(Tag tag) {
        return this.tags.add(tag);
    }

    public boolean eliminaTag(Tag tag) {
        return this.tags.remove(tag);
    }

    public Collection<Tag> getTags() {
        return new ArrayList<>(this.tags);
    }
}
