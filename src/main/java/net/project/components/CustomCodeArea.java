package net.project.components;

import net.project.utils.CFile;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

/**
 * @author learnercys on 8/31/15.
 */
public class CustomCodeArea extends CodeArea {

    private String savedText;
    private CFile file;

    public CustomCodeArea() {
        // by default, show the code line number
        this(true);
    }

    public CustomCodeArea(boolean codeLine) {
        if(codeLine) {
            super.setParagraphGraphicFactory(LineNumberFactory.get(this));
        }
    }

    public void setFile(CFile file) {
        this.file = file;

        if ( this.file == null) {
            super.replaceText("");
        } else {
            // read current file and set his text inside the code area
            this.replaceText(file.read());
        }
    }

    public CFile getFile() {
        return this.file;
    }
}
