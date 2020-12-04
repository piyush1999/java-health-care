package sanjeevani.pojo;

import javax.swing.JOptionPane;
import sanjeevani.dbutil.DBConnection;

public class CloseFrame {
     public static void closeFrame(){
        int ans;
        ans = JOptionPane.showConfirmDialog(null, "Are you sure want to quit?", "QUITTING!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ans == JOptionPane.YES_OPTION) {
            DBConnection.closeConnection();
            System.exit(0);
        } 
    }
    
    
}
