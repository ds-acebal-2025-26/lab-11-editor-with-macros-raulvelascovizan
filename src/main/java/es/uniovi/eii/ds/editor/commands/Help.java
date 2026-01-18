package es.uniovi.eii.ds.editor.commands;

import es.uniovi.eii.ds.editor.Command;
import es.uniovi.eii.ds.editor.TextEditor;

public class Help implements Command {

    @Override
    public void execute(TextEditor editor) {
        System.out.println(HELP);
    }

    private static final String HELP = """
			┌──────────────────────┬─────────────────────────────────────────────┐
			│ open <file>          │                                             │
			│ insert <text>        │ append text to the end                      │
			│ delete               │ delete the last word                        │
			│ replace <a> <b>      │ replace <a> with <b> in the whole document  │
			├──────────────────────┼─────────────────────────────────────────────┤
			│ record <macro>       │ start recording a macro                     │
			│ stop                 │ stop recording                              │
			│ execute <macro>      │ execute the specified macro                 │
			├──────────────────────┼─────────────────────────────────────────────┤
			│ help                 │                                             │
			│ exit                 │                                             │
			└──────────────────────┴─────────────────────────────────────────────┘
			""";
}
