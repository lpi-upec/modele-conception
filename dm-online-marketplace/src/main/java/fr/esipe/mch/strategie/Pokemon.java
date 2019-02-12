package fr.esipe.mch.strategie;

public class Pokemon {
    Integer PVMAX = 10;
    String name;
    Integer pv;

    @Override
    public String toString() {
        return name;
    }
}

class Dresseur {
    String name;
    private Combattant c;
    private Soigneur s;
    private Attrapeur a;

    public Dresseur(){
        c = new Combattant();
        s = new SoigneurAmateur();
        a = new Attrapeur();
    }

    @Override
    public String toString() {
        return name;
    }

    void soigner(Pokemon p){
        s.soigner(p);
    }

    void attraper(Pokemon p){
        a.attraper(p);
    }

    void combattre(Dresseur d){
        c.combattre(d);
    }

}

class Attrapeur {
    void attraper(Pokemon p) {
        System.out.println("Gotcha : " + p.toString());
    }
}

interface Soigneur {
    void soigner(Pokemon p);
}

class SoigneurPro implements Soigneur {

    @Override
    public void soigner(Pokemon p) {
        p.pv = p.PVMAX;
        System.out.println("Les pv de " + p.toString() + " ont été régénéré : " + p.pv);
    }
}

class SoigneurAmateur implements Soigneur {

    @Override
    public void soigner(Pokemon p) {
        if(p.pv == p.PVMAX){
            System.out.println("PV déjà au max");
        } else if(p.pv + (p.PVMAX / 2) > p.PVMAX){
            p.pv = p.PVMAX;
        } else {
            p.pv = p.PVMAX / 2;
        }
        System.out.println("Les pv de " + p.toString() + " ont été régénéré de moitié : " + p.pv);
    }
}

class Combattant {
    public void combattre(Dresseur d) {
        System.out.println("Vous combattez " + d.toString());
    }
}

class Infermiere {
    Soigneur s;

    public Infermiere(){
        s = new SoigneurPro();
    }

    void soigner(Pokemon p) {
        s.soigner(p);
    }
}

class Main {
    public static void main(String[] args){
        Pokemon pikachu = new Pokemon();
        pikachu.name = "Pikachu";
        pikachu.pv = 7;

        Dresseur sacha = new Dresseur();
        sacha.name = "Sacha";

        Dresseur pierre = new Dresseur();
        pierre.name = "Pierre";

        Infermiere joel = new Infermiere();

        sacha.attraper(pikachu);
        sacha.combattre(pierre);
        sacha.soigner(pikachu);
        sacha.soigner(pikachu);
    }
}

