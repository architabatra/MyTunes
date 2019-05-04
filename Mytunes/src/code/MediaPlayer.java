package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MediaPlayer extends JPanel implements ActionListener {

	JFrame window = new JFrame("A simple Interface");
	JLabel label = new JLabel("A Simple media player");
	JButton addButton = new JButton("ADD");
	JButton playButton = new JButton("PLAY");
	JButton stopButton = new JButton("STOP");
	Font customFont = new Font("",Font.BOLD,20);
	JComboBox list = new JComboBox();
	JFileChooser browser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV sounds","wav");
	int returnValue;
	String music[]= new String[10];
	int index=0;
	File selectedFile;
	File sound;
	AudioInputStream as;
	Clip clip;
	
	MediaPlayer()
	{ 
		this.setBackground(Color.WHITE);
		window.add(this);
		//BUTTONS
		addButton.setBackground(Color.BLACK);
		addButton.setForeground(Color.WHITE);
		addButton.setFont(customFont);
		addButton.addActionListener(this);
		
		playButton.setBackground(Color.BLACK);
		playButton.setForeground(Color.WHITE);
		playButton.setFont(customFont);
		playButton.addActionListener(this);
		
		stopButton.setBackground(Color.BLACK);
		stopButton.setForeground(Color.WHITE);
		stopButton.setFont(customFont);
		stopButton.addActionListener(this);
		
		//list.setFont(new Font("", Font.ITALIC , 20));
		list.setBackground(Color.BLACK);
		list.setForeground(Color.WHITE);
		window.add(list , BorderLayout.PAGE_START);
		
		browser.setFileFilter(filter);
		
		label.setFont(new Font("",Font.ITALIC,20));
		window.add(label , BorderLayout.PAGE_END);
		window.add(addButton , BorderLayout.LINE_START);
		window.add(playButton , BorderLayout.CENTER);
		window.add(stopButton , BorderLayout.LINE_END);
		window.setSize(400 , 200);
		window.setLocation(200, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
			
  
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==addButton)
		{
			returnValue=browser.showOpenDialog(window);
			if(returnValue==browser.APPROVE_OPTION) 
			{
				selectedFile=browser.getSelectedFile();
				music[index]=selectedFile.toString();
				//JOptionPane.showMessageDialog(null, selectedFile.toString());
				list.addItem("Song-"+index);
				index++;
				
			}
		}
		else if (ae.getSource()==playButton)
		{
			try
			{
				if(list.getSelectedIndex()==0)
				{
					sound= new File(music[list.getSelectedIndex()]);
					as=AudioSystem.getAudioInputStream(sound);
					clip=AudioSystem.getClip();
					clip.open(as);
					clip.start();
				}
				else if(list.getSelectedIndex()==1)
				{
					sound= new File(music[list.getSelectedIndex()]);
					as=AudioSystem.getAudioInputStream(sound);
					clip=AudioSystem.getClip();
					clip.open(as);
					clip.start();
				}
				else if(list.getSelectedIndex()==2)
				{
					sound= new File(music[list.getSelectedIndex()]);
					as=AudioSystem.getAudioInputStream(sound);
					clip=AudioSystem.getClip();
					clip.open(as);
					clip.start();
				}
				
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e);
			}
		}
		else if (ae.getSource()==stopButton)
		{
			clip.stop();
		}
		
	}

}
