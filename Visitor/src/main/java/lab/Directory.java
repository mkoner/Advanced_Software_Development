package lab;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemComponent{
    List<FileSystemComponent> components;
    public Directory(String name) {
        super(name);
        components = new ArrayList<FileSystemComponent>();
    }

    @Override
    public void print() {
        System.out.println("- directory "+ getName());
        components.forEach(FileSystemComponent::print);
    }

    @Override
    public int getSizeInBytes() {
        return components.stream().mapToInt(FileSystemComponent::getSizeInBytes).sum();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDirectory(this);
    }

    @Override
    public void add(FileSystemComponent component) {
        components.add(component);
    }
    @Override
    public void remove(FileSystemComponent component) {
        components.remove(component);
    }
    public List<FileSystemComponent> getComponents() {
        return components;
    }
}
