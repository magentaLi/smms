package org.sang.bean;

import java.util.List;

public class UMenu {
    private Integer id;
    private String name;
    private String path;
    private List<SubUMenu> subUMenuList;

    public UMenu() {
    }

    public UMenu(Integer id, String name, String path, List<SubUMenu> subUMenuList) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.subUMenuList = subUMenuList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<SubUMenu> getSubUMenuList() {
        return subUMenuList;
    }

    public void setSubUMenuList(List<SubUMenu> subUMenuList) {
        this.subUMenuList = subUMenuList;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", subUMenuList=" + subUMenuList +
                '}';
    }
}
