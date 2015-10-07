package net.project.utils;

import java.util.ArrayList;

/**
 * @author learnercys on 9/17/15.
 */
public class Scenario {
    
    private String name;
    private Integer height;
    private Integer width;
    private String bg;

    private GenericElement hero;
    private GenericElement finish;
    private ArrayList<GenericElement> villains;
    private ArrayList<GenericElement> walls;
    private ArrayList<GenericElement> floors;
    private ArrayList<GenericElement> weapons;
    private ArrayList<GenericElement> bonus;

    public Scenario() {
        hero = new GenericElement();
        finish = new GenericElement();
        villains = new ArrayList<>();
        walls = new ArrayList<>();
        floors = new ArrayList<>();
        weapons = new ArrayList<>();
        bonus = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public void setElements(GenericElement elements) {
        for(GenericAttr attr: elements.getAttrs()) {
            // todo set the elements
            switch (attr.getType()) {
                case "characters":
                    this.hero = (GenericElement)((GenericElement)attr.getValue()).getAttr("hero").getValue();
                    this.villains.addAll((ArrayList<GenericElement>)((GenericElement)attr.getValue()).getAttr("hero").getValue());
                    break;
            }
        }
    }
}
