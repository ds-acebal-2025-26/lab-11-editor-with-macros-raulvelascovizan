package es.uniovi.eii.ds.editor.commands;

import es.uniovi.eii.ds.editor.Command;
import es.uniovi.eii.ds.editor.TextEditor;

public class Record implements Command {

    private String macroName;

    public Record(String macroName) {
        this.macroName = macroName;
    }

    @Override
    public void execute(TextEditor editor) {
        editor.startRecording(new Macro(macroName));
    }

}
