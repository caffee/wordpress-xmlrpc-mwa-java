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
package wp.xmlrpc.mwa.exception;

/**
 * The class {@code MetaWeblogException} is an exception wrapper class with
 * enhanced message and indicates conditions that a reasonable application 
 * might want to catch.
 * 
 * @author Lee
 * @version 1.0.0
 */
public final class MetaWeblogException extends Exception {

    private static final long serialVersionUID = 7832329444329686712L;

    /**
     * Constructs a {@code MetaWeblogException} with {@code null} as its detail message.
     * 
     * @since 1.0.0
     */
    public MetaWeblogException() {
        super();
    }

    /**
     * Constructs a {@code MetaWeblogException} with the specified detail message.
     * 
     * @param message The detail message of exception
     * 
     * @since 1.0.0
     */
    public MetaWeblogException(final String message) {
        super(message);
    }

    /**
     * Constructs a {@code MetaWeblogException} with the specified detail message and cause.
     * 
     * @param message The detail message of exception
     * @param cause   The cause of exception
     * 
     * @since 1.0.0
     */
    public MetaWeblogException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a {@code MetaWeblogException} with the specified cause.
     * 
     * @param cause The cause of exception
     * 
     * @since 1.0.0
     */
    public MetaWeblogException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a {@code MetaWeblogException} with the specified code, detail message and cause.
     * 
     * @param code    The detail code of exception
     * @param message The detail message of exception
     * @param cause   The cause of exception
     * 
     * @since 1.0.0
     */
    public MetaWeblogException(final int code, final String message, final Throwable cause) {
        super(code + " : " + message, cause);
    }
}
