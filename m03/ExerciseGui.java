package m03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
/**
 * Creates a window that has two buttons on top with an image of a ball on a white background.
 * The background can be altered between white and beige until the ball is exploded.
 * Then the image and background stay the same.
 * @author Brady
 *
 */
public class ExerciseGui extends JFrame {

	private JPanel contentPane;
	private JPanel ballPanel;
	private JButton btnToggle;
	private JLabel lblBall = new JLabel("");
	private boolean exploded = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExerciseGui frame = new ExerciseGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExerciseGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(193, 175, 162));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel controlPanel = createControlPanel();
		contentPane.add(controlPanel, BorderLayout.NORTH);
		
		JPanel ballPanel = createBallPanel();
		contentPane.add(ballPanel, BorderLayout.CENTER);
	}
	/**
	 * Creates the panel that the ball will be in.
	 * @return
	 */
	private JPanel createBallPanel() {
		ballPanel = new JPanel();
		ballPanel.setBackground(Color.WHITE);
		lblBall.setBorder(new EmptyBorder(100, 0, 0, 0));
		lblBall.setIcon(new ImageIcon(ExerciseGui.class.getResource("/m03/Images/ball.png")));
		ballPanel.add(lblBall);
		return ballPanel;
	}
	/**
	 * Creates the panels that the buttons will be in.
	 * @return
	 */
	private JPanel createControlPanel() {
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		controlPanel.setBackground(new Color(193, 175, 162));
		
		//Toggle button
		btnToggle = new JButton("Toggle");
		btnToggle.setForeground(Color.WHITE);
		btnToggle.setBackground(new Color(99, 76, 59));
		btnToggle.addActionListener(new ActionListener() {
			private int toggleCount;

			public void actionPerformed(ActionEvent e) {
				if(exploded) {
					btnToggle.removeActionListener(null);
				}
				else {
					changeBallBackground();
				}
			}

			private void changeBallBackground() {
				toggleCount = (toggleCount + 1) % 2;
				if(toggleCount == 1) {
					ballPanel.setBackground(new Color(233,225,212));
				}
				else {
					ballPanel.setBackground(Color.WHITE);
				}
			}
		});
		controlPanel.setLayout(new GridLayout(0, 2, 10, 10));
		btnToggle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		controlPanel.add(btnToggle);
		
		//Explode button
		JButton btnExplode = new JButton("Explode");
		btnExplode.setForeground(Color.WHITE);
		btnExplode.setBackground(new Color(99, 76, 59));
		btnExplode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exploded = true;
				lblBall.setIcon(new ImageIcon(ExerciseGui.class.getResource("/m03/Images/explosion.png")));
			}
		});
		btnExplode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		controlPanel.add(btnExplode);
		return controlPanel;
	}
}
