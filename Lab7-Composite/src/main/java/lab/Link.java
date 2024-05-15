package lab;

public class Link extends FileSystemComponent{
    private String link;
    public Link(String name, String link) {
        super(name);
        this.link = link;
    }

    @Override
    public void print() {
        System.out.println("---- name "+name+" link= "+link);
    }

    @Override
    public int getSizeInBytes() {
        return 0;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
}
