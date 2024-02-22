package module;

public class Student {
    private int id;
    private String names;

    public Student(int id, String names) {
        super();
        this.id = id;
        this.names = names;
    }

    public Student() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }
}
