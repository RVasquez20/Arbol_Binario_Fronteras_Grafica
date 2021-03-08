

package arbol;

import Vista.Main;
import static Vista.Main.Image;
import abinario.ArbolBinario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase principal de la aplicación.
 * @author Rodrigo V.
 */
public class main {

    
    /**
     * Método principal de la aplicación
     * @param args los argumentos de la línea de comando
     */
    public static void main(String[] args) throws InterruptedException {
       
        ArbolBinario arbol_texto=new ArbolBinario();
        Main V=new Main();
        List<Integer> lista=new ArrayList<>();
    String Fronteras="";
    int numero,opc=0;
    do{
        numero=0;
        numero=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero al arbol:","Ingreso",JOptionPane.QUESTION_MESSAGE));
         arbol_texto.insertar(numero);
         opc=Integer.parseInt(JOptionPane.showInputDialog(null,"Desea ingresar otro numero? 1=SI 2=NO:","Seguir?",JOptionPane.QUESTION_MESSAGE));
    }while(opc!=2);
       
      
  
          arbol_texto.Fronteras(lista);
           for (int i=0;i<lista.size();i++){
               if(i!=lista.size()-1){
                   Fronteras+=lista.get(i)+",";
                   
               }else{
                   Fronteras+=lista.get(i)+".";
                   
               }
    
           }
            
        V.RepList.setText(Fronteras);
        arbol_texto.graficar("C:\\Users\\rodri\\Downloads\\Compressed\\ABBGraphviz-master\\ABBGraphviz-master\\arbol.jpg");
        Thread.sleep(3000);
        Image.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Downloads\\Compressed\\ABBGraphviz-master\\ABBGraphviz-master\\arbol.jpg"));
        V.show();
       
    }
    
}
