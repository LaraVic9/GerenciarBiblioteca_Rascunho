package models;

import java.time.LocalDate;

public class Cadastro extends Object {
	
	private String nome;
	private String  idioma;
	private String[] habilidades;
	private LocalDate dataNasc;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		
		if(nome == null || nome.equals("") || nome.startsWith(" ") || nome.matches("[0-9]")) {
			throw new IllegalArgumentException("O nome não está nulo ou adequado... Tente novamente");
		}
		
		this.nome = nome;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String[] getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String[] habilidades) {
		
		if (habilidades == null || habilidades.length == 0) {
			throw new IllegalArgumentException("Habilidades não informadas... Tente novamente");
		}
		
		this.habilidades = habilidades;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String data) {
		
		LocalDate dataNasc = null;
		
		try {
			
			dataNasc = this.dateStringToLocalDate(data);
		
		} catch (Exception e) {
			throw new IllegalArgumentException("Data não informada ou formato incorreto... Tente novamente");
		}
		
		if(	
				dataNasc == null || 
				dataNasc.equals(LocalDate.now()) || 
				dataNasc.isAfter(LocalDate.now())
		) {
			throw new IllegalArgumentException("data incorreta");
		}
		
		this.dataNasc = dataNasc;
	}
	
	public LocalDate dateStringToLocalDate(String data) {
		
		LocalDate localDate = LocalDate.parse(data);
		
		return localDate;
	}
	
	
	
	

}
