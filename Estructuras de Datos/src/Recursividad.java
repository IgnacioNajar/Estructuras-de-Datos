public class Recursividad {
    void repetir() {
        repetir(); //Se vuelve a llamar a la función y se reservan 4 bytes de nuevo
    }

    public static void main(String[] ar) {
        Recursividad recursividad = new Recursividad();
        recursividad.repetir(); //Se reservan 4 bytes
    }
}