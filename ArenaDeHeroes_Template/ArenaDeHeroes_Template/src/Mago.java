public class Mago extends Personaje {
    private String elemento;

    public Mago(String nombre, String elemento) {
        super(nombre, 100, 100, 80, 80, 1);
        this.elemento = elemento;
    }

    public String getElemento() {
        return elemento;
    }

    //hechizo de ataque
    public void bolaDefuego(Personaje objetivo) {
        if (!estaVivo() || !gastarEnergia(20)) {
            return;
        }
        System.out.println("Bola de Fuego " + getNombre() + " lanza una BOLA DE FUEGO a " + objetivo.getNombre());
        objetivo.recibirDanio(30);
    }

    public void curacion(Personaje aliadoPersonaje) {
        if (!estaVivo() || !gastarEnergia(15)) {
            return;
        }
        System.out.println("Curación " + getNombre() + " lanza un HECHIZO DE CURACIÓN a " + aliadoPersonaje.getNombre());
        aliadoPersonaje.recibirCuracion(40);
    }

}
