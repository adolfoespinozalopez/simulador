package com.pss.simulador.web.converter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Adolfo Espinoza
 * @version 1.0, 04/01/2016
 * @since 1.0
 */
@FacesConverter("entityConverter")
public class EntityConverter implements Converter {

    private static Map<Object, String> entities = new HashMap<Object, String>();

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        for (Entry<Object, String> entry : entities.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String getAsString(FacesContext context, UIComponent component, Object entity) {
        synchronized (entities) {
            if (!entities.containsKey(entity)) {
                String uuid = UUID.randomUUID().toString();
                entities.put(entity, uuid);
                return uuid;
            } else {
                return entities.get(entity);
            }
        }
    }

}
