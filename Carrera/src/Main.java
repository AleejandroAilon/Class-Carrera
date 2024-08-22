import java.util.ArrayList;
// Alejandro Ailón | 5090 - 23 - 1070
// ---------------------------------------------- Equipo ---------------------------------------------------
class Equipo{
    private String nombre;
    private double totalTiempo;
    private String pais;
    private ArrayList<Ciclista> ciclistas;

    Equipo(String nombre, String pais){
        this.nombre = nombre;
        this.pais = pais;
        this.ciclistas = new ArrayList<>();
    }

    String getNombre(){
        return nombre;
    }

    void setNombre(String nombre){
        this.nombre = nombre;
    }

    String getPais(){
        return pais;
    }

    void setPais(String pais){
        this.pais = pais;
    }

    // Métodos
    public void añadirCiclista(Ciclista ciclista){
        ciclistas.add(ciclista);
    }

    public void listarEquipo(){
        System.out.println("Lista de ciclistas en el equipo: " + this.nombre + ":");
        for(Ciclista ciclista : ciclistas){
            ciclista.Imprimir();
            System.out.println("Tipo: " + ciclista.ImprimirTipo());
            System.out.println();
        }
    }

    public Ciclista buscarCiclista(int identificador){
        for(Ciclista ciclista : ciclistas){
            if(ciclista.getIdentificador() == identificador){
                return ciclista;
            }
        }
        return null;
    }

    public void calcularTotalTiempo(){
        if(ciclistas.isEmpty()){
            totalTiempo = 0;
            return;
        }
        double sumaTiempo = 0;
        for(Ciclista ciclista : ciclistas){
            sumaTiempo += ciclista.getTiempoAcumulado();
        }
        totalTiempo = sumaTiempo / ciclistas.size();
    }

    public void Imprimir(){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Pais: " + this.pais);
        System.out.println("Total de tiempo acumulado: " + totalTiempo);
        System.out.println();
    }
}

// ------------------------------------------------ Ciclista ---------------------------------------------------
class Ciclista {
    private int identificador;
    private String nombre;
    private int tiempoAcumulado;

    Ciclista(int identificador, String nombre){
        this.identificador = identificador;
        this.nombre = nombre;
        this.tiempoAcumulado = 0;
    }

    int getIdentificador(){
        return identificador;
    }

    void setIdentificador(int identificador){
        this.identificador = identificador;
    }

    String getNombre(){
        return nombre;
    }

    void setNombre(String nombre){
        this.nombre = nombre;
    }

    int getTiempoAcumulado(){
        return tiempoAcumulado;
    }

    void setTiempoAcumulado(int tiempoAcumulado){
        this.tiempoAcumulado = tiempoAcumulado;
    }

    public void Imprimir(){
        System.out.println("Identificador: " + this.identificador);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Tiempo acumulado: " + this.tiempoAcumulado);
    }

    public String ImprimirTipo(){
        return "Tipo: Ciclista";
    }
}

// -------------------------------------------------- Velocista -------------------------------------------
class Velocista extends Ciclista{
    private double potenciaPromedio;
    private double velocidadPromedio;

    Velocista(int identificador, String nombre, double potenciaPromedio, double velocidadPromedio){
        super(identificador, nombre);
        this.potenciaPromedio = potenciaPromedio;
        this.velocidadPromedio = velocidadPromedio;
    }

    void setPotenciaPromedio(double potenciaPromedio){
        this.potenciaPromedio = potenciaPromedio;
    }

    double getPotenciaPromedio(){
        return potenciaPromedio;
    }

    void setVelocidadPromedio(double velocidadPromedio){
        this.velocidadPromedio = velocidadPromedio;
    }

    double getVelocidadPromedio(){
        return velocidadPromedio;
    }

    @Override
    public void Imprimir(){
        super.Imprimir();
        System.out.println("Potencia promedio: " + this.potenciaPromedio);
        System.out.println("Velocidad promedio: " + this.velocidadPromedio);
    }

    @Override
    public String ImprimirTipo(){
        return "Tipo: Velocista";
    }
}

// ---------------------------------------------------- Escalador -----------------------------------------------
class Escalador extends Ciclista{
    private double aceleracionPromedio;
    private double gradoRampa;

    Escalador(int identificador, String nombre, double aceleracionPromedio, double gradoRampa){
        super(identificador, nombre);
        this.aceleracionPromedio = aceleracionPromedio;
        this.gradoRampa = gradoRampa;
    }

    void setAceleracionPromedio(double aceleracionPromedio){
        this.aceleracionPromedio = aceleracionPromedio;
    }

    double getAceleracionPromedio(){
        return this.aceleracionPromedio;
    }

    void setGradoRampa(double gradoRampa){
        this.gradoRampa = gradoRampa;
    }

    double getGradoRampa(){
        return this.gradoRampa;
    }

    @Override
    public void Imprimir(){
        super.Imprimir();
        System.out.println("Aceleracion promedio: " + this.aceleracionPromedio);
        System.out.println("Grado Rampa: " + this.gradoRampa);
    }

    @Override
    public String ImprimirTipo(){
        return "Tipo: Escalador";
    }
}

// ------------------------------------------------------- Contrarrelojista ------------------------------------------------
class Contrarrelojista extends Ciclista{
    private double velocidadMaxima;

    Contrarrelojista(int identificador, String nombre, double velocidadMaxima){
        super(identificador, nombre);
        this.velocidadMaxima = velocidadMaxima;
    }

    double getVelocidadMaxima(){
        return this.velocidadMaxima;
    }

    void setVelocidadMaxima(double velocidadMaxima){
        this.velocidadMaxima = velocidadMaxima;
    }

    @Override
    public void Imprimir(){
        super.Imprimir();
        System.out.println("Velocidad maxima: " + this.velocidadMaxima);
    }

    public String ImprimirTipo(){
        return "Tipo: Contrarrelojista";
    }
}

// --------------------------------------------------------------- Main -----------------------------------------------------
public class Main{
    public static void main(String[] args){
        Equipo equipo = new Equipo("Ruedas de Acero", "Guatemala");


        Velocista vel = new Velocista(1, "Alejandro", 150, 35);
        vel.setTiempoAcumulado(110);

        Escalador escalador1 = new Escalador(3, "Jackeline", 310, 20);
        escalador1.setTiempoAcumulado(100);

        Contrarrelojista contra1 = new Contrarrelojista(4, "Aniston", 75);
        contra1.setTiempoAcumulado(150);

        equipo.añadirCiclista(vel);
        equipo.añadirCiclista(escalador1);
        equipo.añadirCiclista(contra1);

        equipo.calcularTotalTiempo();
        System.out.println("-------------------------------------------------------------------------");
        equipo.Imprimir();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("____________________________________________________________________");
        equipo.listarEquipo();
        System.out.println("____________________________________________________________________");

    }
}