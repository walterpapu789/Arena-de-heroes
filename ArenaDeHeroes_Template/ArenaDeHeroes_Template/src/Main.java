public class Main {
    public static void main(String[] args) {
        System.out.println("¡Bienvenido a la Arena de Héroes!");

        Guerrero ragnar = new Guerrero("Ragnar");
        Mago merlina = new Mago("Merlina", "Fuego");
        Arquero ixchel = new Arquero("Ixchel", 10);

        System.out.println("\n--- ESTADO INICIAL ---");
        ragnar.mostrarEstado();
        merlina.mostrarEstado();
        ixchel.mostrarEstado();

        System.out.println("\n--- RONDA 1 ---");
        ragnar.golpeDeEspada(merlina);
        merlina.bolaDefuego(ragnar);
        ixchel.lluviaDeFlechas(ragnar);

        System.out.println("\n--- ESTADO TRAS RONDA 1 ---");
        ragnar.mostrarEstado();
        merlina.mostrarEstado();
        ixchel.mostrarEstado();

        System.out.println("\n--- RONDA 2 ---");
        merlina.curacion(merlina);
        ragnar.atacar(ixchel, 10);
        ixchel.dispararFlecha(merlina);

        System.out.println("\n--- ESTADO TRAS RONDA 2 ---");
        ragnar.mostrarEstado();
        merlina.mostrarEstado();
        ixchel.mostrarEstado();
    }
}
