package br.com.stream;

import java.util.*;

/**
 * Retorna a primeira vogal não repetida 
 * @author : Ana Paula anapaulasilva1000@gmail.com
 */
public class PrimeiroCaracterNaoRepetido {

    private static final String VOGAIS = "aeiou";

    /**
     * @param stream
     * @return Optional<Character>
     */
    public static Optional<Character> encontraPrimeiraVogalNaoRepetida(Stream stream) {

        if(stream != null) {

            Set<Character> recorrente = new HashSet<Character>();
            List<Character> naoRecorrente = new ArrayList<Character>();

            while (stream.hasNext()) { 

                char letra = Character.toLowerCase(stream.getNext());  

                if (recorrente.contains(letra)) {
                    continue;
                }
                if (naoRecorrente.contains(letra)) {
                    naoRecorrente.remove((Character) letra);
                    recorrente.add(letra);
                } else {
                    if (isVogal(letra)) {
                        naoRecorrente.add(letra);
                    }
                }
            }
            try {
                return Optional.of(naoRecorrente.get(0));
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Nesse exemplo não tem nenhuma vogal repetida");
            }
        }
        return Optional.empty();
    }

    private static boolean isVogal(char letra) {
        return VOGAIS.indexOf(letra) >= 0;
    }
}
