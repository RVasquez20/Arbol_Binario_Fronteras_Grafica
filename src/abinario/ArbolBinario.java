

package abinario;

import java.io.File;
import java.util.List;


public class ArbolBinario {
    
    private NodoBinario raiz;
    
    public ArbolBinario() {
        raiz=null;
    }
    /**
     * @param val
     */
    public void insertar(Comparable val){
        if(raiz==null){
            raiz=new NodoBinario(val);
        }else{
            raiz.insertar(val);
            }
    }
    /**
     * @param path 
     */
    public void graficar(String path) {
        raiz.graficar(path);
    }
    public void Fronteras(List<Integer>lista){
        ArbolBinario.this.Fronteras(raiz,lista);
     
    }
    /**
     * @param a 
     */
    
     private void Fronteras(NodoBinario a,List<Integer>lista){
        if(a==null)
            return;
        if(a.izquierdo==null && a.derecho==null){
            lista.add((Integer) a.valor);
    }else{
            ArbolBinario.this.Fronteras(a.izquierdo,lista);
            ArbolBinario.this.Fronteras(a.derecho,lista);
        }
        
           
    }
}
