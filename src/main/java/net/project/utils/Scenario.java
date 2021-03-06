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

    public String getName() {
        return name;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public String getBg() {
        return bg;
    }

    public ArrayList<GenericElement> getVillains() {
        return villains;
    }

    public ArrayList<GenericElement> getWalls() {
        return walls;
    }

    public ArrayList<GenericElement> getFloors() {
        return floors;
    }

    public ArrayList<GenericElement> getWeapons() {
        return weapons;
    }

    public ArrayList<GenericElement> getBonus() {
        return bonus;
    }

    public GenericElement getFinish() {
        return finish;
    }

    public GenericElement getHero() {
        return hero;
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

    /**
     * Set the elements to the current scenario
     * @param elements the new elements.
     */
    public void setElements(GenericElement elements) {
        for(GenericAttr attr: elements.getAttrs()) {
            switch (attr.getType()) {
                case "characters":
                    GenericElement characters = (GenericElement)attr.getValue();
                    for(GenericAttr cAttr: characters.getAttrs()){
                        switch (cAttr.getType()) {
                            case "villains":
                                GenericElement villains = (GenericElement)cAttr.getValue();
                                for(GenericAttr vAttr: villains.getAttrs()){
                                    this.villains.add((GenericElement)vAttr.getValue());
                                }
                                break;

                            case "hero":
                                this.hero = (GenericElement)cAttr.getValue();
                                break;
                        }
                    }
                    break;

                case "walls":
                    GenericElement walls = (GenericElement)attr.getValue();
                    for(GenericAttr wAttr: walls.getAttrs()){
                        this.walls.add((GenericElement)wAttr.getValue());
                    }
                    break;

                case "floors":
                    GenericElement floors = (GenericElement)attr.getValue();
                    for(GenericAttr fAttr: floors.getAttrs()){
                        this.floors.add((GenericElement)fAttr.getValue());
                    }
                    break;

                case "extras":
                    GenericElement extras = (GenericElement)attr.getValue();
                    for(GenericAttr eAttr: extras.getAttrs()){
                        switch (eAttr.getType()){
                            case "weapons":
                                GenericElement weapons = (GenericElement)eAttr.getValue();
                                for(GenericAttr wAttr: weapons.getAttrs()) {
                                    this.weapons.add((GenericElement)wAttr.getValue());
                                }
                                break;

                            case "bonus":
                                GenericElement bonus = (GenericElement)eAttr.getValue();
                                for(GenericAttr wAttr: bonus.getAttrs()) {
                                    this.bonus.add((GenericElement)wAttr.getValue());
                                }
                                break;
                        }
                    }
                    break;

                case "finish":
                    GenericElement finish = (GenericElement)attr.getValue();
                    for(GenericAttr fAttr: finish.getAttrs()){
                        this.finish = (GenericElement)fAttr.getValue();
                    }

                    break;

            }
        }
    }
}
