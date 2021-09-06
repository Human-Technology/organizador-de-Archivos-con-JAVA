package organizadorV2;
/**
 * 
 * José Sánchez - Human
 * 
 */
import javax.swing.JOptionPane;

public class Inicial {
	public static void main(String [] args) {
		
		//Utilizamos JOptionPane para solicitar una direccion de la carpeta en donde queremos organizar archivos
		String direccion = JOptionPane.showInputDialog("Ingrese La direccion de la carpeta\n"
				+ "de donde desee organizar sus archivos\n"
				+ "Como la carpeta de descargas.\n"
				+ "Ejemplo: /home/human/Descargas/");
		
		//Instanciamos la clase organizador para utilizar los metodos
		Organizador organizador = new Organizador(direccion);
		
		int errores=0;
		
		//Menu de opciones
		int opc = Integer.parseInt(
		JOptionPane.showInputDialog("\tMenu\n"
				+ "1.- Organizar Automaticamente.\n"
				+ "2.- Organizar Solo Documentos.\n"
				+ "3.- Organizar Solo Audios.\n"
				+ "4.- Organizar Solo Videos.\n"
				+ "5.- Organizar Solo Imaganes.\n"
				+ "6.- Salir."));
		
		//Proceso de cada opcion
		switch(opc) {
		case 1:
			organizador.auto();
			JOptionPane.showMessageDialog(null, "Archivos Organizados");
			break;
		case 2:
			errores = organizador.organizaDoc();
			JOptionPane.showMessageDialog(null, "Se organizaron Archivos con " + errores + " Errores.");
			break;
		case 3:
			errores = organizador.organizaAudio();
			JOptionPane.showMessageDialog(null, "Se organizaron Archivos con " + errores + " Errores.");
			break;			
		case 4:
			errores = organizador.organizaVideo();
			JOptionPane.showMessageDialog(null, "Se organizaron Archivos con " + errores + " Errores.");
			break;
		case 5:
			errores = organizador.organizaImagen();
			JOptionPane.showMessageDialog(null, "Se organizaron Archivos con " + errores + " Errores.");
			break;		
		case 6:
			JOptionPane.showMessageDialog(null, "Hasta Pronto. :D");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Ingrese una opcion valida!!!");
		}
		
		
		
		
	}
}
