package net.project.utils;

import java.util.ArrayList;

/**
 * @author learnercys on 17/09/15.
 */
public class GenericElement {
    private ArrayList<GenericAttr> attrs;

    public GenericElement() {
        attrs = new ArrayList<>();
    }

    public void addAll(GenericElement element) {
        this.attrs.addAll(element.getAttrs());
    }

    public void addAttr(GenericAttr attr) {
        this.attrs.add(attr);
    }

    public ArrayList<GenericAttr> getAttrs() {
        return this.attrs;
    }
}
