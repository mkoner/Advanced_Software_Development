package lab;

public interface Visitor {
    void visitFile(File file);
    void visitDirectory(Directory directory);
}
