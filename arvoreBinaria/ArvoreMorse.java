package arvoreBinaria;

public class ArvoreMorse {
    private Node raiz;
    private boolean maior;

    public ArvoreMorse() {
        raiz = new Node(' ');
        inicializarArvore();
    }

    private void adicionar(String codMorse, char valor) {
        Node noAnterior = procurar(codMorse);
        Node no = new Node(valor);

        if (maior) 
            noAnterior.setDireita(no);
        else
            noAnterior.setEsquerda(no);
    }

    private Node procurar(String codMorse) {
        Node noAtual = raiz;
        for (char v : codMorse.toCharArray()) {
            if (v == '.') {
                maior = false;
                if (noAtual.getEsquerda() == null)
                    return noAtual;
                noAtual = noAtual.getEsquerda();
            } else if (v == '-') {
                maior = true;
                if (noAtual.getDireita() == null)
                    return noAtual;
                noAtual = noAtual.getDireita();
            }
        }
        return noAtual;
    }

    public char decifrar(String codMorse) {
        return procurar(codMorse).getValor();
    }

    private void inicializarArvore() {
        adicionar(".", 'E');
        adicionar("-", 'T');
        
        adicionar("..", 'I');
        adicionar(".-", 'A');
        adicionar("-.", 'N');
        adicionar("--", 'M');

        adicionar("...", 'S');
        adicionar("..-", 'U');
        adicionar(".-.", 'R');
        adicionar(".--", 'W');
        adicionar("-..", 'D');
        adicionar("-.-", 'K');
        adicionar("--.", 'G');
        adicionar("---", 'O');

        adicionar("....", 'H');
        adicionar("...-", 'V');
        adicionar("..-.", 'F');
        adicionar(".-..", 'L');
        adicionar(".--.", 'P');
        adicionar(".---", 'J');
        adicionar("-...", 'B');
        adicionar("-..-", 'X');
        adicionar("-.--", 'Y');
        adicionar("--..", 'Z');
        adicionar("--.-", 'Q');
    }

    public void mostrarArvore() {
        int len = 3;
        int lenSpace = 45;
        String inicio = " ".repeat(lenSpace - 6) + "** Arvore Morse **\n";

        System.out.println(inicio);
        System.out.println(" ".repeat(lenSpace) + "[START]");
        System.out.println(" ".repeat(lenSpace) + "/" + " ".repeat(5) + "\\");
        System.out.println(" ".repeat(lenSpace - 2) + "[" + procurar(".").getValor() + "]" + " ".repeat(5) + "[" + procurar("-").getValor() + "]");
        System.out.println(" ".repeat(lenSpace - 2) + "/ \\" +  " ".repeat(5) + "/ \\");
        System.out.println(" ".repeat(lenSpace - 4) + "[" + procurar("..").getValor() + "]" + " ".repeat(1) + "[" + procurar(".-").getValor() + "]" + " ".repeat(5) + "[" + procurar("--").getValor() + "]");
    }

    private class Node {
        private Node esquerda;
        private char valor;
        private Node direita;

        public Node(char valor) {
            this.valor = valor;
            esquerda = direita = null;
        }
        
        public Node getEsquerda() {
            return esquerda;
        }

        public void setEsquerda(Node esquerda) {
            this.esquerda = esquerda;
        }

        public char getValor() {
            return valor;
        }

        public Node getDireita() {
            return direita;
        }

        public void setDireita(Node direita) {
            this.direita = direita;
        }

        @Override
        public String toString() {
            return "Node: [" + valor + "]";
        }
    }
    @Override
    public String toString() {
        return "Raiz: [" + raiz.getValor() + "]";
    }
}