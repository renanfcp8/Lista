public class ListaSimples {
    private No inicio;

    public ListaSimples() {
        this.inicio = null;
    }

    public void inserirNoInicio(int valor) {
        No novo = new No(valor);
        novo.proximo = inicio;
        inicio = novo;
    }

    public void inserirNoFinal(int valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No temp = inicio;
            while (temp.proximo != null) {
                temp = temp.proximo;
            }
            temp.proximo = novo;
        }
    }

    public void inserirNaPosicao(int pos, int valor) {
        if (pos == 0) {
            inserirNoInicio(valor);
            return;
        }
        No novo = new No(valor);
        No temp = inicio;
        int contador = 0;

        while (temp != null && contador < pos - 1) {
            temp = temp.proximo;
            contador++;
        }

        if (temp == null) {
            System.out.println("Posição inválida!");
        } else {
            novo.proximo = temp.proximo;
            temp.proximo = novo;
        }
    }

    public void removerNoInicio() {
        if (inicio != null) {
            inicio = inicio.proximo;
        }
    }

    public void removerNoFinal() {
        if (inicio == null) return;
        if (inicio.proximo == null) {
            inicio = null;
            return;
        }
        No temp = inicio;
        while (temp.proximo.proximo != null) {
            temp = temp.proximo;
        }
        temp.proximo = null;
    }

    public void removerNaPosicao(int pos) {
        if (pos == 0) {
            removerNoInicio();
            return;
        }

        No temp = inicio;
        int contador = 0;

        while (temp != null && contador < pos - 1) {
            temp = temp.proximo;
            contador++;
        }

        if (temp == null || temp.proximo == null) {
            System.out.println("Posição inválida!");
        } else {
            temp.proximo = temp.proximo.proximo;
        }
    }

    public int tamanho() {
        int cont = 0;
        No temp = inicio;
        while (temp != null) {
            cont++;
            temp = temp.proximo;
        }
        return cont;
    }

    public void exibir() {
        No temp = inicio;
        System.out.print("Lista: ");
        while (temp != null) {
            System.out.print(temp.valor + " ");
            temp = temp.proximo;
        }
        System.out.println();
    }
}
