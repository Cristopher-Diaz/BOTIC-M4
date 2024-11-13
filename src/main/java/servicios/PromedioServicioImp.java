package servicios;

import java.util.List;

public class PromedioServicioImp {
    public double calcularPromedio(List<Double> valores) {
        if (valores == null || valores.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (double valor : valores) {
            suma += valor;
        }
        return suma / valores.size();
    }
}
