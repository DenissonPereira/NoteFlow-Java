import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



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
    private JTextField titleField;
    private JTextArea contentArea;
    private JTextArea displayArea;

    public NoteFLow() {
        frame = new JFrame("Nota Pessoal")
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        titleField = new JTextField("Título Aqui");
        contentArea = new JTextArea("Coonteúdo da nota");
        JButton posButton = new JButton("Criar Post");

        posButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createPost();
            }
        });

        inputPanel.add(titleField, BorderLayout.NORTH);
        inputPanel.add(contentArea, BorderLayout.CENTER);
        inputPanel.add(posButton, BorderLayout.SOUTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void createPost() {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (!title.isEmpty() && !content.isEmpty()) {
            Post post = new Post(title, content);
            posts.add(post);
            displatyPosts();
            titleField.setText("");
            contentArea.setText("");
        }
    }

    private void displayPosts(){
        displayArea.setText("--- Notas já criadas ---\n");

        for (Post post : posts) {
            displayArea.append("Título: " + post.getTitle() + "\n");
            displayArea.append("COnteúdo: " + post.getContent() + "\n");
            displayArea.append("------------\n");
        }
    }
    
}