public class Guerrero extends Personaje {
    private int furia;
    private int furiaMaxima;

    public Guerrero(String nombre) {
        // nombre, vida (150), vidaMaxima (150), energia (60), energiaMaxima (60), nivel (1)
        super(nombre, 150, 150, 60, 60, 1);
        this.furiaMaxima = 100;
        this.furia = 0;
    }

    public int getFuria() {
        return furia;
    }

    public void golpeDeEspada(Personaje objetivo) {
        if (!estaVivo() || !gastarEnergia(15)) {
            return;
        }
        System.out.println("[Espada] " + getNombre() + " lanza un GOLPE DE ESPADA a " + objetivo.getNombre());
        objetivo.recibirDanio(25);
        acumularFuria(30);
    }

    public void gritoDeGuerra() {
        if (!estaVivo()) {
            return;
        }
        acumularFuria(20);
        System.out.println("[Grito] " + getNombre() + " ruge y acumula furia. Furia actual: " + furia);
    }

    public void ataqueFurioso(Personaje objetivo) {
        if (!estaVivo()) {
            return;
        }
        if (furia < 50) {
            System.out.println(getNombre() + " no tiene suficiente furia para el Ataque Furioso.");
            return;
        }
        furia -= 50;
        System.out.println("[Furia] ¡" + getNombre() + " desata un ATAQUE FURIOSO contra " + objetivo.getNombre() + "!");
        objetivo.recibirDanio(40);
    }

    private void acumularFuria(int cantidad) {
        furia += cantidad;
        if (furia > furiaMaxima) {
            furia = furiaMaxima;
        }
    }
}
