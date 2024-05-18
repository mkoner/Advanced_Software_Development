package lab;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Directory cdrive = new Directory("C");
        Directory appdir = new Directory("applications");
        Directory datadir = new Directory("my data");
        Directory coursedir = new Directory("cs525");
        File excelfile = new File("msexcel.exe", 2353256);
        File wordfile = new File("msword.exe", 3363858);
        File studentsfile = new File("students.doc", 34252);
        cdrive.add(appdir);
        cdrive.add(datadir);
        datadir.add(coursedir);
        appdir.add(excelfile);
        appdir.add(wordfile);
        coursedir.add(studentsfile);
        cdrive.print();
        System.out.println("C drive size: " + cdrive.getSizeInBytes());

        CountVisitor visitor = new CountVisitor();

        cdrive.accept(visitor);
        System.out.println("C drive file count: " + visitor.getCount());
    }
}