package es.uniovi.eii.ds.editor.commands;

import java.util.ArrayList;

import es.uniovi.eii.ds.editor.Command;
import es.uniovi.eii.ds.editor.TextEditor;

public class Macro implements Command {

    private ArrayList<Command> commands = new ArrayList<>();
    private String name;

    public Macro(String name) {
        this.name = name;
    }

    @Override
    public void execute(TextEditor editor) {
        for (Command command : this.commands) {
            command.execute(editor);
        }
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public String name() {
        return this.name;
    }
}
