package Corde_des_babouins;

class Corde {

    private volatile Cote cote;
    private volatile int nbPlace =5;

    public synchronized void saisir(Cote origine){

        try {
            while(!(nbPlace==5) &&(nbPlace ==0 ||cote!=origine)){
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cote=origine;
        nbPlace--;
    }

    public synchronized void lâcher(Cote origine){
        nbPlace++;
        notifyAll();
    }
}

