public class Main {
    public static void main(String[] args) {
        System.out.println("=== BIENVENIDOS A LA ARENA DE HEROES ===");

        Guerrero ragnar = new Guerrero("Ragnar");
        Mago merlina = new Mago("Merlina", "fuego");
        Arquero ixchel = new Arquero("Ixchel", 10);

        System.out.println("--- ESTADO INICIAL ---");
        ragnar.mostrarEstado();
        merlina.mostrarEstado();
        ixchel.mostrarEstado();

        // Ronda 1
        System.out.println("--- RONDA 1 ---");
        ragnar.golpeDeEspada(merlina);
        merlina.bolaDeFuego(ragnar);
        ixchel.lluviaDeFlechas(ragnar);

        System.out.println("--- ESTADO TRAS RONDA 1 ---");
        ragnar.mostrarEstado();
        merlina.mostrarEstado();
        ixchel.mostrarEstado();

        // Ronda 2
        System.out.println("--- RONDA 2 ---");
        merlina.curacionArcana(merlina);
        ragnar.atacar(ixchel, 10); // Usa tu método con (objetivo, danio)
        ixchel.dispararFlecha(merlina);

        System.out.println("--- ESTADO TRAS RONDA 2 ---");
        ragnar.mostrarEstado();
        merlina.mostrarEstado();
        ixchel.mostrarEstado();
    }
}
