import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JList;
import javax.swing.border.TitledBorder;


public class Deger {

	private JFrame frame;
	JList list;
	DefaultListModel listModel= new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deger window = new Deger();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Deger() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try
	    {
	      BufferedReader girisAkimi =
	      new BufferedReader(new FileReader("ornek.txt"));
	      String satir1,satir = null;
	      int m1,m2,fina;
	      int sayac = 0;
	      satir = girisAkimi.readLine( );
	      while (satir != null)
	      {
	        sayac++;
	        StringTokenizer wordFinder = new StringTokenizer(satir, " \n.,\t");
	    
	       satir1=wordFinder.nextToken();
	       m1=Integer.parseInt(wordFinder.nextToken());
	       m2=Integer.parseInt(wordFinder.nextToken());
	       fina=Integer.parseInt(wordFinder.nextToken());
	       satir=satir+" "+(m1+m2+fina)/3;
	    

	        listModel.addElement(satir);
	        satir = girisAkimi.readLine( );
	      }
	      girisAkimi.close( );
	    }
	    catch(FileNotFoundException e)
	    {
	      System.out.print("ornek.txt dosyasi bulunamadi");
	      System.out.println("veya acilamadi.");
	    }
	    catch(IOException e)
	    {
	      System.out.print("ornek.txt dosyasindan veri girisinde");
	      System.out.println(" hata olustu.");
	    }

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		list = new JList(listModel);
		list.setBorder(new TitledBorder(null, "Ornek", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(list);
	}

}
