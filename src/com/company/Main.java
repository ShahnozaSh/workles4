package com.company;

import java.util.Random;


public class Main {

    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefence = "";
    public static int[] heroesHealth = {270, 260, 250, 240, 300};
    public static int[] heroesDamage = {25, 15, 20, 0};
    public static String[] heroesAttackType = {
            "Physical", "Magical", "Kinetic", "Archer", "Medic"};

    public static int roundCounter = 0;

    public static void main(String[] args) {
        printStatistics();
        while (!isGameOver()) {
            round();
        }
    }

    public static void changeDefence() {
        Random r = new Random();
        int randomIndex = r.nextInt(heroesAttackType.length); // 0,1,2,3
        bossDefence = heroesAttackType[randomIndex];
        System.out.println("Boss choose: " + bossDefence);
    }

    public static boolean isGameOver() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    public static void round() {
        if (bossHealth > 0) {
            changeDefence();
            bossHits();
            medicHealth();
            golem();


        }

    }

    public static void golem() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[4] > 0 && heroesHealth[i] > 0) {
                heroesHealth[4] = heroesHealth[4] - (bossDamage / 5);
                heroesHealth[i] = heroesHealth[i] + (bossDamage / 5);
            }

        }

    }


public static void bossHits(){
        for(int i=0;i<heroesDamage.length;i++){
        if(heroesHealth[i]>0){
        if(heroesHealth[i]-bossDamage< 0){
        heroesHealth[i]=0;
        }else{
        heroesHealth[i]=heroesHealth[i]-bossDamage;
        }
        }
        }
        }

public static void heroesHit(){
        for(int i=0;i<heroesHealth.length;i++){
        if(heroesHealth[i]>0&&bossHealth>0){
        if(heroesAttackType[i]==bossDefence){
        Random r=new Random();
        int coeff=r.nextInt(7)+1; //1,2,3,4,5
        if(bossHealth-heroesDamage[i]*coeff< 0){
        bossHealth=0;
        }else{
        bossHealth=bossHealth-heroesDamage[i]*coeff;
        }
        if(coeff>1){
        System.out.println("Critical damage: "
        +heroesDamage[i]*coeff);
        }
        }else{
        if(bossHealth-heroesDamage[i]< 0){
        bossHealth=0;
        }else{
        bossHealth=bossHealth-heroesDamage[i];
        }
        }
        }
        }
        }

public static void medicHealth(){
        for(int i=0;i<heroesHealth.length;i++){
        if(heroesHealth[i]< 100&&heroesHealth[4]>0){
        heroesHealth[i]+=100;
        }
        }
        }

public static void printStatistics(){
        System.out.println("________________");
        System.out.println("Round ---- "+roundCounter);
        roundCounter++;
        System.out.println("Boss health: "+bossHealth);
        for(int i=0;i<heroesHealth.length;i++){
        System.out.println(heroesAttackType[i]+" health: "
        +heroesHealth[i]);
        }
        System.out.println("________________");
        }


        }
