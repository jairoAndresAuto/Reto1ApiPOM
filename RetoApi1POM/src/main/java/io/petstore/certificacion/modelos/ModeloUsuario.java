package io.petstore.certificacion.modelos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModeloUsuario {

    List<String> data;
    private Map<String, Object> jsonMap = new HashMap<>();

    public ModeloUsuario(List<String> data) {
        this.data = data;
    }

    public Map<String, Object> llenatJson() {
        jsonMap.put("id", data.get(0));
        jsonMap.put("username", data.get(1));
        jsonMap.put("firstName", data.get(2));
        jsonMap.put("lastName", data.get(3));
        jsonMap.put("email", data.get(4));
        jsonMap.put("password", data.get(5));
        jsonMap.put("phone", data.get(6));
        jsonMap.put("userStatus", data.get(7));
        return jsonMap;
    }
}
