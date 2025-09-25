package iuh.fit.se.tuan6.ex1;

public class Student {
    private long id;
    private String name;

    private Clazz clazz;

    public Student(){

    }

    public Student(long id, String name, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
