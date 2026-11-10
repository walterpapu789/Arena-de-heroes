public class Personaje {
private String nombre;
private int vida;
private int vidaMaxima;
private int energia;
private int energiaMaxima;
private int nivel;

//hacemos el constructor  bro de la clase personaje, que recibe el nombre, vida, energia y nivel del personaje

public Personaje(String nombre, int vida, int vidaMaxima, int energia, int energiaMaxima, int nivel) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.energiaMaxima = energiaMaxima;
        this.nivel = nivel;
        this.vida = vida;
        this.energia = energia;
    }

//getters y setters para los atributos de la clase personaje

public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getEnergia() {
        return energia;
    }

    public int getEnergiaMaxima() {
        return energiaMaxima;
    }

    public int getNivel() {
        return nivel;
    }
 
    //metodo para recibir daño, que recibe un int de daño y lo resta a la vida del personaje, si la vida es menor a 0, la vida se pone en 0
    public boolean estaVivo() {
        return vida > 0;
    }

    public void recibirDanio(int cantidad) {
        if (cantidad < 0 || !estaVivo()) {
            return;
        }

        vida -= cantidad;
        if (vida < 0) {
            vida = 0;  //inicializamos la vida en  porque nunca es negativa

        }
        System.out.println(nombre + " ha recibido " + cantidad + " de daño. Vida actual: " + vida);
        if (!estaVivo()) {
            System.out.println(nombre + " ha muerto.");
        }
    }

    public void curar(int cantidad) {
        if (cantidad < 0 || !estaVivo()) {
            return;
        }

        vida = vida + cantidad;
        if (vida > vidaMaxima) {
            vida = vidaMaxima; // La vida no puede superar la vida máxima
        }
        System.out.println(nombre + " ha sido curado en " + cantidad + ". Vida actual: " + vida);
    }
public void descansar(){
        if (!estaVivo()) {
            System.out.println(nombre + " no puede descansar porque está muerto.");
            return;
        }

       int recuperacion = (int) (energiaMaxima * 0.2); // Recupera el 20% de la energía máxima
        energia += recuperacion;
        if (energia > energiaMaxima) {
            energia = energiaMaxima; // La energía no puede superar la energía máxima
        }
        System.out.println(nombre + " ha descansado y recuperado " + recuperacion + " de energía. Energía actual: " + energia);
    }

    public void subirNivel() {
        nivel++;
        vidaMaxima += 10; // Incrementa la vida máxima en 10
        energiaMaxima += 5; // Incrementa la energía máxima en 5
        vida = vidaMaxima; // Restaura la vida al máximo
        energia = energiaMaxima; // Restaura la energía al máximo
        System.out.println(nombre + " ha subido al nivel " + nivel + ". Vida máxima: " + vidaMaxima + ", Energía máxima: " + energiaMaxima);

    }


   public void atacar(Personaje objetivo, int danio) {
        if (!estaVivo()) {
            System.out.println(nombre + " no puede atacar porque está muerto.");
            return;
        }

        if (!objetivo.estaVivo()) {
            System.out.println(objetivo.getNombre() + " ya está muerto. No se puede atacar.");
            return;
        }

        if (energia < 10) { // Supongamos que cada ataque consume 10 de energía
            System.out.println(nombre + " no tiene suficiente energía para atacar.");
            return;
        }

        energia -= 10; // Consume energía por el ataque
        System.out.println(nombre + " ataca a " + objetivo.getNombre() + " causando " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Vida: " + vida + "/" + vidaMaxima);
        System.out.println("Energía: " + energia + "/" + energiaMaxima);
        System.out.println("Nivel: " + nivel);
    }

    // Método protegido para las clases hijas
    protected boolean gastarEnergia(int costo) {
        if (costo < 0 || this.energia < costo) {
            return false;
        }
        this.energia -= costo;
        return true;
         
    }

    public void recibirCuracion(int cantidad) {
        curar(cantidad);
    }
    }
