package lab;

public abstract class FileSystemComponent {
    protected String name;
    public FileSystemComponent(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Not supported.");
    }
    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Not supported.");
    }
    public abstract void print();
    public abstract int getSizeInBytes();
    public abstract void accept(Visitor visitor);
}
