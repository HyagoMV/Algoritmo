
public class ListSimplementeEncadeada {

	public static void main(String[] args) {
		ListSimplementeEncadeada lista = new ListSimplementeEncadeada();
		lista.adiciona(new No("A", null));
		lista.adiciona(new No("B", null));
		lista.adiciona(new No("C", null));
		lista.remove();
		lista.remove();
		lista.remove();
	}

	private No cabeca;
	private int tamanho;

	public No getCabeca() {
		return cabeca;
	}
	
	public void remove() {
		No tmp = cabeca.getProximo();
		cabeca.setProximo(null);
		cabeca = tmp;
	}

	public void adiciona(No no) {
		if (no == null)
			throw new IllegalArgumentException();

		if (cabeca == null) {
			cabeca = no;
		
		} else {
			No proximo = cabeca.getProximo();
			if (proximo == null) {
				cabeca.setProximo(no);
			} else {
				while (proximo.getProximo() != null) {
						proximo = proximo.getProximo();
					}
				proximo.setProximo(no);
				}
				
			}
		
		tamanho++;
	}

	public int getTamanho() {
		return tamanho;
	}

	static class No {
		private String elemento;
		private No proximo;

		public No(String elemento, No proximo) {
			this.elemento = elemento;
			this.proximo = proximo;
		}

		public No getProximo() {
			return proximo;
		}

		public void setProximo(No proximo) {
			this.proximo = proximo;
		}

	}

}
