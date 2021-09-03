import java.io.File;
import java.io.IOException;

public class OrganizadorV1 {
	public static void main(String [] args) {
		final String DOCUMENTOS [] = {".txt",".doc",".docx", ".docm", ".odt", ".pdf", ".rtf", ".csv", ".xls", ".xlsx", ".xlsm", ".ods", ".pps", ".ppt", ".ppsx", ".pptx", ".ppsm", ".pptm", ".potx", ".odp"};
		final String AUDIO [] = {".mp3", ".wma", ".wav", ".flac", ".midi", ".ogg"};
		final String VIDEO [] = {".avi", ".divx", ".mov", ".mp4", ".mpg", ".mkv", ".wmv", ".wpl"};
		final String IMAGEN [] = {".jpeg", ".jpg", ".png", ".bmp", ".ico", ".svg", ".webp", ".gif", ".psd", ".heic"};
		
    //Cambiar direccion con la direccion de su PC a la carpeta que desea organizar los archivos
		File direccion = new File("/home/human/Descargas");
		
		//Obtenemos los archivos que hay en esa ruta
		String archivos [] = direccion.list();
		
		//creamos una carpeta en donde guardar estos archivos
		File direcDocumentos = new File("/home/human/Descargas/Documentos/"); //cambiar direccion con la de su pc
		if(direcDocumentos.mkdir()) {
			System.out.println("Carpeta Creada Documentos");
		}
		else System.out.println("Esta Carpeta ya existe");
		
		//Preguntamos si existen archivos con esas extensiones
		for(String archivo : archivos) {
			for(String tipo : DOCUMENTOS) {
				if(archivo.endsWith(tipo)) {
					//Si termina asi entonces lo move,os a la carpeta documentos
					boolean proceso = new File(direccion.getPath()+"/"+archivo).renameTo(new File(direcDocumentos, new File(direccion.getPath()+"/"+archivo).getName()));
					if(proceso) System.out.println("Movido exitosamente");
					else System.out.println("Error al mover");
				}
			}
		}
		
		
		//Carpeta audio
		File direcAudio = new File("/home/human/Descargas/Audio/"); //cambiar direccion con la de su pc
		if(direcAudio.mkdir()) {
			System.out.println("Carpeta Audio creada");
		}
		else System.out.println("Carpeta Audio ya existe!!!");
		//Preguntamos si existen archivos con esas extensiones
		for(String archivo : archivos) {
			for(String tipo : AUDIO) {
				if(archivo.endsWith(tipo)) {
					//Si termina asi entonces lo move,os a la carpeta documentos
					boolean proceso = new File(direccion.getPath()+"/"+archivo).renameTo(new File(direcAudio, new File(direccion.getPath()+"/"+archivo).getName()));
					if(proceso) System.out.println("Movido exitosamente");
					else System.out.println("Error al mover");
				}
			}
		}
		
		//Carpeta video
		File direcVideo = new File("/home/human/Descargas/Videos/"); //cambiar direccion con la de su pc
		if(direcVideo.mkdir()) {
			System.out.println("Carpeta Video creada");
		}
		else System.out.println("Carpeta Video ya existe!!!");
		//Preguntamos si existen archivos con esas extensiones
		for(String archivo : archivos) {
			for(String tipo : VIDEO) {
				if(archivo.endsWith(tipo)) {
					//Si termina asi entonces lo move,os a la carpeta documentos
					boolean proceso = new File(direccion.getPath()+"/"+archivo).renameTo(new File(direcVideo, new File(direccion.getPath()+"/"+archivo).getName()));
					if(proceso) System.out.println("Movido exitosamente");
					else System.out.println("Error al mover");
				}
			}
		}
		
		//Carpeta imagen
		File direcImagen = new File("/home/human/Descargas/Imagenes/"); //cambiar direccion con la de su pc
		if(direcImagen.mkdir()) {
			System.out.println("Carpeta Imagenes creada");
		}
		else System.out.println("Carpeta Imagenes ya existe!!!");
		//Preguntamos si existen archivos con esas extensiones
		for(String archivo : archivos) {
			for(String tipo : IMAGEN) {
				if(archivo.endsWith(tipo)) {
					//Si termina asi entonces lo move,os a la carpeta documentos
					boolean proceso = new File(direccion.getPath()+"/"+archivo).renameTo(new File(direcImagen, new File(direccion.getPath()+"/"+archivo).getName()));
					if(proceso) System.out.println("Movido exitosamente");
					else System.out.println("Error al mover");
				}
			}
		}
		
	}

}
