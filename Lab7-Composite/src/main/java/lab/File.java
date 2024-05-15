package lab;

public class File extends FileSystemComponent{
    private int sizeInBytes;
    public File(String name, int size) {
        super(name);
        this.sizeInBytes = size;
    }

    @Override
    public void print() {
        System.out.println("--- file "+name+" size="+getSizeInBytes()+" bytes");
    }

    @Override
    public int getSizeInBytes() {
        return sizeInBytes;
    }

}
