package BMIfrom;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setAlwaysOnTop(true);
		setTitle("BMI calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 550);
		setLocationRelativeTo(null);
		getContentPane().add(new BMI());
		
	}

}
