public class JogoVelha {

	private final int x = 1;
	private final int o = -1;

	private final int[][] tabuleiro = new int[3][3];

	private int jogadorAtual;

	public JogoVelha() {
		jogadorAtual = x;
	}

	public void joga(int linha, int coluna) {
		if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2)
			throw new IllegalArgumentException();
		if (tabuleiro[linha][coluna] != 0)
			throw new IllegalArgumentException();
		tabuleiro[linha][coluna] = jogadorAtual;
		jogadorAtual = -jogadorAtual;
	}

	private boolean verificaVitoria(int jogador) {
		return (tabuleiro[0][0] + tabuleiro[0][1] + tabuleiro[0][2]) == jogador * 3
				|| (tabuleiro[1][0] + tabuleiro[1][1] + tabuleiro[1][2]) == jogador * 3
				|| (tabuleiro[2][0] + tabuleiro[2][1] + tabuleiro[2][2]) == jogador * 3
				|| (tabuleiro[0][0] + tabuleiro[1][0] + tabuleiro[2][0]) == jogador * 3
				|| (tabuleiro[0][1] + tabuleiro[1][1] + tabuleiro[2][1]) == jogador * 3
				|| (tabuleiro[0][2] + tabuleiro[1][2] + tabuleiro[2][2]) == jogador * 3
				|| (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == jogador * 3
				|| (tabuleiro[2][0] + tabuleiro[1][1] + tabuleiro[0][2]) == jogador * 3;
	}

	public int verificaGanhador() {
		if (verificaVitoria(x))
			return x;
		if (verificaVitoria(o))
			return o;
		return 0;
	}

	@Override
	public String toString() {
		String s = "";
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				s += tabuleiro[l][c];
				if (c < 2)
					s += "|";
			}
			s += "\n";
		}
		return s;
	}

	public static void main(String[] args) {
		JogoVelha jogoVelha = new JogoVelha();
		
		System.out.println(jogoVelha);
		
		jogoVelha.joga(0, 0); // X
		System.out.println(jogoVelha);
		
		jogoVelha.joga(0, 1); // O
		System.out.println(jogoVelha);
		
		jogoVelha.joga(1, 1); // X
		System.out.println(jogoVelha);
		
		jogoVelha.joga(1, 2); // O
		System.out.println(jogoVelha);
		
		jogoVelha.joga(2, 2); // X
		System.out.println(jogoVelha);
	
		System.out.println(jogoVelha.verificaGanhador());

	}

}
