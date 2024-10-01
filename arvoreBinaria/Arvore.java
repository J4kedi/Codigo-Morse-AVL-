package avore;

public class Arvore {
    private Node raiz;

    public Arvore() {
        raiz = null;
    }

    public void adicionar(int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
            return;
        }

        Node noAtual = raiz;
        Node noAnterior = null;
        boolean maior = false;

        while (noAtual != null) {
            noAnterior = noAtual;
            if (noAnterior.getValor() <= valor) {
                noAtual = noAtual.getDireita();
                maior = true;
            } else {
                noAtual = noAtual.getEsquerda();
                maior = false;
            }
        }

        if (noAtual == null && maior) 
            noAnterior.setDireita(new Node(valor));
        else
            noAnterior.setEsquerda(new Node(valor));

    }

    public Node procurar(int valor) {
        Node noAtual = raiz;

        while (noAtual.getValor() != valor) {
            if (noAtual.getValor() <= valor)
                noAtual = noAtual.getDireita();
            else
                noAtual = noAtual.getEsquerda();
            
            if (noAtual == null)
                throw new IllegalArgumentException("Nó não encontrado na avore");
        }
        return noAtual;
    }

    public Node procurarNoAnterior(Node no) {
        Node noAtual = raiz;
        do {
            if(noAtual.getValor() <= no.getValor())
                noAtual = noAtual.getDireita();
            else 
                noAtual = noAtual.getEsquerda();
        } while(noAtual.getDireita() != no && noAtual.getEsquerda() != no);

        return noAtual;
    }

    public int remover(int valor) {
        Node no = procurar(valor);
        Node noAnterior = procurarNoAnterior(no);

        if (noAnterior.getValor() <= valor) 
            noAnterior.setDireita(null);
        else
            noAnterior.setEsquerda(null);
        return valor;
    }

    private class Node {
        private Node esquerda;
        private int valor;
        private Node direita;

        public Node(int valor){
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }

        public Node getEsquerda() {
            return esquerda;
        }

        public void setEsquerda(Node esquerda) {
            this.esquerda = esquerda;
        }

        public Node getDireita() {
            return direita;
        }

        public void setDireita(Node direita) {
            this.direita = direita;
        }

        @Override
        public String toString() {
            return "Node: [" + String.valueOf(valor) + "]";
        }
    }

    @Override
    public String toString() {
        return "Raiz: [" + String.valueOf(raiz.getValor()) + "]";
    }
}