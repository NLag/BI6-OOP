import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by nhatl on 12/11/2016.
 */
public class GetDataThread extends Thread {
    private String inpath;

    public GetDataThread(String inpath) {
        this.inpath = inpath;
    }

    @Override
    public void run() {
        try {
            File data = new File(inpath);
            Scanner scanner = new Scanner(data);

            int n;
            int[][] dat = new int[100][100];
            n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dat[i][j] = scanner.nextInt();
                }
            }

            scanner.close();

            Gui.Text_Show.append(n + "\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Gui.Text_Show.append(dat[i][j]+ " ");
                }
                Gui.Text_Show.append("\n");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GetDataThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

