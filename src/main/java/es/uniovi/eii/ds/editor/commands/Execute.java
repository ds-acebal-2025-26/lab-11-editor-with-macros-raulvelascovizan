package es.uniovi.eii.ds.editor.commands;

import es.uniovi.eii.ds.editor.Command;
import es.uniovi.eii.ds.editor.TextEditor;

public class Execute implements Command {

    private String macroName;

    public Execute(String macroName) {
        this.macroName = macroName;
    }

    @Override
    public void execute(TextEditor editor) {
        Macro macro = editor.getMacro(macroName);
        macro.execute(editor);
    }

}
