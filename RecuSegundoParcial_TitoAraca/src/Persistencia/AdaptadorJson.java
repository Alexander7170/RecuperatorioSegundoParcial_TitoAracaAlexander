/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Models.SerializableJson;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public class AdaptadorJson <T extends SerializableJson> extends TypeAdapter<T> {
    private final Gson gson;
    private final String nombreVariableClase = "Clase";
    public AdaptadorJson(){
        this.gson = new Gson();
    }
    
    @Override
    public void write(JsonWriter writer, T t) throws IOException {
        /*
        Metodo que personalizo como quiero q serialize el objeto, de tal manera q se le agregara un llave
        de valor "Clase", y el valor seria el nombre de la clase a la q pertenece el objeto
        */
        JsonObject objeto = (JsonObject)gson.toJsonTree(t);
        objeto.addProperty(this.nombreVariableClase,t.getNombreClase());
        gson.toJson(objeto, writer);
    }

    @Override
    public T read(JsonReader reader) throws IOException{
        
        /*
        Metodo que obtiene la subclase y deserializo con esa subclase como referencia, luego lo casteo a T
        */
        JsonObject objeto = JsonParser.parseReader(reader).getAsJsonObject();
        String claseACastear = objeto.get(this.nombreVariableClase).getAsString();
        Class<?> claseDesconocida= null;
        try {
            claseDesconocida = Class.forName(claseACastear);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return (T)gson.fromJson(objeto, claseDesconocida);
    }
    
}