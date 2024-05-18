package lab;

public class CountVisitor implements Visitor{
    private int count = 0;

    @Override
    public void visitFile(File file) {
        count++;
    }

    @Override
    public void visitDirectory(Directory directory) {
        count++;
//        for (FileSystemComponent component : directory.getComponents()) {
//            component.accept(this);
//        }
    }
    public int getCount() {
        return count;
    }
}
