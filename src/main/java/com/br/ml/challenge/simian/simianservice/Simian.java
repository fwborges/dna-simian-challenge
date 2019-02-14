package com.br.ml.challenge.simian.simianservice;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Simian {

    private int A = 0;

    private int T = 0;

    private int C = 0;

    private int G = 0;

    private int countingA = 0;

    private int countingC = 0;

    private int countingT = 0;

    private int countingG = 0;


    public boolean isSimian(String[] dna1) {

        String [] dna = {"CTGAGACTATGC", "CTATGCTATTGT", "TATTGTAGAGGG", "AGAGGGCCCCTA", "CCCCTATCACTG", "TCACTGCTATGC", "TCACTGCTATGC", "TATTGTAGAGGG", "CTGAGACTATGC", "CCCCTATCACTG", "TATACGTGTGAC", "CACATGATCAGT"};
        String[][] matrixDna = new String[12][12];


        Queue<String> dnaChain = new LinkedList<>();

        Arrays.stream(dna)
                .forEach(string -> {

                    Arrays.stream(string.split("")).forEach(s -> dnaChain.add(s));
                });

      for(int i = 0; i < matrixDna.length; i++) {

          for(int j = 0; j < matrixDna.length; j++) {


                  matrixDna[i][j]= dnaChain.peek();
                  dnaChain.remove();


          }
      }


      System.out.println(Arrays.deepToString(matrixDna).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        searchHorizontal(matrixDna);
        searchVertical(matrixDna);
        searchDiagonallyLeftToRight(matrixDna);
        searchDiagonallyRightToLeft(matrixDna);

        System.out.println("DNA A: " + countingA);
        System.out.println("DNA C: " + countingC);
        System.out.println("DNA T: " + countingT);
        System.out.println("DNA G: " + countingG);

      return false;
    }

    private void searchDiagonallyRightToLeft(String[][] matrixDna) {
        System.out.println(" =======================  ");
        for(int k = 0; k <= matrixDna.length -1; k++) {

            int j = k;
            int i = matrixDna.length - 1;

            while(j >= 0){ //go until first column

                System.out.print(matrixDna[i][j]);
                verifyDNA(matrixDna[i][j]);

                i= i-1;
                j= j-1;
            }

            System.out.println(" ");
        }


        for(int k = matrixDna.length - 2; k >= 0; k--) {

            int i = k;
            int j = matrixDna.length - 1;

            while(i >= 0) {
                System.out.print(matrixDna[i][j]);
                verifyDNA(matrixDna[i][j]);

                i=i-1;
                j=j-1;
            }
            System.out.println(" ");
        }
        System.out.println(" =======================  ");
    }

    private void searchVertical(String[][] matrixDna) {

        for(int i = 0; i < matrixDna.length; i++) {
            for(int j = 0; j < matrixDna.length; j++) {

                verifyDNA(matrixDna[j][i]);
            }
        }


    }

    private void verifyDNA(String s) {
        if (s.equals("A")) {

            A++;
            T = 0;
            C = 0;
            G = 0;

            if (A == 4) {
                A = 0;
                countingA++;
            }

        }

        if (s.equals("T")) {
            T++;
            A = 0;
            C = 0;
            G = 0;

            if (T == 4) {
                T = 0;
                countingT++;
            }


        }

        if (s.equals("C")) {
            C++;
            A = 0;
            T = 0;
            G = 0;

            if (C == 4) {
                C = 0;
                countingC++;
            }

        }

        if (s.equals("G")) {

            G++;
            C = 0;
            A = 0;
            T = 0;

            if (G == 4) {
                G = 0;
                countingG++;
            }

        }
    }


    private void searchDiagonallyLeftToRight(String[][] matrixDna) {

        for(int k = 0; k <= matrixDna.length -1; k++) {

            int i = k;
            int j = 0;

            while(i >= 0){ //go until first row

                System.out.print(matrixDna[i][j]);
                verifyDNA(matrixDna[i][j]);

                i= i-1;
                j = j+1;
            }

            System.out.println(" ");
        }


        for(int k=1; k<= matrixDna.length -1; k++) {

            int i = matrixDna.length -1;
            int j = k;

            while(j <= matrixDna.length -1) {
                System.out.print(matrixDna[i][j]);
                verifyDNA(matrixDna[i][j]);

                i=i-1;
                j=j+1;
            }
            System.out.println(" ");
        }

    }

    private void searchHorizontal(String[][] matrixDna) {
        for(int i = 0; i < matrixDna.length; i++) {
            for(int j = 0; j < matrixDna.length; j++) {

                verifyDNA(matrixDna[i][j]);
            }
        }
    }
}
