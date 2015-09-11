package net.project.components;

import net.project.utils.CustomFile;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

/**
 * @author learnercys on 8/31/15.
 */
public class CustomCodeArea extends CodeArea {

    private String savedText;
    private CustomFile file;

    public CustomCodeArea() {
        // by default, show the code line number
        this(true);
    }

    public CustomCodeArea(boolean codeLine) {
        if(codeLine) {
            super.setParagraphGraphicFactory(LineNumberFactory.get(this));
        }
    }
}
