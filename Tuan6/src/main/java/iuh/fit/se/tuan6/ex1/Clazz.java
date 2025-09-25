package iuh.fit.se.tuan6.ex1;

public class Clazz {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clazz{id='" + id + "', name='" + name + "'}";
    }
}
