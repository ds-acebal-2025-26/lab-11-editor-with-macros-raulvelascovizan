package es.uniovi.eii.ds.editor.commands;

import es.uniovi.eii.ds.editor.Command;
import es.uniovi.eii.ds.editor.TextEditor;

public class Insert implements Command {

    private String[] args;

    public Insert(String[] args) {
        this.args = args;
    }

    @Override
    public void execute(TextEditor editor) {
        for (String word : args) {
            editor.text().append(" ").append(word);
        }
    }

}
