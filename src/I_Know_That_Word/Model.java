package I_Know_That_Word;
import java.util.ArrayList;
import java.util.Collections;


/**
 * rules of the game
 */
public class Model {
    public Palabras palabra;
    public int palabrasVistas, palabrasLevel, estado, aciertos, aciertosNecesarios, porcentaje;
    public ArrayList<String> bancoPalabras, arrayPalabrasLevel, arrayPalabrasVistas;

    /**
     * constructor
     */
    public Model(){

        palabra = new Palabras();
        palabrasLevel = 0;
        palabrasVistas = 0;
        estado = 0;
        aciertos = 0;
        aciertosNecesarios = 0;
        porcentaje = 0;
        bancoPalabras = new ArrayList<String>();
        arrayPalabrasLevel = new ArrayList<String>();
        arrayPalabrasVistas = new ArrayList<String>();
        bancoPalabras = new palabra.getPalabras();

    }

    /**
     *metodos
     */
    public int nivelPalabras (int nivelxJugar){
        switch (nivelxJugar){
            case 1:
                palabrasVistas = 10;
                palabrasLevel = 20;
                aciertosNecesarios = 70;
                break;
            case 2:
                palabrasVistas = 20;
                palabrasLevel = 40;
                aciertosNecesarios = 70;
                break;
            case 3:
                palabrasVistas = 25;
                palabrasLevel = 50;
                aciertosNecesarios = 75;
                break;
            case 4:
                palabrasVistas = 30;
                palabrasLevel = 60;
                aciertosNecesarios = 80;
                break;
            case 5:
                palabrasVistas = 30;
                palabrasLevel = 70;
                aciertosNecesarios = 80;
                break;
            case 6:
                palabrasVistas = 30;
                palabrasLevel = 70;
                aciertosNecesarios = 80;
                break;
            case 7:
                palabrasVistas = 50;
                palabrasLevel = 100;
                aciertosNecesarios = 90;
                break;
            case 8:
                palabrasVistas = 60;
                palabrasLevel = 120;
                aciertosNecesarios = 90;
                break;
            case 9:
                palabrasVistas = 70;
                palabrasLevel = 140;
                aciertosNecesarios = 95;
                break;
            case 10:
                palabrasVistas = 100;
                palabrasLevel = 200;
                aciertosNecesarios = 100;
                break;
                /**default:
                JOptionPane.showMessageDialog(null, "Error de sistema.");
                System.exit(0);
                break;
                 */

        }
        return palabrasLevel;
    }

    /**
     * Selecciona las palabras que se van a usar en el level
     * @return
     */
    public ArrayList<String> getArrayPalabrasLevel(){
        for ( int i = 0; i < palabrasLevel; i++){
            int seleccionador = (int)(Math.random() * bancoPalabras.size());
            if (!arrayPalabrasLevel.contains(bancoPalabras.get(seleccionador))) {
                arrayPalabrasLevel.add(bancoPalabras.get(seleccionador));
            }
            else {
                i = i - 1;
            }
        }
        return arrayPalabrasLevel;
    }

    /**
     *define las palabras correctas para el nivel
     * @return
     */

    public ArrayList<String> getArrayPalabrasMemorizar() {

        for (int i = 0; i < palabrasLevel / 2; i++) {
            int auxiliar = (int) (Math.random() * arrayPalabrasLevel.size());
            if (!arrayPalabrasVistas.contains(arrayPalabrasLevel.get(auxiliar))) {
                arrayPalabrasVistas.add(arrayPalabrasLevel.get(auxiliar));
            } else {
                i = i - 1;
            }
        }
        return arrayPalabrasVistas;
    }

    /**
     * Verifica si la palabra se encuentra en el level
     * @param palabra
     * @return
     */

    public boolean palabraEstaEnNivel(String palabra) {

        if (arrayPalabrasVistas.contains(palabra)) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * calcula el porcentaje de acierto
     * @return
     */



    public int calcularPorcentaje() {

        porcentaje = (aciertos * 100) / palabrasLevel;

        return porcentaje;
    }

    /**
     * Calcula si se superó el nivel
     * @return
     */
    public boolean LevelSucess() {
        if (porcentaje >= aciertosNecesarios) {
            return true;
        } else {
            return false;
        }
    }
}
