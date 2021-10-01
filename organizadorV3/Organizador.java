package organizadorV3;
/**
 * 
 * José Sánchez - Human
 * 
 */
import java.io.File;

public class Organizador {
	public Organizador(String dir) {
		carpetaDir = new File(dir);
		listArchivos = carpetaDir.list();
		for(int i=0; i<CARPETAS.length; i++) {
			carpetasDir[i] = new File(carpetaDir.getPath()+"/"+CARPETAS[i]);
		}
	}
	
	public String [] getLista() {
		return carpetaDir.list();
	}
	
	public void auto(){	
		for(int i=0; i<CARPETAS.length; i++) {
			carpetasDir[i].mkdir();
		}
		
		mueveArchivos(listArchivos, DOCUMENTOS, carpetasDir[0].getPath());
		mueveArchivos(listArchivos, AUDIO, carpetasDir[1].getPath());
		mueveArchivos(listArchivos, VIDEO, carpetasDir[2].getPath());
		mueveArchivos(listArchivos, IMAGEN, carpetasDir[3].getPath());
		
	}
	
	public int organizaDoc() {
		int errores = mueveArchivos(listArchivos, DOCUMENTOS, carpetasDir[0].getPath());
		return errores;
	}
	
	public int organizaAudio() {
		int errores = mueveArchivos(listArchivos, AUDIO, carpetasDir[1].getPath());
		return errores;
	}
	
	public int organizaVideo() {
		int errores = mueveArchivos(listArchivos, VIDEO, carpetasDir[2].getPath());
		return errores;
	}
	
	public int organizaImagen() {
		int errores = mueveArchivos(listArchivos, IMAGEN, carpetasDir[3].getPath());
		return errores;
	}
	
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
	
	private final String DOCUMENTOS [] = {".txt",".doc",".docx", ".docm", ".odt", ".pdf", ".rtf", ".csv", ".xls", ".xlsx", ".xlsm", ".ods", ".pps", ".ppt", ".ppsx", ".pptx", ".ppsm", ".pptm", ".potx", ".odp"};
	private final String AUDIO [] = {".mp3", ".wma", ".wav", ".flac", ".midi", ".ogg"};
	private final String VIDEO [] = {".avi", ".divx", ".mov", ".mp4", ".mpg", ".mkv", ".wmv", ".wpl"};
	private final String IMAGEN [] = {".jpeg", ".jpg", ".png", ".bmp", ".ico", ".svg", ".webp", ".gif", ".psd", ".heic"};
	private final String CARPETAS[] = {"Documentos", "Audios", "Videos", "Imagenes"};
	private String [] listArchivos;
	private File carpetaDir;
	private File [] carpetasDir = new File[CARPETAS.length];
}
