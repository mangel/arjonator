package ui;

import ui.exception.EmptyMessageException;
import arjonator.Arjonator;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author mangel
 */
public class ArjonatorWindowUI extends JFrame implements ActionListener {
    private JTextArea txtMessageBoard;
    private JButton btnSendMessage;
    private JTextField txtMessage;
    private JPanel pnlBottomPanel;
    private TitledBorder lblMessage;
    private JScrollPane pnlScroll;
    
    private Arjonator arjonator;
    
    public ArjonatorWindowUI(Arjonator arjonator)
    {
        this.setTitle("Arjonator 3000");
        this.arjonator = arjonator;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        initialize();
        addComponents();
        bindEvents();
        
        this.setSize(300, 400);
        this.setVisible(true);
        
        txtMessage.requestFocusInWindow();
    }
    
    private void initialize(){
        txtMessageBoard = new JTextArea();
        btnSendMessage  = new JButton("Enviar");
        txtMessage      = new JTextField();
        pnlBottomPanel  = new JPanel();
        lblMessage      = new TitledBorder("Enviar Mensaje:");
        pnlScroll       = new JScrollPane(txtMessageBoard);
        
        pnlBottomPanel.setBorder(lblMessage);
        
        pnlBottomPanel.setLayout(new BorderLayout());
        
        txtMessageBoard.setEditable(false);
        txtMessageBoard.setLineWrap(true);
        txtMessageBoard.setWrapStyleWord(true);
        txtMessageBoard.setAutoscrolls(true);
    }
    
    private void addComponents(){
        pnlBottomPanel.add(txtMessage, BorderLayout.CENTER);
        pnlBottomPanel.add(btnSendMessage, BorderLayout.LINE_END);
        
        this.add(pnlScroll, BorderLayout.CENTER);
        this.add(pnlBottomPanel, BorderLayout.PAGE_END);
    }
    
    private void bindEvents(){
        btnSendMessage.addActionListener(this);
        
        txtMessage.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == '\n'){
                    try {
                        sendMessage();
                    } catch (EmptyMessageException ex) {
                        handleException(ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
    }
    
    private void addText(String sender, String text){
        String currentText = this.txtMessageBoard.getText();
        
        this.txtMessageBoard.setText(currentText + "\n\n" + sender + " dice: " + text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            sendMessage();
        } catch (EmptyMessageException ex) {
            handleException(ex);
        }
    }
    
    private void sendMessage() throws EmptyMessageException{
        if (txtMessage.getText().isEmpty()){
            throw new EmptyMessageException();
        } else {
            addText("Usuario", txtMessage.getText());
            txtMessage.setText("");
            addText("Arjonator", arjonator.getRandomLine());
            txtMessage.requestFocusInWindow();
        }
    }
    
    private void handleException(Exception ex){
        if (ex != null){
            JOptionPane.showMessageDialog(new JPanel(),ex, ex.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
            txtMessage.requestFocusInWindow();
        }
    }
}
