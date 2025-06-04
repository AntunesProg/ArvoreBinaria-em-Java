// Classe da Árvore Binária
public class ArvoreBinaria {
    private No raiz;

    // Inserção
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No atual, int valor) {
        if (atual == null) return new No(valor);
        if (valor < atual.valor) atual.esquerdo = inserirRec(atual.esquerdo, valor);
        else atual.direito = inserirRec(atual.direito, valor);
        return atual;
    }

    // Remoção
    public void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }

    private No removerRec(No atual, int valor) {
        if (atual == null) return null;
        if (valor < atual.valor) atual.esquerdo = removerRec(atual.esquerdo, valor);
        else if (valor > atual.valor) atual.direito = removerRec(atual.direito, valor);
        else {
            // Caso 1: sem filhos
            if (atual.esquerdo == null && atual.direito == null) return null;
            // Caso 2: um filho
            if (atual.esquerdo == null) return atual.direito;
            if (atual.direito == null) return atual.esquerdo;
            // Caso 3: dois filhos
            atual.valor = encontrarMenorValor(atual.direito);
            atual.direito = removerRec(atual.direito, atual.valor);
        }
        return atual;
    }

    private int encontrarMenorValor(No atual) {
        int menor = atual.valor;
        while (atual.esquerdo != null) {
            menor = atual.esquerdo.valor;
            atual = atual.esquerdo;
        }
        return menor;
    }

    // Pesquisa
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(No atual, int valor) {
        if (atual == null) return false;
        if (valor == atual.valor) return true;
        return valor < atual.valor ? buscarRec(atual.esquerdo, valor) : buscarRec(atual.direito, valor);
    }

    // Grau de um nó
    public int grauDoNo(int valor) {
        No no = encontrarNo(raiz, valor);
        if (no == null) return -1;
        int grau = 0;
        if (no.esquerdo != null) grau++;
        if (no.direito != null) grau++;
        return grau;
    }

    private No encontrarNo(No atual, int valor) {
        if (atual == null || atual.valor == valor) return atual;
        return valor < atual.valor ? encontrarNo(atual.esquerdo, valor) : encontrarNo(atual.direito, valor);
    }

    // Nível da árvore
    public int nivel() {
        return altura(raiz);
    }

    private int altura(No atual) {
        if (atual == null) return -1;
        return 1 + Math.max(altura(atual.esquerdo), altura(atual.direito));
    }

    // Verificações
    public boolean ehCompleta() {
        return ehCompletaRec(raiz, 0, contarNos(raiz));
    }

    private boolean ehCompletaRec(No no, int index, int totalNos) {
        if (no == null) return true;
        if (index >= totalNos) return false;
        return ehCompletaRec(no.esquerdo, 2 * index + 1, totalNos) &&
               ehCompletaRec(no.direito, 2 * index + 2, totalNos);
    }

    public boolean ehCheia() {
        return ehCheiaRec(raiz);
    }

    private boolean ehCheiaRec(No no) {
        if (no == null) return true;
        if ((no.esquerdo == null && no.direito != null) ||
            (no.esquerdo != null && no.direito == null)) return false;
        return ehCheiaRec(no.esquerdo) && ehCheiaRec(no.direito);
    }

    public boolean ehEstritamenteBinaria() {
        return ehEstritamenteBinariaRec(raiz);
    }

    private boolean ehEstritamenteBinariaRec(No no) {
        if (no == null) return true;
        if ((no.esquerdo == null && no.direito == null) ||
            (no.esquerdo != null && no.direito != null)) {
            return ehEstritamenteBinariaRec(no.esquerdo) && ehEstritamenteBinariaRec(no.direito);
        }
        return false;
    }

    // Impressões
    public void imprimirPreOrdem() {
        preOrdem(raiz);
        System.out.println();
    }

    private void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerdo);
            preOrdem(no.direito);
        }
    }

    public void imprimirEmOrdem() {
        emOrdem(raiz);
        System.out.println();
    }

    private void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.esquerdo);
            System.out.print(no.valor + " ");
            emOrdem(no.direito);
        }
    }

    public void imprimirPosOrdem() {
        posOrdem(raiz);
        System.out.println();
    }

    private void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.esquerdo);
            posOrdem(no.direito);
            System.out.print(no.valor + " ");
        }
    }

    // Contagem de nós
    private int contarNos(No no) {
        if (no == null) return 0;
        return 1 + contarNos(no.esquerdo) + contarNos(no.direito);
    }
}
