package br.com.stream;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeiroCaracterNaoRepetidoTest {

    @Test
    public void deveEncontrarOCaracterVogalNaoRepetido() throws Exception {
        Stream stream = new StreamImpl("AABBABacafe");
        final Optional<Character> characterOptional = PrimeiroCaracterNaoRepetido.encontraPrimeiraVogalNaoRepetida(stream);
        assertThat(characterOptional.get()).as("O primeiro caracter não repetido ver ser a vogal e")
                .isEqualTo('e');
    }

    @Test
    public void deveDeveExistirOCaracterVogalNaoRepetido() throws Exception {
        Stream stream = new StreamImpl("AABBABacaf");
        final Optional<Character> characterOptional = PrimeiroCaracterNaoRepetido.encontraPrimeiraVogalNaoRepetida(stream);
        assertThat(characterOptional).as("Não existe caracter não vogal não repetido")
                .isEmpty();
    }

    @Test
    public void quandoExirtiEspacoDeveEncontrarOCaracterRepetido() throws Exception {
        Stream stream = new StreamImpl("AABBA Bacafe");
        final Optional<Character> characterOptional = PrimeiroCaracterNaoRepetido.encontraPrimeiraVogalNaoRepetida(stream);
        assertThat(characterOptional.get()).as("O primeiro caracter não repetido ver ser a vogal e")
                .isEqualTo('e');
    }

    @Test
    public void hasNextTest() throws Exception {
        Stream stream = new StreamImpl("AA");

        assertThat(stream.hasNext())
                .as("Existe um proximo Caracter na Stream, hasNext retorna true")
                .isTrue();

        stream.getNext(); // avança um char
        stream.getNext(); // avança um char

        assertThat(stream.hasNext())
                .as("Não existem mais caracteres na Stream")
                .isFalse();
    }

    @Test
    public void getNextTest() throws Exception {
        Stream stream = new StreamImpl("aAf");

        assertThat(stream.getNext())
                .isEqualTo('a');

        assertThat(stream.getNext())
                .isEqualTo('A');

        assertThat(stream.getNext())
                .isEqualTo('f');
    }

    @Test
    public void quandoStringVaziaNaoDeveExistirRepetidoOuDarErro() throws Exception {
        String entrada = "";
        Stream stream = new StreamImpl(entrada);

        final Optional<Character> characterOptional = PrimeiroCaracterNaoRepetido.encontraPrimeiraVogalNaoRepetida(stream);
        assertThat(characterOptional).as("Não existe caracter não vogal não repetido")
                .isEmpty();

    }

    @Test
    public void quandoEntradaNullNaoDeveDarErro() throws Exception {
        Stream stream = new StreamImpl(null);
        final Optional<Character> characterOptional = PrimeiroCaracterNaoRepetido.encontraPrimeiraVogalNaoRepetida(stream);
        assertThat(characterOptional).as("Não existe caracter não vogal não repetido")
                .isEmpty();
    }

    @Test
    public void quandoStreamNullNaoDeveDarErro() throws Exception {
        final Optional<Character> characterOptional = PrimeiroCaracterNaoRepetido.encontraPrimeiraVogalNaoRepetida(null);
        assertThat(characterOptional).as("Não existe caracter não vogal não repetido")
                .isEmpty();
    }

}
