import java.util.ArrayList;
/**
 * En esta clase se guardan los datos de un DataFrame.
 * 
 * @Anderson Sebastian Jimenez Mercado, Jhonnathan Stiven Ocampo Diaz
 * @Mayo 2022
 */
public class DataFrame{
    ArrayList<Integer> row;
    ArrayList<String> headers;
    ArrayList<ArrayList<Integer>> data;
    /**
     * Constructor.
     * @param headers: ArrayList con los nombres de las columnas
     */
    public DataFrame(ArrayList<String> headers) {
        this.data = new ArrayList<>();
        this.headers = headers;
    }
    
    /**
     * Permite agregar una fila a los datos.
     * @param f: ArrayList con los enteros de una fila
     */
    public void addRow(ArrayList<Integer> f) {
        data.add(f);
    }
    /**
     * Elimina todos los datos del Df
     */
    public void cleardf(){
        this.data.clear();
    }
    /**
     * Permite imprimir el DataFrame.
     * Primero se imprimen los encabezados y luego cada fila de datos.
     */
    public void printDF() {
        for(String e: headers) {
            System.out.print(e + " ");
        }
        System.out.println();
        for(ArrayList<Integer> f: data) {
            for(Integer i: f) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
