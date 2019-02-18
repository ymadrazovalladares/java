package grupo;

public class DesdeHacia {

    private int desde;
    private int hacia;

    public DesdeHacia(int desde, int hacia) {
        this.desde = desde;
        this.hacia = hacia;
     }

    public int getDesde() {
        return desde;
    }


    public void setDesde(int desde) {
        this.desde = desde;
    }

    public int getHacia() {
        return hacia;
    }

    public void setHacia(int hacia) {
        this.hacia = hacia;
    }
}
