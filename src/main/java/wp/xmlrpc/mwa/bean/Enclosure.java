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

import wp.xmlrpc.mwa.enums.EnclosureElement;

/**
 * The class {@code Enclosure} is a bean class 
 * 
 * @author  Lee
 * @version 1.0.0
 * @since   1.0.0
 */
public final class Enclosure {

    private String url;
    private int length;
    private String type; 

    public Enclosure() {}

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(final String url) {
        this.url = url;
    }

    public final int getLength() {
        return this.length;
    }

    public final void setLength(final int length) {
        this.length = length;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    public final static Map<String, Object > parseStruct(final Enclosure enclosure) {

        Map<String, Object > map = new HashMap<String, Object> ();

        if(enclosure.getUrl() != null && !enclosure.getUrl().isEmpty()) {
            map.put(EnclosureElement.URL.toString(), enclosure.getUrl());
        }

        if(enclosure.getLength() > 0) {
            map.put(EnclosureElement.LENGTH.toString(), enclosure.getLength());
        }
        
        if(enclosure.getType() != null && !enclosure.getType().isEmpty()) {
            map.put(EnclosureElement.TYPE.toString(), enclosure.getType());
        }

        return map;
    }

    public final static Enclosure valueOf(final Object object) {

        @SuppressWarnings("unchecked")
        Map<String, Object> map = (HashMap<String, Object>)object;

        Enclosure enclosure = new Enclosure();

        if(map.containsKey(EnclosureElement.URL.toString())) {
            enclosure.setUrl((String)map.get(EnclosureElement.URL.toString()));
        }

        if(map.containsKey(EnclosureElement.LENGTH.toString())) {
            enclosure.setLength((Integer)map.get(EnclosureElement.LENGTH.toString()));
        }

        if(map.containsKey(EnclosureElement.TYPE.toString())) {
            enclosure.setType((String)map.get(EnclosureElement.TYPE.toString()));
        }

        return enclosure;
    }
}