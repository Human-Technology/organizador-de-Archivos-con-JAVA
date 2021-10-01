package organizadorV3;

/**
 * 
 * José Sánchez - Human
 * 
 */
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class Interfaz extends JFrame{

	public Interfaz() {
		setTitle("Organizador - Human Technolgy");
		
		setBounds(300, 300, 400, 500);
	
		Lamina lamina = new Lamina();
		add(lamina);
	}
	
}

class Lamina extends JPanel{
	JTextField jText = new JTextField();
	JRadioButton opc1 = new JRadioButton("Organizar Automaticamente");
	JRadioButton opc2 = new JRadioButton("Organizar Documentos");
	JRadioButton opc3 = new JRadioButton("Organizar Audios");
	JRadioButton opc4 = new JRadioButton("Organizar Videos");
	JRadioButton opc5 = new JRadioButton("Organizar Imagenes");
	JButton btn = new JButton("Organizar");
	
	public Lamina(){
		setLayout(null);

		jText.setBounds(30, 70, 200, 20);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(opc1);
		bg.add(opc2);
		bg.add(opc3);
		bg.add(opc4);
		bg.add(opc5);

		opc1.setBounds(30, 90, 250, 30);
		opc2.setBounds(30, 120, 250, 30);
		opc3.setBounds(30, 150, 250, 30);
		opc4.setBounds(30, 180, 250, 30);
		opc5.setBounds(30, 210, 250, 30);
		btn.setBounds(50, 260, 200, 30);
		
		add(jText);
		add(opc1);
		add(opc2);
		add(opc3);
		add(opc4);
		add(opc5);
		add(btn);
		
		jText.requestFocus();
		
		btn.addActionListener(new escuchadorBtn());
		
		jText.addFocusListener(new EscuchadorFoco());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		Font letra = new Font("Arial", Font.BOLD, 20);
		
		g2.setFont(letra);
		g2.drawString("Organizador", 100, 30);
		
		g2.setFont(new Font("Arial", Font.BOLD, 15));
		g2.drawString("Ingrese Directorio:", 30, 60);
	}
	
	//Clase interna que implementa la interfaz
	//escuchador de acciones del boton
	private class escuchadorBtn implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String directorio = jText.getText();
			
			Organizador organizador = new Organizador(directorio);
			
			if(opc1.isSelected()) {
				organizador.auto();
				JOptionPane.showMessageDialog(null, "Organizacion Automatica Finalizada.");
			}
			else if(opc2.isSelected()) {
				organizador.organizaDoc();
				JOptionPane.showMessageDialog(null, "Organizacion de Documentos Finalizada.");
			}
			else if(opc3.isSelected()) {
				organizador.organizaAudio();
				JOptionPane.showMessageDialog(null, "Organizacion de Audios Finalizada.");
			}
			else if(opc4.isSelected()) {
				organizador.organizaVideo();
				JOptionPane.showMessageDialog(null, "Organizacion de Videos Finalizada.");
			}
			else if(opc5.isSelected()) {
				JOptionPane.showMessageDialog(null,  "Organiacion de Imagenes Finalizada.");
			}
			else JOptionPane.showMessageDialog(null, "Seleccione una Opcion!!!");;
		}
		
	}
	
	private class EscuchadorFoco implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			//Si el cuadro de texto pierde el foco y no tiene una direccion envia mensaje
			if(e.getSource() == jText) {
				if(jText.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "La direccion no puede quedar Vacia!!!");
					jText.requestFocus();
					
				}
			}
		}
		
	}
	
	
}
