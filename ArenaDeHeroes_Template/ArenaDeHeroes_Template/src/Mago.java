public class Mago extends Personaje {
    private String elemento;

    public Mago(String nombre, String elemento) {
        // nombre, vida (90), vidaMaxima (90), energia (120), energiaMaxima (120), nivel (1)
        super(nombre, 90, 90, 120, 120, 1);
        this.elemento = elemento;
    }

    public String getElemento() {
        return elemento;
    }

    public void bolaDeFuego(Personaje objetivo) {
        if (!estaVivo() || !gastarEnergia(30)) {
            return;
        }
        System.out.println("Magia " + getNombre() + " lanza BOLA DE FUEGO (" + elemento + ") a " + objetivo.getNombre());
        objetivo.recibirDanio(45);
    }

    public void curacionArcana(Personaje aliadoPersonaje) {
        if (!estaVivo() || !gastarEnergia(25)) {
            return;
        }
        System.out.println("[Magia] " + getNombre() + " canaliza CURACION ARCANA sobre " + aliadoPersonaje.getNombre());
        aliadoPersonaje.curar(40);
    }
}
