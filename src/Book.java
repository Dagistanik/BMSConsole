import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable<Book>{
    private int id;
    private String title;
    private String author;
    private String genre;

    public Book(int id, String title, String author, String genre){
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public void setId (int id){this.id = id;}

    public void setTitle(String title){this.title = title;}

    public void setAuthor(String author){this.author = author;}

    public void setGenre(String genre){this.genre = genre;}

    public int getId(){return this.id;}

    public String getTitle(){return this.title;}

    public String getAuthor(){return this.author;}

    public String getGenre(){return this.genre;}



    @Override
    public boolean equals(Object obj){
        if(obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return this.id == book.id && this.title.equals(book.title) && this.author.equals(book.author) && this.genre.equals(book.genre);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id, title, author, genre);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return this.id - o.id;
    }

    public static Comparator<Book> titleComparator = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    };

}