/*
 * VotingProcessMain.java
 *
 * Created on Jan 9, 2010, 8:09:23 PM
 */

package voter;

import java.security.interfaces.RSAPublicKey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import database.DataBaseConector;
import java.util.List;
import ssl.RSA_Blinder;
import utils.*;

/**
 *
 * @author Marius Ion
 */
public class VotingGUI extends javax.swing.JFrame {
    private final Logger vLogger = Logger.getLogger("VotingLogger");
    private final List<Candidate> candidates = new ArrayList<Candidate>();

    /** Creates new form VotingProcessMain */
    public VotingGUI() {
        readCandidatesFromDB();
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

        jPanelAuthentication = new javax.swing.JPanel();
        jLabelKSPath = new javax.swing.JLabel();
        jLabelKSPass = new javax.swing.JLabel();
        jTextFieldKSPath = new javax.swing.JTextField();
        jPasswordFieldKSPass = new javax.swing.JPasswordField();
        jLabelNume = new javax.swing.JLabel();
        jLabelPrenume = new javax.swing.JLabel();
        jLabelCNP = new javax.swing.JLabel();
        jTextFieldNume = new javax.swing.JTextField();
        jTextFieldPrenume = new javax.swing.JTextField();
        jTextFieldCNP = new javax.swing.JTextField();
        jScrollPaneList = new javax.swing.JScrollPane();
        jListCandidates = new javax.swing.JList();
        jButtonVote = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelAuthentication.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Authentication", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabelKSPath.setText("KeyStore Path");

        jLabelKSPass.setText("KeyStore Password");

        jTextFieldKSPath.setText("security/voters/Marius/Marius.ks");

        jPasswordFieldKSPass.setText("Marius_password");

        jLabelNume.setText("Nume");

        jLabelPrenume.setText("Prenume");

        jLabelCNP.setText("CNP");

        jTextFieldNume.setText("Ion");

        jTextFieldPrenume.setText("Marius");

        jTextFieldCNP.setText("1851130160046");

        javax.swing.GroupLayout jPanelAuthenticationLayout = new javax.swing.GroupLayout(jPanelAuthentication);
        jPanelAuthentication.setLayout(jPanelAuthenticationLayout);
        jPanelAuthenticationLayout.setHorizontalGroup(
            jPanelAuthenticationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAuthenticationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAuthenticationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelKSPass)
                    .addComponent(jLabelKSPath)
                    .addComponent(jLabelNume)
                    .addComponent(jLabelPrenume)
                    .addComponent(jLabelCNP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAuthenticationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldCNP)
                    .addComponent(jTextFieldPrenume)
                    .addComponent(jTextFieldNume)
                    .addComponent(jPasswordFieldKSPass)
                    .addComponent(jTextFieldKSPath, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAuthenticationLayout.setVerticalGroup(
            jPanelAuthenticationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAuthenticationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAuthenticationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKSPath)
                    .addComponent(jTextFieldKSPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAuthenticationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKSPass)
                    .addComponent(jPasswordFieldKSPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAuthenticationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNume)
                    .addComponent(jTextFieldNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAuthenticationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrenume)
                    .addComponent(jTextFieldPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAuthenticationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCNP)
                    .addComponent(jTextFieldCNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jListCandidates.setModel(new javax.swing.AbstractListModel() {
            List<String> strings = getCandidates();
            public int getSize() { return strings.size(); }
            public Object getElementAt(int i) { return strings.get(i); }
        });
        jScrollPaneList.setViewportView(jListCandidates);

        jButtonVote.setFont(new java.awt.Font("Tahoma", 0, 36));
        jButtonVote.setText("Voteaza !");
        jButtonVote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneList, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanelAuthentication, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAuthentication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonVote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneList))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoteActionPerformed
        try {
            doVote();
            this.setVisible(false);
            this.dispose();
            JOptionPane.showMessageDialog(rootPane, "Vote Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonVoteActionPerformed

    private void doVote()
            throws Exception
    {
        Voter v = getVoter();
        VotingProcess vp = getVotingProcess();
        Ballot ballot = getBallot();
        vp.sendRequestToVote(v);
        if (!vp.voterIsEligible()){
            String message = "Voter with CNP "+v.getCNP()+" is NOT eligible to vote. Possible fraud detected.";
            vLogger.fatal(message);
            throw new Exception(message);
        }

        String message = "Voter with CNP "+v.getCNP()+" is eligible to vote.";
        vLogger.info(message);
        RSA_Blinder rsaBlinder = new RSA_Blinder((RSAPublicKey)vp.getPbK());
        byte[] raw  = ballot.getBytes();
        
        try{
            rsaBlinder = new RSA_Blinder((RSAPublicKey)vp.getPbK());
            vp.sendBlindedMessage(rsaBlinder.blind(raw));

            if (vp.getBlindedSignedMessage() != null){
                //System.out.println(Ballot.fromByteArray(RSA_Blinder.unsign(rsaBlinder.unblind(vp.getBlindedSignedMessage()), (RSAPublicKey)vp.getPbK())));
                vp.sendSignedMessageForTallier(rsaBlinder.unblind(vp.getBlindedSignedMessage()));
            }
            else{
                vLogger.error("Error receiving the blinded signed message");
                return;
            }
     
        }catch(Exception e){
            vLogger.error("Error at RSA blinding "+e.getMessage());
        }
    }

    private VotingProcess getVotingProcess()
            throws Exception
    {
        String ksPath = jTextFieldKSPath.getText();
        char [] ksPass = jPasswordFieldKSPass.getPassword();
        return new VotingProcess(ksPath, ksPass);
    }

    private Voter getVoter()
            throws Exception
    {
        String firstName = jTextFieldPrenume.getText();
        String lastName = jTextFieldNume.getText();
        String cnp = jTextFieldCNP.getText();
        if( firstName.equals("") )
            throw new Exception("Invalid first name");
        if( lastName.equals("") )
             throw new Exception("Invalid last name");
        if( cnp.length() != 13 )
            throw new Exception("Invalid CNP");
        return new Voter(firstName, lastName, cnp);
    }

    private Ballot getBallot()
            throws Exception
    {
        int i = jListCandidates.getSelectedIndex();
        if( i < 0 )
            throw new Exception("Please select a candidate, or Romania will burn.");
        return new Ballot(i+1);
    }

    private void readCandidatesFromDB() {
        DataBaseConector dbc = new DataBaseConector();
        Connection conn =  dbc.getDatabaseConection("jdbc:mysql://localhost:3306/mysql", "root", "");
        Statement stmt;
        ResultSet rs;
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT VOTE_OPTION_ID , CANDIDATE , ORGANIZATION FROM evote.voting_options");
            
            while (rs.next()) {
                candidates.add(new Candidate(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            
        } catch (SQLException e) {
            vLogger.error("Error getting the connection to the database for extracting the candidates"+e.getMessage());
        }
    }

    private List<String> getCandidates() {
        ArrayList<String> result = new ArrayList<String>();
        for(Candidate e : candidates)
            result.add(e.toString());
        return result;
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        MyLogger.initLogging("VotingLogger", "voting.log");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VotingGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVote;
    private javax.swing.JLabel jLabelCNP;
    private javax.swing.JLabel jLabelKSPass;
    private javax.swing.JLabel jLabelKSPath;
    private javax.swing.JLabel jLabelNume;
    private javax.swing.JLabel jLabelPrenume;
    private javax.swing.JList jListCandidates;
    private javax.swing.JPanel jPanelAuthentication;
    private javax.swing.JPasswordField jPasswordFieldKSPass;
    private javax.swing.JScrollPane jScrollPaneList;
    private javax.swing.JTextField jTextFieldCNP;
    private javax.swing.JTextField jTextFieldKSPath;
    private javax.swing.JTextField jTextFieldNume;
    private javax.swing.JTextField jTextFieldPrenume;
    // End of variables declaration//GEN-END:variables

}
