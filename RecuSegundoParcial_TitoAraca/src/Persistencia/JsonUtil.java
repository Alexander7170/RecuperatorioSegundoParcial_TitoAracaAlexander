/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Persistencia.AdaptadorJson;
import Models.SerializableJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author Alexander
 */

public class JsonUtil {
    private JsonUtil(){}
    
    public static <T extends SerializableJson> void serializarLista(List<T> lista, Class<T> clase, Writer w){
        Type tipoLista = JsonUtil.getTipo(clase);
        Gson gson = JsonUtil.getGson(clase);
        gson.toJson(lista, tipoLista, w);
    }
    
    public static <T extends SerializableJson> List<T> deserializarLista(Reader r, Class<T> clase){
        Gson gson = JsonUtil.getGson(clase);
        Type tipoLista = JsonUtil.getTipo(clase);
        return gson.fromJson(r, tipoLista);
    }
    
    private static <T> Type getTipo(Class<T> clase){
        return TypeToken.getParameterized(List.class, clase).getType();
    }
    private static <T extends SerializableJson> Gson getGson(Class<T> clase){
        return new GsonBuilder().registerTypeAdapter(clase, new AdaptadorJson<T>()).setPrettyPrinting().create();
    }
    
}

