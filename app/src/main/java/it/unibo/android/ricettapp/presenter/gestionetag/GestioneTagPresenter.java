package it.unibo.android.ricettapp.presenter.gestionetag;

import it.unibo.android.ricettapp.model.ListaDiTag;
import it.unibo.android.ricettapp.model.Tag;

public class GestioneTagPresenter  implements IGestioneTag {

    @Override
    public void aggiungiTag(String tagName) {

        ListaDiTag tags = ListaDiTag.getInstance();
        tags.aggiungiTag(new Tag(tagName));
        // TODO: Invocare View Home Tag
    }

    @Override
    public void eliminaTag(Tag tag) {
        ListaDiTag tags = ListaDiTag.getInstance();
        tags.eliminaTag(tag);
        // TODO: Invocare View Home Tag
    }

}
