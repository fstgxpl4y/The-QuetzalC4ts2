# Quetzal-2: Defensa de QTZ2 (tema The Battle Cats)

Simulador de consola en Java. Patrón MVC + herencia/polimorfismo según el UML del proyecto.

## Estructura
- `src/modelo/`      ModuloSatelite y su jerarquía, EstadoMision, CatalogoModulos, CargaInicial
- `src/vista/`       VistaConsola
- `src/controlador/` ControladorSimulador
- `src/Main.java`    Driver program

## Compilar y ejecutar
    mkdir out
    javac -encoding UTF-8 -d out $(find src -name "*.java")     # Windows: dir /s /b src\*.java > fuentes.txt && javac -d out @fuentes.txt
    java -cp out Main

## Menú
1 Listar | 2 Buscar por ID | 3 Buscar por nombre | 4 Ordenar por costo (asc/desc) | 0 Salir

## Git (ramas sugeridas)
    git init && git checkout -b main
    git checkout -b feature/modelo-modulos      # ModuloSatelite + jerarquía + EstadoMision
    git checkout -b feature/catalogo-carga      # CatalogoModulos + CargaInicial
    git checkout -b feature/vista-controlador   # VistaConsola + ControladorSimulador + Main
(hacer commits por rama y fusionar a main con merge)
