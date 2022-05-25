/**
 *La clase CreateAndPrintDFMadres tiene de atributos de clase un arreglo dinamico llamado headers de tipo string que almacenara las cabeceras del archivo
 *csv, un arreglo dinamico de tipo entero que no ha sido inicializado, un objeto de tipo DataFrame llamado df y un entero que indicara cuando se halla
 *realizado como minimo una vez el metodo readFileAndCreateDF. Ademas posee 3 distintos metodos de clase: readFileAndCreateDF, printDF y moreChildrenMother.
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CreateAndPrintDFMadres{ 
    static ArrayList<String> headers = new ArrayList<>();
    static ArrayList<Integer> row;
    static DataFrame dfmadres = new DataFrame(headers);
    static int cont = 0;
    /**
     * El metodo readFileAndCreateDF se encarga de leer el archivo de tipo csv, en donde va a la primer linea, la lee y la guarda en el Arraylist headers
     * y a partir ese punto los siguientes datos de tipo enteros los guarada en el arraylist de tipo enteros, row, para finalmente almazenarlos en el dfmadres.
     * Se invoca despues de haber guardado todos los datos del archivo el metodo printDF y se le suma 1 al contador, esto para que si el usuario desea
     * volver a leer el archivo se cumpla el condicional a partir de eso se eliminaran todos los datos almacenados al haber invocado el metodo cleardf 
     * y se vuelven a escanear, esto para que de cara al usuario los datos no se repitan a la hora de imprimirlos.
     */

    public static void readFileAndCreateDF() throws FileNotFoundException{
        Scanner scan = new Scanner(new File("madres.csv"));
        String line = scan.nextLine();
        Scanner lineScan = new Scanner(line);
        lineScan.useDelimiter(",");
        headers.clear();
        
        if(cont!=0){
            dfmadres.cleardf();
        }
        
        while(lineScan.hasNext()) {
            headers.add(lineScan.next());
        }
        
        while(scan.hasNextLine()) {
            line = scan.nextLine();
            lineScan = new Scanner(line);
            lineScan.useDelimiter(",");
            row = new ArrayList<>();
            while(lineScan.hasNextInt()) {
                row.add(lineScan.nextInt());
            }
            dfmadres.addRow(row);
            cont++;
        }
    }
    /**
     * Invoca al metodo que imprime los datos almacenados en el DF
     */
    public static void printDF(){
        dfmadres.printDF();
    }
    /**
     * El metodo moreChildrenMother posee de parametro un objeto de tipo DataFrame ademas posee como atributos 2 arraylist de enteros uno que sirve para 
     * identificar cada una de las madres que existen y el otro que se usara a manera de contador, en adicion este metodo posee dos enteros, uno que
     * indicara la posicion de la madre con mas hijos y el otro que marca la posicion en el arraylist headers de la columna llamada madres.
     * Dentro del metodo se analiza si existe esa madre en el arraylist mothers y se suma 1 a su aumulador en caso contrario se agrega la madre y su
     * acumulador. Despues de eso se analiza la posicion que tenga el acumulador mas alto y finalmente retorna la madre con el mayor numero de hijos
     * @param a: DataFrame que contiene la informacion de los hijos
     */
    public static int moreChildrenMother(DataFrame a){
        ArrayList<Integer> mothers = new ArrayList<>();
        ArrayList<Integer> mothersAccumulator = new ArrayList<>();    
        int maxMotherPosition = 0;
        int motherColumn = a.headers.indexOf("madre");

        for(int i = 0; i < a.data.size(); i++){
            if(!mothers.contains(a.data.get(i).get(motherColumn))){
                mothers.add(a.data.get(i).get(motherColumn));
                mothersAccumulator.add(1);
            }else{
                mothersAccumulator.set(mothers.indexOf(a.data.get(i).get(motherColumn)), 1 + mothersAccumulator.get(mothers.indexOf(a.data.get(i).get(motherColumn))));
            }
        }        

        for(int i = 1; i < mothersAccumulator.size(); i++){
            if(mothersAccumulator.get(i) > mothersAccumulator.get(maxMotherPosition)){
                maxMotherPosition = i;
            }
        }

        return mothers.get(maxMotherPosition);
    }
}
