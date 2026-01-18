package es.uniovi.eii.ds.editor.commands;

import es.uniovi.eii.ds.editor.Command;
import es.uniovi.eii.ds.editor.TextEditor;

public class Replace implements Command {

    private String[] args;

    public Replace(String[] args) {
        this.args = args;
    }

    @Override
    public void execute(TextEditor editor) {
        String find = args[0];
		String replace = args[1];
		editor.setText(new StringBuilder(editor.text().toString().replace(find, replace)));
    }

}
