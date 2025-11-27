package es.uniovi.eii.ds.editors;

import es.uniovi.eii.ds.main.Main;

public class Insert implements EditAction{

    String[] args;

    public Insert (String args[]){
        this.args = args;
    }

    @Override
    public void edit(Main editor) {
        for (String word : args) {
            editor.text.append(" ").append(word);
        }
    }

}
