package principal;

import conexion.Conexion;
import dao.PersonaDao;
import ventanas.VentanaCombo;
import vo.PersonaVo;

public class Relaciones {
    public void iniciar() {
        VentanaCombo miVentanaCombo = new VentanaCombo();
        Coordinador miCoordinador = new Coordinador();

        miVentanaCombo.setCoordinador(miCoordinador);
        miVentanaCombo.cargarRegistros();

        miVentanaCombo.setVisible(true);
    }
}
