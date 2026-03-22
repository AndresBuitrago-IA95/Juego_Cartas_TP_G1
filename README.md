<<<<<<< HEAD
## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
=======
# Juego_Cartas_TP_G1
Examen #1
Integrantes:
Andres Ferney Buitrago Suarez

4.1 Obtener los grupos en escalera de la misma pinta, es decir, secuencias de cartas que
tengan la misma pinta. Por ejemplo: 10, J, Q y K de Pica conforman una cuarta de pica.

Se crea una matriz boolean[4][13] (4 pintas x 13 nombres) que marca qué cartas tiene el jugador

Se recorre cada pinta y se buscan posiciones consecutivas con true. Cuando la secuencia tiene 2 o más cartas seguidas, se registra como escalera usando el enum Grupo para nombrar la longitud (PAR, TERNA, CUARTA, etc.

Se usa una segunda matriz boolean[4][13] llamada enEscalera para marcar cuáles cartas quedaron dentro de una escalera, y así excluirlas del cálculo de puntos.

4.2 Calcular el puntaje del jugador con base en el valor de las cartas que no conforman
grupos, teniendo en cuenta que las cartas (“Ace”, “Jack”, “Queen”, y “King” valen 10 y el
resto, el respectivo número del nombre.

Se le agregó un campo valor a cada constante del enum y un método getValor(). AS, JACK, QUEEN y KING se les asignó 10, y al resto su número (DOS=2, TRES=3... DIEZ=10)..

Para cada una de esas cartas se llama carta.getNombre().getValor() y se acumula el puntaje, que se muestra al final del resumen como "Puntos: X"

>>>>>>> 3c7487616a509fa67e5042f30f24bd5d92a7b93a
