/*
 * Copyright (c) 2012, Lee <lee.github@gmail.com> or third-party contributors 
 * as indicated by the @author tags or express copyright attribution statements 
 * applied by the authors. All third-party contributions are distributed under 
 * license by GNU Lesser General Public License.
 *
 * This file is part of WordPress XML-RPC MetaWeblogAPI Java interface
 *
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package wp.xmlrpc.mwa.bean;

import java.util.HashMap;
import java.util.Map;

import wp.xmlrpc.mwa.enums.CustomFieldElement;

/**
 * The class {@code CustomField} is a bean class 
 * 
 * @author  Lee
 * @version 1.0.0
 * @since   1.0.0
 */
public final class CustomField {

    private String id;
    private String key;
    private String value;

    public CustomField() {}

    public final String getId() {
        return this.id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(final String key) {
        this.key = key;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(final String value) {
        this.value = value;
    }

    public final static Object[] parseStruct(final CustomField[] customFields) {

        Object[] object = new Object[customFields.length];

        for (int i=0; i<customFields.length; i++) {
            object[i] = parseStruct(customFields[i]);
        }

        return object;
    }

    // Note: custom field id is not parse when create the post because it cause error
    public final static Map<String, Object > parseStruct(final CustomField customField) {

        Map<String, Object > map = new HashMap<String, Object> ();

        if(customField.getKey() != null && !customField.getKey().isEmpty()) {
            map.put(CustomFieldElement.KEY.toString(), customField.getKey());
        }

        if(customField.getValue() != null && !customField.getValue().isEmpty()) {
            map.put(CustomFieldElement.VALUE.toString(), customField.getValue());
        }

        return map;
    }

    public final static CustomField[] valueOf(final Object[] object) {

        if (object == null || object.length == 0) {
            return null;
        }

        CustomField[] customField = new CustomField[object.length];

        for (int i=0; i<object.length; i++) {
            customField [i] = valueOf(object[i]);
        }

        return customField ;
    }

    public final static CustomField valueOf(final Object object) {

        @SuppressWarnings("unchecked")
        Map<String, Object> map = (HashMap<String, Object>)object;

        CustomField customField = new CustomField();

        if(map.containsKey(CustomFieldElement.ID.toString())) {
            customField.setId((String)map.get(CustomFieldElement.ID.toString()));
        }

        if(map.containsKey(CustomFieldElement.KEY.toString())) {
            customField.setKey((String)map.get(CustomFieldElement.KEY.toString()));
        }
        
        if(map.containsKey(CustomFieldElement.VALUE.toString())) {
            customField.setValue((String)map.get(CustomFieldElement.VALUE.toString()));
        }

        return customField;
    }

}