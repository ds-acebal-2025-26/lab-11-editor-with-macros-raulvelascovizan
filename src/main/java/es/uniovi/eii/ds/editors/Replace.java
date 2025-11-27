package es.uniovi.eii.ds.editors;

import es.uniovi.eii.ds.main.Main;

public class Replace implements EditAction{

    String[] args;

    public Replace (String[] args){
        this.args = args;
    }

    @Override
    public void edit(Main editor) {
		if (!editor.checkArguments(args, 2, "replace <find> <replace>"))
			return;
		String find = args[0];
		String replace = args[1];
		editor.text = new StringBuilder(editor.text.toString().replace(find, replace));
    }

}