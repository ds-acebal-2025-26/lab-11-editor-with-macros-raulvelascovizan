package es.uniovi.eii.ds.editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
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

    public void open(String[] args) {
        try {
			String filename = args[0];
			text = (new StringBuilder(readFile(filename)));
		} catch (Exception e) {
			System.out.println("Document could not be opened");
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

    public void startRecording(String macroName) {
        this.isRecording = true;
        this.recordedMacro = new Macro(macroName);
    }

    public void stopRecording() {
        this.isRecording = false;
        if(recordedMacro != null) {
            macros.put(recordedMacro.name(), recordedMacro);
        }
    }

    private String readFile(String filename) {
		InputStream in = getClass().getResourceAsStream("/" + filename);
		if (in == null)
			throw new IllegalArgumentException("File not found: " + filename);

		try (BufferedReader input = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder result = new StringBuilder();
			String line;
			boolean firstLine = true;
			while ((line = input.readLine()) != null) {
				if (!firstLine)
					result.append(System.lineSeparator());
				result.append(line);
				firstLine = false;
			}
			return result.toString();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
