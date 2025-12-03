/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Models.SerializableJson;
import Persistencia.JsonUtil;
import Persistencia.JsonUtil;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander
 */
public class DatosJson <T extends  SerializableJson>{
    private final Class<T> clase;
    private final File file;
    
    public DatosJson(Class <T> clase, String file){
        this.clase = clase;
        this.file = new File(file);
    }
    
    public void guardarJson(List<T> lista){
        try (Writer w = new FileWriter(file)){
            JsonUtil.serializarLista(lista,clase, w);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<T> cargarJson(){
        List<T> datosArchivo = new ArrayList<>();
        try (Reader reader = new FileReader(file)){
            datosArchivo = JsonUtil.deserializarLista(reader, clase);
        } catch (IOException e){ 
            System.out.println(e.getMessage());
        }
        return datosArchivo;
    }
    public File getFile(){
        return this.file;
    }
    
    public boolean estaVacioArchivo(){
        return this.getFile().length() == 0;
    }
}
