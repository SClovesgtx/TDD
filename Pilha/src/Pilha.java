
public class Pilha {
	
	private Object[] elementos;
	private int quantidade = 0;
	
	public Pilha(int maximo) {
		// TODO Auto-generated constructor stub
		elementos = new Object[maximo];
	}

	public boolean esta_vazia() {
		// TODO Auto-generated method stub
		return (quantidade == 0);
	}

	public Integer tamanho() {
		// TODO Auto-generated method stub
		return this.quantidade;
	}

	public void empilha(Object elemento) {
		// TODO Auto-generated method stub
		this.elementos[quantidade] = elemento;
		this.quantidade++;
		
	}

	public Object topo() {
		// TODO Auto-generated method stub
		return this.elementos[quantidade-1];
	}

	public Object desempilha() {
		// TODO Auto-generated method stub
		if (esta_vazia()) {
			throw new PilhaVaziaException("Não é possível desempilhar.");
		}
		Object topo = this.topo();
		quantidade--;
		return topo;
	}

}
