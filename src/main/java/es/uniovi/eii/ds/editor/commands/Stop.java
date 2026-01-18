package es.uniovi.eii.ds.editor.commands;

import es.uniovi.eii.ds.editor.Command;
import es.uniovi.eii.ds.editor.TextEditor;

public class Stop implements Command {

    @Override
    public void execute(TextEditor editor) {
        editor.stopRecording();
    }

}
