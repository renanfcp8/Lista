public class Main {
    public static void main(String[] args) {
        ListaSimples lista = new ListaSimples();
        lista.inserirNoInicio(3);
        lista.inserirNoInicio(2);
        lista.inserirNoFinal(4);
        lista.inserirNaPosicao(1, 7);
        lista.exibir(); 

        lista.removerNaPosicao(2); 
        lista.exibir(); 

        System.out.println("Tamanho: " + lista.tamanho()); 

        
        try {
            lista.inserirNaPosicao(-1, 10);
        } catch (Exception e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}public class Main {
    public static void main(String[] args) {
        ListaSimples lista = new ListaSimples();
        lista.inserirNoInicio(3);
        lista.inserirNoInicio(2);
        lista.inserirNoFinal(4);
        lista.inserirNaPosicao(1, 7); 
        lista.exibir(); 

        lista.removerNaPosicao(2); 
        lista.exibir(); 

        System.out.println("Tamanho: " + lista.tamanho()); 
        try {
            lista.inserirNaPosicao(-1, 10);
        } catch (Exception e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}