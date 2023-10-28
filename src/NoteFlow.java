import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import javax.swing.JFrame;



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
    private JFrame frame;
}