package tallier;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.SwingUtilities;
import utils.MyLogger;
import validator.ValidatorServer;

public class TallierGui extends javax.swing.JFrame {

    private final TallierServer tallier;
    private final ValidatorServer validator;

    /** Creates new form TallierGui */
    public TallierGui() {
        MyLogger.initLogging("TallierLogger", "tallier.log");
        MyLogger.initLogging("ValidatorLogger", "validator.log");
        MyLogger.initLogging("VoterLogger", "voterCountVerification.log");
        tallier = new TallierServer();
        validator = new ValidatorServer();
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonStart = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jListResults = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonStart.setText("Start");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonStop.setText("Stop");
        jButtonStop.setEnabled(false);
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabelTitle.setText("Electronic Voting System");

        jListResults.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane.setViewportView(jListResults);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonStop, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelTitle))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonStop, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        new Thread( tallier ).start();
        new Thread( validator ).start();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                jButtonStart.setEnabled(false);
                jButtonStop.setEnabled(true);
            }
        });
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        final List<String> results = getResults();
        tallier.stop();
        validator.stop();
        jListResults.setModel(new AbstractListModel() {

            public int getSize() {
                return results.size();
            }

            public Object getElementAt(int index) {
                return results.get(index);
            }
        });
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                jButtonStop.setEnabled(false);
            }
        });
    }//GEN-LAST:event_jButtonStopActionPerformed

    private List<String> getResults() {
        // TODO
        List<String> results = new LinkedList<String>();
        results.add("Marius 50%");
        results.add("Ionutz 50%");
        return results;
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TallierGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JList jListResults;
    private javax.swing.JScrollPane jScrollPane;
    // End of variables declaration//GEN-END:variables

}
