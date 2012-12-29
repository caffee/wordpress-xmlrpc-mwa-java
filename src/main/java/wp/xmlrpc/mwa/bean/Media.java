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

import wp.xmlrpc.mwa.enums.MediaElement;

/**
 * The class {@code Media} is a bean class 
 * 
 * @author  Lee
 * @version 1.0.0
 * @since   1.0.0
 */
public final class Media {

    private String id;
    private String fileName;
    private String url;
    private String type;

    public Media() {}

    public final String getId() {
        return this.id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(final String url) {
        this.url = url;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    public final static Media valueOf(final Object object) {

        @SuppressWarnings("unchecked")
        Map<String, Object> map = (HashMap<String, Object>)object;

        Media media = new Media();

        if(map.containsKey(MediaElement.ID.toString())) {
            media.setId((String)map.get(MediaElement.ID.toString()));
        }

        if(map.containsKey(MediaElement.FILE_NAME.toString())) {
            media.setFileName((String)map.get(MediaElement.FILE_NAME.toString()));
        }
 
        if(map.containsKey(MediaElement.URL.toString())) {
            media.setUrl((String)map.get(MediaElement.URL.toString()));
        }

        if(map.containsKey(MediaElement.TYPE.toString())) {
            media.setType((String)map.get(MediaElement.TYPE.toString()));
        }

        return media;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Media other = (Media) obj;
        if (fileName == null) {
            if (other.fileName != null)
                return false;
        } else if (!fileName.equals(other.fileName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }
}
