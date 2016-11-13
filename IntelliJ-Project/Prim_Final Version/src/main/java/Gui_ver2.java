import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Scanner;

/**
 * Created by nhatl on 14/11/2016.
 */
public class Gui_ver2 extends JFrame {
    private JTextField Text_input;
    private JButton loadButton;
    private JTextArea Text_Show;
    private JTextArea Text_Result;
    private JButton solveButton;
    private javax.swing.JPanel JPanel;

    public Gui_ver2() {

        super("Prim");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setContentPane(JPanel);

        // Make Load Button to Load data from file
        loadButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                String inpath = Text_input.getText();
                //Example: String inpath = "C:\\Users\\nhatl\\Downloads\\input.dat";
                if (!inpath.equals("")) {
                    //open file and a input stream to read file
                    File data = new File(inpath);
                    FileInputStream fin = null;
                    try {
                        fin = new FileInputStream(data);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    BufferedInputStream bfinput = new BufferedInputStream(fin);

                    //read file contents
                    byte[] contents = new byte[1024];
                    int bytesRead = 0;
                    String strcontents = "";
                    try {
                        while((bytesRead = bfinput.read(contents)) != -1) {
                            strcontents += new String(contents, 0, bytesRead);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Text_Show.append(strcontents);
                    Text_Show.append("\n");
                }
            }
        });

        // Make Find Button to get data from Graph Text Area
        solveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                String input = Text_Show.getText();
                Graph graph1=new PrimAlgorithm();
                graph1.getGraph(input);
                graph1.Prim();
                String output = graph1.getoutput();
                Text_Result.append(output);
                Text_Result.append("\n");
            }
        });

        pack();
        setSize(500,500);
    }


    public static void startgui() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Gui_ver2().setVisible(true);
            }
        });
    }

}
