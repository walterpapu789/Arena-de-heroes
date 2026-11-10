public class Arquero extends Personaje {
    private int flechas;

    // Constructor: vida inicial 110 y energía 80 según la guía
    public Arquero(String nombre, int flechas) {
        super(nombre, 110, 110, 80, 80, 1);
        this.flechas = flechas;
    }

    public int getFlechas() {
        return flechas;
    }

    public void dispararFlecha(Personaje objetivo) {
        if (!estaVivo() || flechas <= 0) {
            System.out.println(getNombre() + " no puede disparar flechas.");
            return;
        }
        System.out.println("[Flecha] " + getNombre() + " dispara una FLECHA a " + objetivo.getNombre());
        objetivo.recibirDanio(20);
        flechas--;
    }

    // Método que pide la guía (hace 50 de daño)
    public void lluviaDeFlechas(Personaje objetivo) {
        if (!estaVivo() || !gastarEnergia(25)) {
            return;
        }
        if (flechas < 3) {
            System.out.println(getNombre() + " no tiene suficientes flechas para Lluvia de Flechas.");
            return;
        }
        flechas -= 3;
        System.out.println("[Flechas] ¡" + getNombre() + " desata una LLUVIA DE FLECHAS sobre " + objetivo.getNombre() + "!");
        objetivo.recibirDanio(50);
    }

    // Método para reponer munición
    public void recogerFlechas(int c) {
        if (!estaVivo()) {
            return;
        }
        if (c > 0) {
            flechas += c;
            System.out.println(getNombre() + " recoge flechas. Flechas actuales: " + flechas);
        }
    }
}