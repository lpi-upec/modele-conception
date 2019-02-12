package fr.esipe.mch.composite;

import java.util.*;

/**
 * @author Daiiguren
 */
public class File {
    private String Name;
    private Date creationDate;
    private Long Size;
    private String Type;
    private boolean Folder;
    private Set<File> Files = new HashSet<>();

    @Override
    public String toString() {
        return "File{" +
                "Name='" + Name + '\'' +
                ", creationDate=" + creationDate +
                ", Size=" + Size +
                ", Type='" + Type + '\'' +
                ", Folder=" + Folder +
                ", Files=" + Files +
                '}';
    }


    public Set<File> getFiles() {
        return Files;
    }

    public void setFiles(Set<File> files) {
        Files = files;
    }

    public boolean isFolder() {
        return Folder;
    }

    public void setFolder(boolean folder) {
        Folder = folder;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getSize() {
        return Size;
    }

    public void setSize(Long size) {
        Size = size;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public static void main(String[] args){
        File file = new File();
        file.setName("note");
        file.setSize(0L);
        file.setType(".xls");
        file.setCreationDate(new Date());

        File file2 = new File();
        file2.setName("control");
        file2.setSize(0L);
        file2.setType(".doc");
        file2.setCreationDate(new Date());

        File directory = new File();
        directory.setFolder(true);
        directory.setName("Folder");
        directory.getFiles().add(file);
        directory.getFiles().add(file2);

        File directory2 = new File();
        directory2.setFolder(true);
        directory2.setName("Subfolder");
        directory.getFiles().add(directory2);
        directory2.getFiles().add(file);
        directory2.getFiles().add(file2);

        for(File f : directory.getFiles()){
            System.out.println(f);
        }
    }
}
