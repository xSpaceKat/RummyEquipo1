package mvc.cambioFrames;

/**
 *
 * @author galan
 */
public class CambioFrameCrearPartida {

    private int rangoFichas, comodines;

    public CambioFrameCrearPartida(int rangoFichas, int comodines) {
        this.rangoFichas = rangoFichas;
        this.comodines = comodines;
    }

    public int getRangoFichas() {
        return rangoFichas;
    }

    public void setRangoFichas(int rangoFichas) {
        this.rangoFichas = rangoFichas;
    }

    public int getComodines() {
        return comodines;
    }

    public void setComodines(int comodines) {
        this.comodines = comodines;
    }

}
