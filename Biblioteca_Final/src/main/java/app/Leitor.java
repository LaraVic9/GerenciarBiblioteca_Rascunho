package app;

//import java.time.LocalDate;

public class Leitor {
	private int id;
	private String nome;
	private String sobrenome;
	//private LocalDate dataNasc;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		
		if(nome == null || nome.equals("") || nome.startsWith(" ") || nome.matches("[0-9]")) {
			throw new IllegalArgumentException("O nome não está nulo ou adequado... Tente novamente");
		}
		
		this.nome = nome;
	}

	
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenme(String sobrenome) {
		
		if(sobrenome == null || sobrenome.equals("") || sobrenome.startsWith(" ") || sobrenome.matches("[0-9]")) {
			throw new IllegalArgumentException("O nome não está nulo ou adequado... Tente novamente");
		}
		
		this.sobrenome = sobrenome;
	}
	
	/*public LocalDate getDataNasc() {
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
	}*/
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		
		if(email == null || email.equals("") || email.startsWith(" ") || email.matches("[0-9]")) {
			throw new IllegalArgumentException("O email não está nulo ou adequado... Tente novamente");
		}
		
		this.email = email;
	}
}
