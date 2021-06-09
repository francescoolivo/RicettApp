package it.unibo.android.ricettapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class ListaDiTag {

    @PrimaryKey
    private final long id;
    private static ListaDiTag instance = null;

    @ColumnInfo(name = "tag")
    private final List<Tag> tags;

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
