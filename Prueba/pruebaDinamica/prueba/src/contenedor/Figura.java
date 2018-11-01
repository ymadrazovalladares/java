package contenedor;

public class Figura {
    String Color;
    int TotalPuntos;
    ListaNodos aNodoPuntos;

    public Figura(String color, ListaNodos listaPuntos)
    {
        Color = color;
        TotalPuntos = listaPuntos.totalAlmacenados;
        this.aNodoPuntos = listaPuntos;
    }
    public Figura()
    {
        Color = "";
        TotalPuntos = 0;
        this.aNodoPuntos = null;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getTotalPuntos() {
        return TotalPuntos;
    }

    public void setTotalPuntos(int totalPuntos) {
        TotalPuntos = totalPuntos;
    }

    public ListaNodos getaNodoPuntos() {
        return aNodoPuntos;
    }

    public void setaNodoPuntos(ListaNodos aNodoPuntos) {
        this.aNodoPuntos = aNodoPuntos;
    }
}
