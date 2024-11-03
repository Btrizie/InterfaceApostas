import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Apostar {
    //inicializa uma classe Apostar geral para ser usada ao longo de todo projeto
    public static Apostar apostar = new Apostar();

    public static final int TAM = 10;
    private int count, countResultado;
    private ArrayList<Integer> resultado;
    private boolean ganhou;
    private Random r = new Random();
	private List<NovaAposta> listaApostas;

    //inicializa a classe gerando 10 apostas randomicas + uma especial (gerada a mão)
	public Apostar() {
		listaApostas = new ArrayList<>(TAM);
        resultado = new ArrayList<Integer>();
        count = 1000;
        ganhou = false;

		for (int i = 0; i < TAM; i++) {
			String nome = "Fulano" + i;
            String cpfRandom = String.valueOf(123456789 + r.nextInt(30)) + "-" + r.nextInt(10,99);
			NovaAposta a = new NovaAposta(nome, cpfRandom, r.nextInt(1, 50), r.nextInt(1,50), 
            r.nextInt(1, 50), r.nextInt(1, 50), r.nextInt(1, 50), count);
			listaApostas.add(a);
            count++;
		}
		listaApostas.add(new NovaAposta("Fulano especial", "123456789-10" , 3, 9, 21, 30, 39, count));
        count++;
	}

    //adiciona à lista de apostas
    public void add(NovaAposta nv){
        listaApostas.add(nv);
        count++;
    }

    //retorna a lista de apostas atualizada
    public List<NovaAposta> getListaApostas() {
        return listaApostas;
    } 

    //realiza a comparação do resultado com todas as apostas feitas
	public void forEach() {
        for (NovaAposta f:listaApostas){
            int countAux = 0;
            int[] aux = f.getAposta();
            ArrayList<Integer> auxArray = new ArrayList<>();
            auxArray.add(aux[0]);
            auxArray.add(aux[1]);
            auxArray.add(aux[2]);
            auxArray.add(aux[3]);
            auxArray.add(aux[4]);
            for (int i = 0; i < 5; i++) {
                if(resultado.contains(auxArray.get(i))){
                    countAux++;
                }
            }
            //informa, caso haja um, o ganhador do sorteio (incompleto - fora da interface)
            if(countAux == 5){
                System.out.println("Ganhador: " + f.toString());
                ganhou = true;
            }
		} 
    }

    //retorna o proximo Identificador a ser usado em uma nova aposta
    public int getId(){
        return count;
    }

    //retorna quantos resultados foram gerados (max 25)
    public int getCountResultado(){
        return countResultado;
    }

    //gera um resultado randômico
    public String geraResultado(){
        if(countResultado == 0){
            resultado.add(r.nextInt(1,50));
            resultado.add(r.nextInt(1,50));
            resultado.add(r.nextInt(1,50));
            resultado.add(r.nextInt(1,50));
            resultado.add(r.nextInt(1,50));
        }
        else{
            resultado.add(r.nextInt(1,50));
        }
        countResultado++;
        forEach();
        
        return resultado.toString();
    }

    //retorna true caso haja um ganhador
    public boolean getGanhou(){
        return ganhou;
    }

	@Override
	public String toString() {
		final StringBuilder str = new StringBuilder();
		listaApostas.forEach(f->str.append(f.toString()+"\n"));
		return str.toString();
	}
}
