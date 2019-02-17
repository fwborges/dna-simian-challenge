package com.br.ml.challenge.simian.simianservice.usecase.search;

public class SearchResponse {

    private Integer chainA = 0;

    private Integer chainC = 0;

    private Integer chainG = 0;

    private Integer chainT = 0;

    private Integer chainSumA = 0;

    private Integer chainSumC = 0;

    private Integer chainSumG = 0;

    private Integer chainSumT = 0;

    private Integer maxSequenceDNA = 4;

    public SearchResponse merge(SearchResponse response) {

        this.chainSumA += response.chainSumA;
        this.chainSumC += response.chainSumC;
        this.chainSumG += response.chainSumG;
        this.chainSumT += response.chainSumT;

        return this;
    }

    public Boolean hasAnyDNAChain() {

        return chainSumA > 0 || chainSumC > 0 || chainSumG > 0 || chainSumT > 0;
    }

    public void incrementChainA() {
        this.chainA++;
        resetChainC();
        resetChainG();
        resetChainT();
    }

    public void incrementChainC() {
        this.chainC++;
        resetChainA();
        resetChainG();
        resetChainT();
    }

    public void incrementChainG() {
        this.chainG++;
        resetChainA();
        resetChainC();
        resetChainT();
    }

    public void incrementChainT() {
        this.chainT++;
        resetChainA();
        resetChainC();
        resetChainG();
    }

    public void closeChainingAAsPossible() {

        if(chainA.equals(maxSequenceDNA)) {
            this.chainSumA++;
        }
    }

    public void closeChainingCAsPossible() {

        if(chainC.equals(maxSequenceDNA)) {
            this.chainSumC++;
        }
    }

    public void closeChainingGAsPossible() {

        if(chainG.equals(maxSequenceDNA)) {
            this.chainSumG++;
        }
    }

    public void closeChainingTAsPossible() {

        if(chainT.equals(maxSequenceDNA)) {
            this.chainSumT++;
        }
    }

    public void resetAll() {

        resetChainA();
        resetChainC();
        resetChainG();
        resetChainT();
    }

    private void resetChainA() {
        this.chainA = 0;
    }

    private void resetChainC() {
        this.chainC = 0;
    }

    private void resetChainG() {
        this.chainG = 0;
    }

    private void resetChainT() {
        this.chainT = 0;
    }


    public Integer getChainSumA() {
        return chainSumA;
    }

    public void setChainSumA(Integer chainSumA) {
        this.chainSumA = chainSumA;
    }

    public Integer getChainSumC() {
        return chainSumC;
    }

    public void setChainSumC(Integer chainSumC) {
        this.chainSumC = chainSumC;
    }

    public Integer getChainSumG() {
        return chainSumG;
    }

    public void setChainSumG(Integer chainSumG) {
        this.chainSumG = chainSumG;
    }

    public Integer getChainSumT() {
        return chainSumT;
    }

    public void setChainSumT(Integer chainSumT) {
        this.chainSumT = chainSumT;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "chainA=" + chainA +
                ", chainC=" + chainC +
                ", chainG=" + chainG +
                ", chainT=" + chainT +
                ", chainSumA=" + chainSumA +
                ", chainSumC=" + chainSumC +
                ", chainSumG=" + chainSumG +
                ", chainSumT=" + chainSumT +
                '}';
    }
}
