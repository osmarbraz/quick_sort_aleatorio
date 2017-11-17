/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplinas: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 *
 * Baseado nos slides 91 da aula 01/09/2017 
 *
 * Página 129 Cormen 3 ed
 *
 * Algoritmo QuickSort Aleatório
 *
 * Atenção:
 * Vetor em java inicia em 0, os algoritmos consideram início em 1.
 * A subtraçào de -1 ocorre somente no local de acesso ao vetor ou matriz 
 * para manter a compatibilidade entre os algoritmos.
 * 
 */

/**
 * @author Osmar de Oliveira Braz Junior
 */
public class Principal {

    /**
     * Seleciona um numero aleatorio no intervalo de inicio a fim
     * @param inicio Inicio do intervalodo número aleatório
     * @param fim Fim do intervalo do número aleatório
     */
    public static int aleatorio(int inicio, int fim) {
        return (int) Math.ceil(Math.random() * (fim - inicio + 1)) - 1 + inicio;
    }   
    
    /**
     * Realiza a troca de posição de dois elementos do vetor.
     * @param A Vetor que contem os dados
     * @param i Primeira posição de troca
     * @param j Segunda posição de troca
     */
    public static void troca(int[] A, int i, int j) {
        int aux = A[i-1];
        A[i-1] = A[j-1];
        A[j-1] = aux;
    }

     /**
     * Particione encontra o pivô.
     * 
     * Complexidade de tempo Theta(n).
     * T(n) = Theta(2n + 4) + O(2n) = Theta(n) 
     * Slide 68 da aula 01/09/2017 .     
     * 
     * @param A Vetor com os dados
     * @param p Início do vetor
     * @param r Fim do vetor
     * @return o pivo da troca
     */
    public static int particione(int A[], int p, int r) {
        //x é o "pivô"
        int x = A[r-1];                     //Theta(1)
        int i = p - 1;                      //Theta(1)
        for (int j = p; j <= r - 1; j++) {  //Theta(n)
            if (A[j-1] <= x) {              //Theta(n)
                i = i + 1;                  //O(n)
                troca(A, i, j);             //O(n)
            }
        }
        troca(A, i + 1, r);                 //Theta(1)
        return i + 1;                       //Theta(1)
    }
    
    /**
     * Particione aleatório encontra o pivo de forma aleatória.
     * 
     * Slide 91 da aula 01/09/2017.     
     * 
     * @param A Vetor com os dados
     * @param p Início do vetor
     * @param r Fim do vetor
     * @return o pivo da troca
     */
    public static int particioneAleatorio(int A[], int p, int r) {
        //i é o "pivô"
        int i = aleatorio(p,r);             //Theta(1)            
        troca(A,i,p);                       //Theta(1)
        return particione(A,p,r);           //Theta(n)
    }

    /**
     * Executa o quicksort aleatório recursivo. 
     * Algoritmos de ordenação podem ser ou não in-place ou estáveis.
     * Um algoritmo de ordenação é in-place se a memória adicional requerida é 
     * independente do tamanho do vetor que está sendo ordenado.
     * O quicksort é in-place 
     * 
     * Divisão: divida o vetor em dois subvetoresA[p ... q−1] e A[q+1...r] 
     * Conquista: ordena os dois subvetores recursivamente usando quicksort 
     * Combinação: nada a fazer, o vetor está ordenado. 
     * Slide 68 
     * T(n) = T(k) + T(n−k−1) + Theta(n+1) 
     * Complexidade de tempo no caso médio O(n log n)
     *
     * @param A Vetor com os dados
     * @param p Início do vetor
     * @param r Fim do vetor
     */
    public static void quicksortAleatorio(int A[], int p, int r) {
        if (p < r) {                                    //Theta(1)
            int q = particioneAleatorio(A, p, r);       //Theta(n)
            quicksortAleatorio(A, p, q - 1);            //T(k)
            quicksortAleatorio(A, q + 1, r);            //T(n-k-1)    
        }
    }

    public static void main(String args[]) {

        //Vetor dos dados    
        int A[] = {50, 70, 60, 90, 10, 30, 20, 40};

        //Inicio do vetor
        int p = 1;
        //Fim do vetor
        int r = A.length;

        System.out.println(">>> QuickSort Aleatório<<<");
        System.out.println("Original: ");
        for (int i = 0; i < r; i++) {
            System.out.println((i+1) + " - " + A[i]);
        }
        
        //Ordena o vetor A de p até r
        quicksortAleatorio(A, p, r);

        System.out.println("Depois: ");
        for (int i = 0; i < r; i++) {
            System.out.println((i+1) + " - " + A[i]);
        }
    }
}
