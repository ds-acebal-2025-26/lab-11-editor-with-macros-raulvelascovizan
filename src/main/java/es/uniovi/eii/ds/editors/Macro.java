package es.uniovi.eii.ds.editors;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.eii.ds.main.Main;

public class Macro implements EditAction{

    private final List<EditAction> editActions = new ArrayList();

    public void addAction(EditAction editAction){
        this.editActions.add(editAction);
    }

    @Override
    public void edit(Main editor) {
        for (EditAction editAction: this.editActions){
            editAction.edit(editor);
        }
    }

}
