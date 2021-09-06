package organizadorV2;
/**
 * 
 * José Sánchez - Human
 * 
 */
import java.io.File;

public class Organizador {
	
	//Metodo Constructor 
	public Organizador(String dir) { //Recibe por parametro una direccion de la carpeta a organizar
		carpetaDir = new File(dir); // le asignamos al objeto la direccion
		listArchivos = carpetaDir.list(); //obtenemos una lista de los archivos que hay en esa direccion
		for(int i=0; i<CARPETAS.length; i++) {
			carpetasDir[i] = new File(carpetaDir.getPath()+"/"+CARPETAS[i]); //le asignamos una direccion con los
																			// nombre de las carpetas a crear
		}
	}
	
	//Metodo para extraer la lista de los archivos existentes
	public String [] getLista() {
		return carpetaDir.list();
	}
	
	//Metodo para organizar todo automaticamente
	public void auto(){	
		for(int i=0; i<CARPETAS.length; i++) {
			//carpetasDir[i] = new File(carpetaDir.getPath()+"/"+CARPETAS[i]);
			carpetasDir[i].mkdir(); //Creamos las carpetas que estan en esa direccion
									//si ya existen no las crea
		}
		
		//Utilizamos el metodo mueveArchivos para mover los archivos que sean de cada tipo a cada carpeta que le corresponda
		mueveArchivos(listArchivos, DOCUMENTOS, carpetasDir[0].getPath());
		mueveArchivos(listArchivos, AUDIO, carpetasDir[1].getPath());
		mueveArchivos(listArchivos, VIDEO, carpetasDir[2].getPath());
		mueveArchivos(listArchivos, IMAGEN, carpetasDir[3].getPath());
		
	}
	
	//Metodo que organiza unicamente archivos de tipo DOcumentos
	public int organizaDoc() {
		int errores = mueveArchivos(listArchivos, DOCUMENTOS, carpetasDir[0].getPath());
		return errores;//Retorna la cantidad de errores que hubo al mover algun archivo
	}
	
	//Metodo que solo organiza archivos de tipo audio
	public int organizaAudio() {
		int errores = mueveArchivos(listArchivos, AUDIO, carpetasDir[1].getPath());
		return errores;
	}
	
	//Metodo que solo organiza archivos de tipo Video
	public int organizaVideo() {
		int errores = mueveArchivos(listArchivos, VIDEO, carpetasDir[2].getPath());
		return errores;
	}
	
	//Metodo que solo organiza archivos de tipo Imagen
	public int organizaImagen() {
		int errores = mueveArchivos(listArchivos, IMAGEN, carpetasDir[3].getPath());
		return errores;
	}
	
	//Metodo privado que nos ayuda a mover archivos a una carpeta
	//recibe por parametro:
	//	- Una lista de archivos
	//	- Una lista de extension de archivos pueden ser de tipo Documentos, video, etc.
	// 	- Un String con la direccion de la carpeta a donde se moveran los archivos
	//
	// Este metodo toma la lista de archivos que eisten en la carpeta indicada, compara si en esa lis
	//	existen archivos con el tipo de extension indicadas(Documentos, IMgen, etc) y si algun archivo cuenta
	//	con este tipo de extension lo mueve a la direccion que se le indico po parametro
	// 	retorna la cantidad de errores si es que hay alguno al mover un archivo.
	private int mueveArchivos(String list [], String tiposExtension [], String dirMover) {
		int errores= 0;
		for(String archivo : list) {
			for(String tipo : tiposExtension) {
				if(archivo.endsWith(tipo)) {
					boolean proceso = new File(carpetaDir.getPath()+"/"+archivo).renameTo(new File(dirMover, new File(carpetaDir.getPath()+"/"+archivo).getName()));
					if(!proceso) errores++;
				}
			}
		}
		return errores;
	}
	
	// Constantes y Instancias necesarias
	private final String DOCUMENTOS [] = {".txt",".doc",".docx", ".docm", ".odt", ".pdf", ".rtf", ".csv", ".xls", ".xlsx", ".xlsm", ".ods", ".pps", ".ppt", ".ppsx", ".pptx", ".ppsm", ".pptm", ".potx", ".odp"};
	private final String AUDIO [] = {".mp3", ".wma", ".wav", ".flac", ".midi", ".ogg"};
	private final String VIDEO [] = {".avi", ".divx", ".mov", ".mp4", ".mpg", ".mkv", ".wmv", ".wpl"};
	private final String IMAGEN [] = {".jpeg", ".jpg", ".png", ".bmp", ".ico", ".svg", ".webp", ".gif", ".psd", ".heic"};
	private final String CARPETAS[] = {"Documentos", "Audios", "Videos", "Imagenes"};
	private String [] listArchivos;
	private File carpetaDir;
	private File [] carpetasDir = new File[CARPETAS.length];
}
