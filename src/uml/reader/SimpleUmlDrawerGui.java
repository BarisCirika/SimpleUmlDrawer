package uml.reader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import uml.drawer.ClassObject;


public class SimpleUmlDrawerGui extends JFrame {

	private JTextField txtClassName;
	private JButton btnSelect;
	private ClassSpy classSpy;
    private JPanel panelNorth;
    
    private ClassObject classObj;
	
	public SimpleUmlDrawerGui() {
		classObj = new ClassObject(); 
		txtClassName = new JTextField(10);
		btnSelect = new JButton("Select Class");
		panelNorth = new JPanel();		
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBorder(new TitledBorder("Select"));
		panelNorth.add(txtClassName);
		panelNorth.add(btnSelect);
		
		classObj.setVisible(false);
		setLayout(new BorderLayout());
		add(classObj, BorderLayout.CENTER);
		
		add(panelNorth,BorderLayout.NORTH);
		//add(panelSouth,BorderLayout.SOUTH);
		
		setBackground(Color.white);
		setVisible(true);
		//setSize(getPreferredSize());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(400, 600);
		//pack();
		
		btnSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
               if(txtClassName.getText()!=""){
            	  ClassSpy classSpy = new ClassSpy(txtClassName.getText(),classObj);
            	  classObj.setVisible(true);
               }
			}
		});
	}
}
