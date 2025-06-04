public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        // Inserindo elementos
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        // Impressões
        System.out.print("Pré-ordem: ");
        arvore.imprimirPreOrdem();

        System.out.print("Em ordem: ");
        arvore.imprimirEmOrdem();

        System.out.print("Pós-ordem: ");
        arvore.imprimirPosOrdem();

        // Verificações
        System.out.println("Nível da árvore: " + arvore.nivel());
        System.out.println("A árvore é cheia? " + arvore.ehCheia());
        System.out.println("A árvore é completa? " + arvore.ehCompleta());
        System.out.println("A árvore é estritamente binária? " + arvore.ehEstritamenteBinaria());

        // Grau de um nó
        int valor = 30;
        System.out.println("Grau do nó " + valor + ": " + arvore.grauDoNo(valor));

        // Buscar elemento
        int busca = 60;
        System.out.println("O valor " + busca + " está na árvore? " + arvore.buscar(busca));

        // Remover um valor
        arvore.remover(70);
        System.out.print("Em ordem após remover 70: ");
        arvore.imprimirEmOrdem();
    }
}
