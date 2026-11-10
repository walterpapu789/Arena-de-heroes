public class Sanador extends Personaje {
    private int bendicionesUsadas;

    public Sanador(String nombre) {
        super(nombre, 100, 100, 100, 100, 1);
        this.bendicionesUsadas = 0;
    }

    public void bendicion(Personaje aliado) {
        if (!estaVivo() || !gastarEnergia(20)) {
            return;
        }
        System.out.println("[Luz] " + getNombre() + " bendice a " + aliado.getNombre());
        aliado.curar(30);
        bendicionesUsadas++;
    }

    public int getBendicionesUsadas() {
        return bendicionesUsadas;
    }
}
