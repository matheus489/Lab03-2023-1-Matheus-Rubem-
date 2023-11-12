package linked;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar{

    private No cabeca;

    public ListaLigada() {
        cabeca = null;

    }

    @Override
    public boolean buscaElemento(int valor) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.getValor() == valor) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    

    @Override
    public int buscaIndice(int valor) {
       No atual = cabeca;
    int indice = 0;
        while (atual != null) {
            if (atual.getValor() == valor) {
                return indice; 
            }
            atual = atual.getProximo();
            indice++;
            
        }
        return 0; // 
    }

    @Override
    public int minimo() {
        if (cabeca == null) {
            throw new IllegalStateException("Empty list");
        }

        No atual = cabeca;
        int min = atual.getValor();
        while (atual != null) {
            min = Math.min(min, atual.getValor());
            atual = atual.getProximo();
        }
        return min;
    }

    @Override
    public int maximo() {
        if (cabeca == null) {
            throw new IllegalStateException("Empty list");
        }

        No atual = cabeca;
        int max = atual.getValor();
        while (atual != null) {
            max = Math.max(max, atual.getValor());
            atual = atual.getProximo();
        }
        return max;
    }

    @Override
    public int predecessor(int valor) {
        No atual = cabeca;
        int predecessor = Integer.MIN_VALUE;
        while (atual != null) {
            if (atual.getValor() == valor) {
                return predecessor;
            }
            predecessor = atual.getValor();
            atual = atual.getProximo();
        }
        return Integer.MIN_VALUE; 
    }

    @Override
    public int sucessor(int valor) {
        No atual = cabeca;
        while (atual != null && atual.getProximo() != null) {
            if (atual.getValor() == valor) {
                return atual.getProximo().getValor();
            }
            atual = atual.getProximo();
        }
        return Integer.MIN_VALUE; 
    }

    @Override
    public void insereElemento(int valor) {
        No novoNo = new No(valor);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No atual = cabeca;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
    }
    

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        No novoNo = new No(valor);
        if (buscaIndice < 0) {
            throw new IllegalArgumentException("Invalid index");
        }

        if (buscaIndice == 0) {
            novoNo.setProximo(cabeca);
            cabeca = novoNo;
            return;
        }

        No atual = cabeca;
        int indice = 0;

        while (indice < buscaIndice -1 && atual != null) {
            atual = atual.getProximo();
            indice++;
        }

        if (atual != null) {
            novoNo.setProximo(atual.getProximo());
            atual.setProximo(novoNo);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
    

    @Override
    public void insereInicio(int valor) {
        if(this.cabeca == null){
            this.cabeca = new No(valor);
        }else {
            No n = new No(valor);
            n.setProximo(this.cabeca);
            this.cabeca = n;
        }   
        }

    @Override
    public void insereFim(int valor) {
         No novoNo = new No(valor);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No atual = cabeca;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
    }

    @Override
    public void remove(int valor) {
        if (cabeca == null) {
            return; }

            if (cabeca.getValor() == valor) {
                cabeca = cabeca.getProximo(); 
                return;
            }

            No atual = cabeca;
            while (atual.getProximo() != null && atual.getProximo().getValor() != valor) {
                atual = atual.getProximo();
            }

            if (atual.getProximo() != null) {
                atual.setProximo(atual.getProximo().getProximo()); 
            } else {
                // Do nothing, element not found
            }}
        

    @Override
    public void removeIndice(int indice) {
        if (cabeca == null) {
            return; // Empty list, nothing to remove
        }


        if (indice == 0) {
            cabeca = cabeca.getProximo(); // Remove the first element
            return;
        }

        No atual = cabeca;
        int atualIndice = 0;
        while (atual.getProximo() != null && atualIndice < indice - 1) {
            atual = atual.getProximo();
            atualIndice++;
        }

        if (atual.getProximo() != null) {
            atual.setProximo(atual.getProximo().getProximo()); // Remove the element
        }
    
    }

    @Override
    public void removeInicio() {
        if (cabeca != null) {
            cabeca = cabeca.getProximo(); // Remove the first element
        }
    
    }

    @Override
    public void removeFim() {
        if (cabeca == null) {
            return; // Empty list, nothing to remove
        }

        if (cabeca.getProximo() == null) {
            cabeca = null; // List has only one element, remove it
            return;
        }

        No atual = cabeca;
        while (atual.getProximo().getProximo() != null) {
            atual = atual.getProximo();
        }
        atual.setProximo(null); // Remove the last element
    }
    
}
