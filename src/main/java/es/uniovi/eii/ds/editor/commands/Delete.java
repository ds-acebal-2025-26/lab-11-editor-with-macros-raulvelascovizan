package es.uniovi.eii.ds.editor.commands;

import es.uniovi.eii.ds.editor.Command;
import es.uniovi.eii.ds.editor.TextEditor;

public class Delete implements Command {

    @Override
    public void execute(TextEditor editor) {
        int indexOfLastWord = editor.text().toString().trim().lastIndexOf(" ");
        if (indexOfLastWord == -1)
            editor.setText(new StringBuilder(""));
        else
            editor.text().setLength(indexOfLastWord);
    }

}
