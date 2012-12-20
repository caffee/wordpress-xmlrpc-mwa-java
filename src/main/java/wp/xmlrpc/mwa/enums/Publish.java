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
package wp.xmlrpc.mwa.enums;

/**
 * The enum {@code Publish} return boolean flag to determine
 * whether to publish creation or leave it as a draft. 
 *
 * @author  Lee
 * @version 1.0.0
 * @since   1.0.0
 */
public enum Publish {

    TRUE  (Boolean.TRUE),
    FALSE (Boolean.FALSE);

    private boolean bool;
    
    private Publish (boolean bool) {
        this.bool = bool;
    }

    public final boolean getBooleanValue() {
        return this.bool;
    }
}