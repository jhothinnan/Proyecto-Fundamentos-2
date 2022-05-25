import java.util.Scanner;
import java.util.ArrayList;

/**
 *La clase main se encarga de ofrecer de cara al usuaro una manera de ejecutar e interactuar con el programa; el usuario puede escoger entre 6 opciones
 *tales como leer y almacenar archivos de tipo .csv en arreglos dinamicos, imprimir los datos que almacenan estos arreglos y se desarrollaron 2 
 *funcionalidades: Buscar la madre (en el archivo madres.csv) que posea la mayor cantidad de hijos y buscar (en el archivo hijos.csv) 
 *el hijo mas pequeño en estatura.
 */
public class Main{
    /**
     * El metodo main ejecuta el metodo mostrarMenu
     */
    public static void main(String [] args) throws java.io.FileNotFoundException {
        Main.mostrarMenu();
    }
    
    /**
     * El metodo mostrar menu inicia un ciclo infinito en donde a traves de datos de entrada por pantalla se elige entre las 6 opciones disponibles. Al 
     * ingresar el numero 0 el programa detiene su ejecucion.
     */
    public static void mostrarMenu() throws java.io.FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int option;
        while(true){
            System.out.println("+---------------------------------------------------+");
            System.out.println("    Seleccione que desea realizar");
            System.out.println("+---------------------------------------------------+");
            System.out.println("    0. Si desea terminar la ejecución del programa");
            System.out.println("+---------------------------------------------------+");
            System.out.println("    1. Leer archivo de madres");
            System.out.println("+---------------------------------------------------+");
            System.out.println("    2. Imprimir archivo de madres");
            System.out.println("+---------------------------------------------------+");
            System.out.println("    3. Leer archivo de hijos");
            System.out.println("+---------------------------------------------------+");
            System.out.println("    4. Imprimir archivo de hijos");
            System.out.println("+---------------------------------------------------+");
            System.out.println("    5. Buscar madre con mayor número de hijos");
            System.out.println("+---------------------------------------------------+");
            System.out.println("    6. Buscar hijo con menor estatura");
            System.out.println("+---------------------------------------------------+");
            System.out.println("    Por favor digite su opción");
            System.out.println("+---------------------------------------------------+");
            System.out.println();
            option = scan.nextInt(); 
           if(option==0){
               System.out.println();
               System.out.println("Se ha terminado la ejecucion del programa");
               System.out.println();
               break;
           }
           switch(option){
               case 1:
                   System.out.println();
                   CreateAndPrintDFMadres.readFileAndCreateDF();
                   System.out.println("Se ha leido correctamente el archivo madres"+"\n");
                   System.out.println();
                   break;
               case 2:
                   System.out.println();
                   CreateAndPrintDFMadres.printDF();
                   System.out.println("\n");
                   System.out.println();
                   break;
               case 3:
                    System.out.println();
                   CreateAndPrintDFHijos.readFileAndCreateDF();
                   System.out.println("Se ha leido correctamente el archivo hijos"+"\n");
                   System.out.println();
                   break;
               case 4:
                   System.out.println();
                   CreateAndPrintDFHijos.printDF();
                   System.out.println("\n");
                   System.out.println();
                   break;
               case 5:
                   System.out.println();
                   int masHijos = CreateAndPrintDFMadres.moreChildrenMother(CreateAndPrintDFHijos.dfhijos);
                   System.out.println("La madre con mas hijos es la que posee el ID: "+masHijos);
                   System.out.println();
                   break;
               case 6:
                   System.out.println();
                   int masBajo = CreateAndPrintDFHijos.shortestChild(CreateAndPrintDFHijos.dfhijos);
                   System.out.println("El hijo con menor estatura es el que posee el ID: "+masBajo);
                   System.out.println();
                   break;
           }
        }
    }
}
