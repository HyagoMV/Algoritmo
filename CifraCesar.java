public class CifraCesar {

	private final char[] cifrado = new char[26];
	private final char[] decifrado = new char[26];
	
	public CifraCesar() {
		for (int i = 0; i < 26; i++) {
			cifrado[(65 + i + 10) % 26] = (char) (65 + i);
			decifrado[(65 + i - 10) % 26] =  (char) (65 + i);
		}
	}	
	
	public String cifra(String textoLimpo) {
		char[] chars = textoLimpo.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (Character.isAlphabetic(chars[i]))
				chars[i] = cifrado[(chars[i] - 13) % 26];
		}
		return new String(chars);
	}
	
	public String decifra(String textoCifrado) {
		char[] chars = textoCifrado.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (Character.isAlphabetic(chars[i]))
				chars[i] = decifrado[(chars[i] + 13) % 26];
		}
		return new String(chars);
	}
	
	public static void main(String[] args) {
		CifraCesar cifraCesar = new CifraCesar();
		String cifrado = cifraCesar.cifra("THE EAGLE IS IN PLAY; MEET AT JOE'S");
		System.out.println(cifrado);
		String decifrado = cifraCesar.decifra(cifrado);
		System.out.println(decifrado);
	}

}
