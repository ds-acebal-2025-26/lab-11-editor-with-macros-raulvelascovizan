package es.uniovi.eii.ds.editor;

import java.util.HashMap;
import java.util.Map;

import es.uniovi.eii.ds.editor.commands.Macro;

public class TextEditor {

    // Represents the document of the editor.
	private StringBuilder text = new StringBuilder();
    private Map<String, Macro> macros = new HashMap<>();
    
    private boolean isRecording;
    private Macro recordedMacro;

    public void executeCommand(Command command) {
        if(isRecording) {
            recordedMacro.addCommand(command);
        } else {
            command.execute(this);
        }
    }

    public Macro getMacro(String macroName) {
        return this.macros.get(macroName);
    }

    public StringBuilder text() {
        return text;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }

    public void startRecording(Macro macro) {
        this.isRecording = true;
        this.recordedMacro = macro;
    }

    public void stopRecording() {
        this.isRecording = false;
        if(recordedMacro != null) {
            macros.put(recordedMacro.name(), recordedMacro);
        }
    }
}
