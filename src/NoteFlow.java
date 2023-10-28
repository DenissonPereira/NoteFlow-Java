import java.util.ArrayList;

import javax.swing.*;



class Post {
    private String title;
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
}

public class NoteFlow {

    private List<Post> posts = new ArrayList<>();
}