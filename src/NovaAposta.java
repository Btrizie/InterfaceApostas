import java.util.Arrays;

public class NovaAposta {
	private String nome, cpf;
	private int[] aposta;
    private int id;

	//inicializa a classe
	public NovaAposta(String nome, String cpf, int n1, int n2, int n3, int n4, int n5, int id) {
		this.nome = nome;
		this.cpf = cpf;
		this.id = id;
        aposta = new int[]{n1, n2, n3, n4, n5};
		ordenaString();
	}

	//retona o nome do apostar
	public String getNome() {
		return nome;
	}

	//retorna o cpf do apostador
	public String getCPF(){
		return cpf;
	}

	//retorna a int[] aposta do apostador
	public int[] getAposta() {
		return aposta;
	}

	//retorna o id do apostador
	public int getId(){
        return id;
    }

	//ordena a int[] aposta
    public void ordenaString(){
        Arrays.sort(aposta, 0, 5);
    }

	@Override
	public String toString() {
		return "[Nome: " + nome + ", IdAposta: " + id + ", Aposta:" + Arrays.toString(aposta) + "]";
	}
}
