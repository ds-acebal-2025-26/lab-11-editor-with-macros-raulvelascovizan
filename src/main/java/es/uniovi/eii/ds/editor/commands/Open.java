package es.uniovi.eii.ds.editor.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

import es.uniovi.eii.ds.editor.Command;
import es.uniovi.eii.ds.editor.TextEditor;

public class Open implements Command {

    private String[] args;

    public Open(String[] args) {
        this.args = args;
    }

    @Override
    public void execute(TextEditor editor) {
        try {
			String filename = args[0];
			editor.setText(new StringBuilder(readFile(filename)));
		} catch (Exception e) {
			System.out.println("Document could not be opened");
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
