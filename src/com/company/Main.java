package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        int storageSize = 4;
        int itemNumbers = 10;
        int producersNum = 2;
        int consumersNum = 5;
        main.starter(storageSize, itemNumbers, producersNum, consumersNum);
    }

    public void starter(int storageSize, int itemNumbers, int producers, int consumers){
        Manager manager = new Manager(storageSize);

        for(int i = 0; i < producers; i++){
            new Producer(i * itemNumbers / producers, (i + 1) * itemNumbers / producers, manager);
        }

        for (int i = 0; i < consumers; i++){
            new Consumer((i + 1) * itemNumbers / consumers - i * itemNumbers / consumers, manager);
        }
    }
}
