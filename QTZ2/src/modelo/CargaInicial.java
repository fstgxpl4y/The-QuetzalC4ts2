package modelo;

public class CargaInicial {

    private CargaInicial() { }

    public static void cargar(CatalogoModulos catalogo) {

        catalogo.agregar(new CamaraOrbital(101, "Basic Cat Cam", 100, 450, 6, 12));
        catalogo.agregar(new CamaraOrbital(102, "Bird Cat Eye", 85, 900, 9, 20));
        catalogo.agregar(new SensorClimaEspacial(103, "Sensor Doge", 100, 600, 5, "Radiacion solar", 7));
        catalogo.agregar(new SensorClimaEspacial(104, "Sensor Snache", 70, 380, 4, "Campo magnetico", 5));


        catalogo.agregar(new AntenaParabolica(201, "Antena Tank Cat", 100, 1200, 8, 40, 3.5));
        catalogo.agregar(new AntenaParabolica(202, "Antena Cat Base", 90, 2500, 14, 70, 6.0));
        catalogo.agregar(new AntenaYagi(203, "Yagi Axe Cat", 100, 520, 5, 25, 8));

        catalogo.agregar(new PanelSolar(301, "Panel Worker Cat", 100, 700, 30, 85));
        catalogo.agregar(new PanelSolar(302, "Panel Cat Cannon", 95, 1800, 60, 90));
        catalogo.agregar(new Bateria(303, "Bateria Cat Food", 100, 950, 100, 40));
        catalogo.agregar(new Bateria(304, "Bateria Titan Cat", 80, 2100, 200, 120));
    }
}
