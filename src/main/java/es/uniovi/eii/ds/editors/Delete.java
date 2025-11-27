package es.uniovi.eii.ds.editors;

import es.uniovi.eii.ds.main.Main;

public class Delete implements EditAction{

    @Override
    public void edit(Main editor) {
        int indexOfLastWord = editor.text.toString().trim().lastIndexOf(" ");
            if (indexOfLastWord == -1)
                editor.text = new StringBuilder("");
            else
                editor.text.setLength(indexOfLastWord);
    }

}
