

package abinario;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class NodoBinario {
       
    final Comparable valor;
       
    NodoBinario izquierdo;
    
    NodoBinario derecho;
  
    private static int correlativo=1;
   
    private final int id;    
    /** 
     * @param valor 
     */
    public NodoBinario(Comparable valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
        this.id=correlativo++;        
    }
    /**
     * @param val 
     */
    void insertar(Comparable val) {
       
        if (val.compareTo(valor) < 0) 
           
            if (izquierdo == null) 
                izquierdo = new NodoBinario(val);
            else 
                izquierdo.insertar(val);
              
        else if (val.compareTo(valor) > 0)
            
            if (derecho == null) 
                derecho = new NodoBinario(val);
                     
            else
                derecho.insertar(val);
        else
            
            System.err.println("No se permiten los valores duplicados: \"" 
                    +  String.valueOf(val)+"\".");
    }
    
    /**
     * @param path 
     */
    public void graficar(String path) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try
        {
            fichero = new FileWriter("aux_grafico.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        } 
        catch (Exception e){
            System.err.println("Error al escribir el archivo aux_grafico.dot");
        }finally{
           try {
                if (null != fichero)
                    fichero.close();
           }catch (Exception e2){
               System.err.println("Error al cerrar el archivo aux_grafico.dot");
           } 
        }                        
        try{
            String dotPath = "C:\\Archivos de programa\\Graphviz\\bin\\dot.exe";
          Runtime rt = Runtime.getRuntime();
          String[] CMD=new String[5];
          CMD[0]=dotPath;
          CMD[1]="-Tjpg";
          CMD[2]="C:\\Users\\rodri\\Downloads\\Compressed\\ABBGraphviz-master\\ABBGraphviz-master\\aux_grafico.dot";
          CMD[3]="-o";
          CMD[4]=path;
          rt.exec(CMD);
          
          Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot    "+ex.getMessage());
        }            
    }
    /**
     * @return 
     */
    private String getCodigoGraphviz() {
        return "digraph grafica{\n" +
               "node [shape = record];\n"+
                getCodigoInterno()+
                "}\n";
    }
    /**
     * @return 
     */
    private String getCodigoInterno() {
        String etiqueta;
        if(izquierdo==null && derecho==null){
            etiqueta="nodo"+id+" [ label =\""+valor+"\"];\n";
        }else{
            etiqueta="nodo"+id+" [ label =\"<C0>|"+valor+"|<C1>\"];\n";
        }
        if(izquierdo!=null){
            etiqueta=etiqueta + izquierdo.getCodigoInterno() +
               "nodo"+id+":C0->nodo"+izquierdo.id+"\n";
        }
        if(derecho!=null){
            etiqueta=etiqueta + derecho.getCodigoInterno() +
               "nodo"+id+":C1->nodo"+derecho.id+"\n";                    
        }
        return etiqueta;
        
    }        
    
}




