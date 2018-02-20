package br.com.stream;

/**
 * Implementação da interface Stream com os metodos hasNext e getNext
 * @author : Ana Paula anapaulasilva1000@gmail.com
 */
public class StreamImpl implements Stream {

    private String entrada;

    private int indexAtual = -1;

    public StreamImpl(String entrada) {
        if(entrada != null) {
            this.entrada = entrada;
        }else{
            this.entrada = "";
        }
    }

    public char getNext() {
        indexAtual++;
        return entrada.charAt(indexAtual);
    }

    public boolean hasNext() {
        try {
            entrada.charAt(indexAtual +1);
            return true;
        }catch (IndexOutOfBoundsException ex){
        }
        return false;
    }
}
