package net.project.utils;

/**
 * @author learnercys on 17/09/15.
 */
public class GenericAttr<T> {
    private String type;
    private T value;

    public String getType() {
        return type;
    }

    public T getValue() {
        return value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
