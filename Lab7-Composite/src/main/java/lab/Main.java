package lab;

public class Main {
    public static void main(String[] args) {
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
        Directory links = new Directory("links");
        Directory videoLinks = new Directory("videoLinks");
        links.add(videoLinks);
        Directory imageLinks = new Directory("imageLinks");
        links.add(imageLinks);
        Link video1 = new Link("video1", "https://video1");
        Link video2 = new Link("video2", "https://video2");
        Link video3 = new Link("video3", "https://video3");
        Link image1 = new Link("image1", "https://image1");
        Link image2 = new Link("image2", "https://image2");
        videoLinks.add(video1);
        videoLinks.add(video2);
        videoLinks.add(video3);
        imageLinks.add(image1);
        imageLinks.add(image2);
        links.print();

    }
}