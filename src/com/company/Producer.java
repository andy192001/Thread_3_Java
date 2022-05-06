package com.company;

// Виробник
public class Producer implements Runnable {
    private final Manager manager;
    private final int firstIndex;
    private final int lastIndex;

    public Producer(int firstIndex, int lastIndex, Manager manager) {
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
        this.manager = manager;


        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = firstIndex; i < lastIndex; i++) {
            try {
                manager.full.acquire();
                manager.access.acquire();

                manager.storage.add("item " + i);
                System.out.println("Added item " + i);

                manager.access.release();
                manager.empty.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
