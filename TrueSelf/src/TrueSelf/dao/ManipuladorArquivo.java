package TrueSelf.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorArquivo {

	public void gravarArquivo(List<? extends Serializable> dados, String patchFile) {
		try {
			// cria o arquivo que sera atualizado
			FileOutputStream file = new FileOutputStream(patchFile);
			// cria um manipulador de arquivo
			ObjectOutputStream out = new ObjectOutputStream(file);
			// escreve os objetos dentro do arquivo
			out.writeObject(dados);
			// fecha o manipulador de arquivo
			out.close();
			// fecha o arquivo
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public <T extends Serializable> List<T> recuperar(String pathFile) {
		List<T> retorno = new ArrayList<>();
		try {
			//Cria ou encontra arquivo
			FileInputStream file = new FileInputStream(pathFile);
			//Manipulador de arquivo
			ObjectInputStream ois = new ObjectInputStream(file);
			//Recupera do arquivos os objetos serializados.
			retorno = (List) ois.readObject();
			ois.close();
			file.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		return retorno;
	}
}
