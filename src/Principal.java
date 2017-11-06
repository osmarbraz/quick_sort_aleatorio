/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplinas: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 * Baseado nos slides da aula 01/09/2017 
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
     * @param i Primeira posição de torca
     * @param j Segunda posição de torca
     */
    public static void troca(int[] A, int i, int j) {
        int aux = A[i];
        A[i] = A[j];
        A[j] = aux;
    }

     /**
     * Particione encontra o pivo.
     * Complexidade de tempo Theta(n).
     * T(n) = Theta(2n + 4) + O(2n) = Theta(n) 
     * Slide 68.     
     * 
     * @param A Vetor com os dados
     * @param p Início do vetor
     * @param r Fim do vetor
     * @return o pivo da troca
     */
    public static int particione(int A[], int p, int r) {
        //x é o “pivô”
        int x = A[r];                       //Theta(1)
        int i = p - 1;                      //Theta(1)
        for (int j = p; j <= r - 1; j++) {  //Theta(n)
            if (A[j] <= x) {                //Theta(n)
                i = i + 1;                  //O(n)
                troca(A, i, j);             //O(n)
            }
        }
        troca(A, i + 1, r);                 //Theta(1)
        return i + 1;                       //Theta(1)
    }
    
    /**
     * Particione aleatório encontra o pivo de forma aleatória.
     * Slide 91.     
     * @param A Vetor com os dados
     * @param p Início do vetor
     * @param r Fim do vetor
     * @return o pivo da troca
     */
    public static int particioneAleatorio(int A[], int p, int r) {
        //i é o “pivô”
        int i = aleatorio(p,r);             //Theta(1)        
        troca(A,i,r);                       //Theta(1)
        return particione(A,p,r);           //Theta(n)
    }

    /**
     * Executa o quicksort aleatório recursivo. 
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
        if (p < r) {                        //Theta(1)
            int q = particioneAleatorio(A, p, r);    //Theta(n)
            quicksortAleatorio(A, p, q - 1);         //T(k)
            quicksortAleatorio(A, q + 1, r);         //T(n-k-1)    
        }
    }

    public static void main(String args[]) {

        //Vetor dos dados    
        int A[] = {50, 70, 60, 90, 10, 30, 20, 40};

        //Inicio do vetor
        int p = 0;
        //Fim do vetor
        int r = A.length - 1;

        System.out.println(">>> QuickSort Aleatório<<<");
        System.out.println("Original: ");
        for (int i = 0; i <= r; i++) {
            System.out.println((i) + " - " + A[i]);
        }

        quicksortAleatorio(A, p, r);

        System.out.println("Depois: ");
        for (int i = 0; i <= r; i++) {
            System.out.println((i) + " - " + A[i]);
        }
    }
}
