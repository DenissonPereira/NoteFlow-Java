import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

    public NoteFlow() {
        frame = new JFrame("Nota Pessoal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        titleField = new JTextField("Título Aqui: ");
        contentArea = new JTextArea("Conteúdo da nota: ");
        JButton posButton = new JButton("Criar Nota");
        JButton saveButton = new JButton("Salvar Notas");

        posButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createPost();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exportNotes();
            }
        });

        inputPanel.add(titleField, BorderLayout.NORTH);
        inputPanel.add(contentArea, BorderLayout.CENTER);
        inputPanel.add(posButton, BorderLayout.SOUTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        frame.add(saveButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void createPost() {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (!title.isEmpty() && !content.isEmpty()) {
            Post post = new Post(title, content);
            posts.add(post);
            displayPosts();
            titleField.setText("");
            contentArea.setText("");
        }
    }

    private void displayPosts(){
        displayArea.setText("--- Notas já criadas ---\n");

        for (Post post : posts) {
            displayArea.append("Título: " + post.getTitle() + "\n");
            displayArea.append("Conteúdo: " + post.getContent() + "\n");
            displayArea.append("------------\n");
        }
    }

    private void exportNotes() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("notas.txt"));
            for (Post post : posts) {
                writer.write("Título: " + post.getTitle() + "\n");
                writer.write("Conteúdo: " + post.getContent() + "\n");
                writer.write("------------\n");
            }
            writer.close();
            JOptionPane.showMessageDialog(frame, "Notas exportadas com sucesso para 'notas.txt'");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Erro ao exportar as notas.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NoteFlow();
            }
        });
    }
}
