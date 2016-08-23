
import java.util.Random;


public class App {
    public static void main(String[] args) {       
        
        ListArrayOfInteger lista1 = new ListArrayOfInteger(10);
        lista1.add(10);
        lista1.add(20);
        lista1.add(22);
        lista1.add(18);
        lista1.add(44);
        lista1.add(15);
        
        ListArrayOfInteger lista2 = new ListArrayOfInteger(10);
        lista2.add(22);
        lista2.add(15);
        lista2.add(99);
        lista2.add(10);
        
        System.out.println("Lista1 = " + lista1);
        System.out.println("Lista2 = " + lista2);
        
        System.out.println("Union     = " + lista1.union(lista2));
        // Deverá ser {10,15,18,20,22,44,99} (não importando a ordem)
        
        System.out.println("Intersect = " + lista1.intersect(lista2));
        // Deverá ser {10,15,22} (não importando a ordem) 
        
    }
}
