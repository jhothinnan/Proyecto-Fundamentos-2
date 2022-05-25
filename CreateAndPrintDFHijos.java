/**
 *La clase CreateAndPrintDFHijos tiene de atributos de clase un arreglo dinamico llamado headers de tipo string que almacenara las cabeceras del archivo
 *csv, un arreglo dinamico de tipo entero que no ha sido inicializado, un objeto de tipo DataFrame llamado df y un entero que indicara cuando se halla
 *realizado como minimo una vez el metodo readFileAndCreateDF. Ademas posee 3 distintos metodos de clase: readFileAndCreateDF, printDF y moreChildrenMother.
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CreateAndPrintDFHijos{ 
    static ArrayList<String> headers = new ArrayList<>();
    static ArrayList<Integer> row;
    static DataFrame dfhijos = new DataFrame (headers);
    static int cont = 0;
    /**
     * El metodo readFileAndCreateDF se encarga de leer el archivo de tipo csv, en donde va a la primer linea, la lee y la guarda en el Arraylist headers
     * y a partir ese punto los siguientes datos de tipo enteros los guarada en el arraylist de tipo enteros, row, para finalmente almazenarlos en el dfhijos.
     * Se invoca despues de haber guardado todos los datos del archivo el metodo printDF y se le suma 1 al contador, esto para que si el usuario desea
     * volver a leer el archivo se cumpla el condicional a partir de eso se eliminaran todos los datos almacenados al haber invocado el metodo cleardf 
     * y se vuelven a escanear, esto para que de cara al usuario los datos no se repitan a la hora de imprimirlos.
     */
    public static void readFileAndCreateDF() throws FileNotFoundException{
        Scanner scan = new Scanner(new File("hijos.csv"));
        String line = scan.nextLine();
        Scanner lineScan = new Scanner(line);
        lineScan.useDelimiter(",");
        headers.clear();
        
        if(cont!=0){
            dfhijos.cleardf();
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
            dfhijos.addRow(row);
            cont++;
        }
    }
    /**
     * Invoca al metodo que imprime los datos almacenados en el DF
     */
    public static void printDF(){
        dfhijos.printDF();
    }
    /**
     * El metodo shortestChild posee 3 atributos todos de tipo entero, el primero que marca el indice
     * del niño con la menor estatura y los otros 2 que marcan la posicion en el arreglo headers de la columna nombrada estatura y de la columna nombrada
     * id respectivamente, internamente el ciclo compara y analiza todos los niños para retornar el id del niño con menor altura.
     * @param hijos: Dataframe que posee toda la informacion de los hijos
     */
    public static int shortestChild(DataFrame hijos){
        int minHeightChild = 0; 
        int heigthColumn = hijos.headers.indexOf("estatura");
        int childColumn = hijos.headers.indexOf("id");
        for(int i = 1; i < hijos.data.size(); i++){
            if(hijos.data.get(minHeightChild).get(heigthColumn) > hijos.data.get(i).get(heigthColumn)){
                minHeightChild = i;
            }
        }
        return hijos.data.get(minHeightChild).get(childColumn);
    }
}
