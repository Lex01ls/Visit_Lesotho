package model;

public class Photos {

    private String folderName;
    private String author;
    private String reviews;
    private String name;


    public String getFolderName() {
        return folderName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }
}
