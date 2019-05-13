package org.sang.bean;

public class SubUMenu {
    private Integer id;
    private String name;
    private String route;

    public SubUMenu() {
    }

    public SubUMenu(Integer id, String name, String route) {
        this.id = id;
        this.name = name;
        this.route = route;
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

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", route='" + route + '\'' +
                '}';
    }
}
