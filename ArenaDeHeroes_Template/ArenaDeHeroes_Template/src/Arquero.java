public class Arquero extends Personaje {
    private int flechas;

    public Arquero(String nombre, int flechas) {
        // nombre, vida (110), vidaMaxima (110), energia (80), energiaMaxima (80), nivel (1)
        super(nombre, 110, 110, 80, 80, 1);
        this.flechas = flechas;
    }

    public int getFlechas() {
        return flechas;
    }

    public void dispararFlecha(Personaje objetivo) {
        if (!estaVivo() || !gastarEnergia(10)) {
            return;
        }
        if (flechas <= 0) {
            System.out.println(getNombre() + " no tiene flechas para disparar.");
            return;
        }
        flechas--;
        System.out.println("[Flecha] " + getNombre() + " dispara una FLECHA a " + objetivo.getNombre() + " (Flechas restantes: " + flechas + ")");
        objetivo.recibirDanio(20);
    }

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

    public void recargarFlechas(int c) {
        if (!estaVivo()) {
            return;
        }
        if (c > 0) {
            flechas += c;
            System.out.println(getNombre() + " recarga flechas. Flechas actuales: " + flechas);
        }
    }
}
