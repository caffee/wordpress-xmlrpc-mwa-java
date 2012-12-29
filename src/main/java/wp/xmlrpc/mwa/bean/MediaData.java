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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import wp.xmlrpc.mwa.enums.MediaDataElement;
import wp.xmlrpc.mwa.enums.Overwrite;

/**
 * The class {@code MediaData} is a bean class 
 * 
 * @author  Lee
 * @version 1.0.0
 * @since   1.0.0
 */
public final class MediaData {
    
    private String fileName;
    private String mineType;
    private byte[] base64Binary;
    private Boolean overwrite;

    public final String getFileName() {
        return this.fileName;
    }

    public final void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public final String getMineType() {
        return this.mineType;
    }

    public final void setMineType(final String mineType) {
        this.mineType = mineType;
    }

    public final byte[] getBase64Binary() {
        return this.base64Binary;
    }

    public final void setBase64Binary(final byte[] base64Binary) {
        this.base64Binary = base64Binary;
    }

    public final Boolean isOverwrite() {
        return this.overwrite;
    }

    public final void setOverwrite(final Overwrite overwrite) {
        this.overwrite = overwrite.getBooleanValue();
    }

    public final static Map<String, Object > parseStruct(final MediaData mediaData) {

        Map<String, Object > map = new HashMap<String, Object> ();

        if(mediaData.getFileName() != null && !mediaData.getFileName().isEmpty()) {
            map.put(MediaDataElement.FILE_NAME.toString(), mediaData.getFileName());
        }

        if(mediaData.getMineType() != null && !mediaData.getMineType().isEmpty()) {
            map.put(MediaDataElement.MIME_TYPE.toString(), mediaData.getMineType());
        }
        
        if(mediaData.getBase64Binary() != null && mediaData.getBase64Binary().length > 0) {
            map.put(MediaDataElement.BASE64_BINARY.toString(), mediaData.getBase64Binary());
        }

        if(mediaData.isOverwrite() != null) {
            map.put(MediaDataElement.OVERWRITE.toString(), mediaData.isOverwrite().booleanValue());
        }

        return map;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(base64Binary);
        result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
        result = prime * result + ((mineType == null) ? 0 : mineType.hashCode());
        result = prime * result + ((overwrite == null) ? 0 : overwrite.hashCode());
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
        MediaData other = (MediaData) obj;
        if (!Arrays.equals(base64Binary, other.base64Binary))
            return false;
        if (fileName == null) {
            if (other.fileName != null)
                return false;
        } else if (!fileName.equals(other.fileName))
            return false;
        if (mineType == null) {
            if (other.mineType != null)
                return false;
        } else if (!mineType.equals(other.mineType))
            return false;
        if (overwrite == null) {
            if (other.overwrite != null)
                return false;
        } else if (!overwrite.equals(other.overwrite))
            return false;
        return true;
    }
}
