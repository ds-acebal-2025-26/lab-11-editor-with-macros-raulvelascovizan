package es.uniovi.eii.ds.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import es.uniovi.eii.ds.editor.TextEditor;
import es.uniovi.eii.ds.editor.commands.Delete;
import es.uniovi.eii.ds.editor.commands.Execute;
import es.uniovi.eii.ds.editor.commands.Help;
import es.uniovi.eii.ds.editor.commands.Insert;
import es.uniovi.eii.ds.editor.commands.Open;
import es.uniovi.eii.ds.editor.commands.Record;
import es.uniovi.eii.ds.editor.commands.Replace;
import es.uniovi.eii.ds.editor.commands.Stop;

public class Main {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
		TextEditor editor = new TextEditor();
        new Main().run(editor);
    }
	
	// Main program loop.
    public void run(TextEditor editor) {
		drawLogo();
		editor.executeCommand(new Help());

		while (true) {
			UserCommand command = promptUser();
			String[] args = command.args;

			switch (command.name) {
				case "open" -> {
					if (!checkArguments(args, 1, "open <file>")) 
						return;
					editor.executeCommand(new Open(args));
				}
				case "insert" -> editor.executeCommand(new Insert(args));
				case "delete" -> editor.executeCommand(new Delete());
				case "replace" -> {
					if (!checkArguments(args, 2, "replace <find> <replace>")) 
						return;
					editor.executeCommand(new Replace(args));
				}
				case "help" -> editor.executeCommand(new Help());
				case "record" -> {
					String macroName = args[0];
					editor.executeCommand(new Record(macroName));
				}
				case "stop" -> { 
					editor.executeCommand(new Stop());
				}
				case "execute" -> {
					String macroName = args[0];
					editor.executeCommand(new Execute(macroName));
				}
				default -> {
					System.out.println("Unknown command");
					continue;
				}
			}

			System.out.println(editor.text().toString());
		}
	}

	//$-- Auxiliary methods ---------------------------------------------------

	// YOU DON'T NEED TO UNDERSTAND OR MODIFY THE CODE BELOW THIS LINE

	private record UserCommand(String name, String[] args) {}

    // Prompts the user and reads a line of input and returns it as a record with
	// the command and its arguments. If EOF is reached (i.e., there are nothing to
	// read), an error occurs or the user types "exit", the program exits. If there
	// are no arguments, the args array is empty.
	//
	// Example:
	//
	//   > insert "no quiero acordarme" --> returns UserInput("insert", ["no", "quiero", "acordarme"])
	//	 > delete                       --> returns UserInput("delete", [])
	//
	private UserCommand promptUser() {
		while (true) {
            System.out.print("> ");
            try {
                String line = in.readLine();
				if (line == null) System.exit(0);
				if (line.equals("exit")) exit();
				if (line.isBlank()) continue;
				String[] parts = line.split("\\s+");
				return new UserCommand(parts[0], Arrays.copyOfRange(parts, 1, parts.length));
            } catch (IOException e) {
                System.out.println("Error reading input");
				System.exit(2);
			}
		}
    }

	private boolean checkArguments(String[] args, int expected, String syntax) {
        if (args.length != expected) {
            System.out.println("Invalid number of arguments => " + syntax);
            return false;
        }
        return true;
    }

	private void exit() {
		System.out.println("Goodbye!");
		System.exit(0);
	}	

	private void drawLogo() {
		System.out.println(LOGO);
	}

	private static final String LOGO = """

			███╗   ███╗ █████╗  ██████╗████████╗███████╗██╗  ██╗
			████╗ ████║██╔══██╗██╔════╝╚══██╔══╝██╔════╝╚██╗██╔╝
			██╔████╔██║███████║██║        ██║   █████╗   ╚███╔╝ 
			██║╚██╔╝██║██╔══██║██║        ██║   ██╔══╝   ██╔██╗ 
			██║ ╚═╝ ██║██║  ██║╚██████╗   ██║   ███████╗██╔╝ ██╗
			╚═╝     ╚═╝╚═╝  ╚═╝ ╚═════╝   ╚═╝   ╚══════╝╚═╝  ╚═╝
			""";

	
}
