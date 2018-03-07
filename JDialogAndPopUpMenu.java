import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class JDialogAndPopUpMenu extends JFrame implements ActionListener{

	
	String getString;
	
	JButton optionPaneMessage;
	JButton optionPaneInput;
	
	JButton modalDialog;
	JButton nonModalDialog;
	
	JPopupMenu popupMenu;
	
	JDialog jd;
	JDialog jdnm;
	
	
	JDialogAndPopUpMenu(){
		setSize(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		setLayout(new GridLayout(5,1));
		
		optionPaneMessage = new JButton("optionPaneMessage");
		optionPaneInput = new JButton("optionPaneInput");
		modalDialog = new JButton("modalDialog");
		nonModalDialog = new JButton("nonModalDialog");
		
		optionPaneMessage.addActionListener(this);
		optionPaneInput.addActionListener(this);
		modalDialog.addActionListener(this);
		nonModalDialog.addActionListener(this);
		
	
		add(optionPaneMessage);
		add(optionPaneInput);
		add(modalDialog);
		add(nonModalDialog);

		popupMenu = new JPopupMenu();
		
		JMenu moreOptions = new JMenu("MoreOptions");
		moreOptions.setMnemonic('M');
		JMenuItem help = new JMenuItem("Help", 'H');
		JMenuItem close = new JMenuItem("Close", 'C');
		
		JMenuItem option1 = new JMenuItem("option1");
		JMenuItem option2 = new JMenuItem("option2");
		
		moreOptions.add(option1);
		moreOptions.add(option2);
		
		popupMenu.add(help);
		popupMenu.addSeparator();
		popupMenu.add(close);
		popupMenu.add(moreOptions);
		
		
		addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me){
				if(me.isPopupTrigger()){
					popupMenu.show(me.getComponent(), me.getX(), me.getY());
				}
			}
		});
		
		jd = new JDialog(this, "modal", true);
		jd.setSize(300, 300);
		jd.setLocationRelativeTo(null);
		//jd.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		
		jdnm = new JDialog(this, "nonModal", false);
		jdnm.setSize(300, 300);
		
		
		
		
		
		setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getActionCommand().equals("optionPaneMessage")){
			JOptionPane.showMessageDialog(this, "this is my message", "MyTitle", JOptionPane.ERROR_MESSAGE);
		}
		
		if(ae.getActionCommand().equals("optionPaneInput")){
			getString = JOptionPane.showInputDialog(this, "here is my input");
			
		}
		
		if(ae.getActionCommand().equals("modalDialog")){
			jd.show();
		}
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(() ->
		new JDialogAndPopUpMenu());
	}
	
}
