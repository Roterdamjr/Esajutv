package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.CNVaraDao;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
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
	public FramePrincipal() {
		setTitle("SimulaJuris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Vara Trransferida");
		panel.add(lblNewLabel);
		
		/******* preenche combo da vara **********/
		JComboBox<String> cboVara = new JComboBox();
    	ArrayList<String> varas = new CNVaraDao().getVaras();
        
        for (String obj : varas) {
        	cboVara.addItem(obj);
        }
		panel.add(cboVara);
		/*****************************************/
		
		JLabel lblNewLabel_1 = new JLabel("Jurisdição Destino");
		panel.add(lblNewLabel_1);
		
		/******* preenche combo da Jurisdicao **********/
		JComboBox<String> cboJurisdicao = new JComboBox();
    	ArrayList<String> jurisdicoes = new CNVaraDao().getJurisdicoes();
        
        for (String obj : jurisdicoes) {
        	cboJurisdicao.addItem(obj);
        }
		/*****************************************/
		cboJurisdicao.setEditable(true);
		panel.add(cboJurisdicao);
		
		JButton btnSimular = new JButton("Simular");
		btnSimular.setForeground(new Color(0, 0, 255));
		btnSimular.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnSimular);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(1, 2, 0, 0));
		
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		panel_2.add(scrollPane_1);
		

		
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		JScrollPane scrollPane_2 = new JScrollPane(table_2);
		panel_2.add(scrollPane_2);
		
		
		
		
		


		


	}
	


}
