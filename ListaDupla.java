public class ListaDupla {
    private NoDuplo inicio;
    private NoDuplo fim;

    public ListaDupla() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserirNoInicio(int valor) {
        NoDuplo novo = new NoDuplo(valor);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
    }

    public void inserirNoFinal(int valor) {
        NoDuplo novo = new NoDuplo(valor);
        if (fim == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public void inserirNaPosicao(int pos, int valor) {
        if (pos < 0) throw new IndexOutOfBoundsException("Posição negativa: " + pos);
        if (inicio == null || pos == 0) {
            inserirNoInicio(valor);
            return;
        }

        int i = 0;
        NoDuplo temp = inicio;
        while (temp != null && i < pos) {
            temp = temp.proximo;
            i++;
        }

        if (temp == null) {
            inserirNoFinal(valor);
        } else {
            NoDuplo novo = new NoDuplo(valor);
            NoDuplo prev = temp.anterior;
            prev.proximo = novo;
            novo.anterior = prev;
            novo.proximo = temp;
            temp.anterior = novo;
        }
    }

    public void removerNoInicio() {
        if (inicio == null) return;
        if (inicio == fim) {
            inicio = fim = null;
            return;
        }
        inicio = inicio.proximo;
        inicio.anterior = null;
    }

    public void removerNoFinal() {
        if (fim == null) return;
        if (inicio == fim) {
            inicio = fim = null;
            return;
        }
        fim = fim.anterior;
        fim.proximo = null;
    }

    public void removerNaPosicao(int pos) {
        if (pos < 0) throw new IndexOutOfBoundsException("Posição negativa: " + pos);
        if (inicio == null) return;
        if (pos == 0) {
            removerNoInicio();
            return;
        }

        int i = 0;
        NoDuplo temp = inicio;
        while (temp != null && i < pos) {
            temp = temp.proximo;
            i++;
        }

        if (temp == null) return; 

        if (temp == fim) {
            removerNoFinal();
            return;
        }

        NoDuplo prev = temp.anterior;
        NoDuplo next = temp.proximo;
        prev.proximo = next;
        next.anterior = prev;
    }

    public int tamanho() {
        int cont = 0;
        NoDuplo temp = inicio;
        while (temp != null) {
            cont++;
            temp = temp.proximo;
        }
        return cont;
    }

    public void exibir() {
        NoDuplo temp = inicio;
        System.out.print("Lista: ");
        while (temp != null) {
            System.out.print(temp.valor + " ");
            temp = temp.proximo;
        }
        System.out.println();
    }
}
public class ListaDupla {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();

        lista.inserirNoInicio(10);
        lista.inserirNoFinal(20);
        lista.inserirNoFinal(30);
        lista.inserirNaPosicao(1, 15);
        lista.exibir();

        lista.removerNoInicio();
        lista.exibir();

        lista.removerNoFinal();
        lista.exibir();

        lista.removerNaPosicao(1);
        lista.exibir();

        System.out.println("Tamanho da lista dupla: " + lista.tamanho());
    }
}

