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
package wp.xmlrpc.mwa.client;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * The class {@code MetaWeblogConfig} contain xml-rpc client configuration
 *
 * @author  Lee
 * @version 1.0.0
 */
public final class MetaWeblogConfig {

    private URL endPointUrl;
    private String login;
    private String password;

    private boolean enableExtensions;
    private int connectionTimeout;
    private int replyTimeout;

    /**
     * Constructs a {@code MetaWeblogConfig} with the endpoint url, user login id and password
     * 
     * @param endPointUrl XML-RPC server path
     * @param login User login id
     * @param password User login password
     * 
     * @since 1.0.0
     */
    public MetaWeblogConfig(final String endPointUrl, final String login, final String password) {
        this.endPointUrl       = this.getURL(endPointUrl);
        this.login             = login;
        this.password          = password;
        this.enableExtensions  = Boolean.TRUE; // default setting
        this.connectionTimeout = 60 * 1000;    // default setting
        this.replyTimeout      = 60 * 1000;    // default setting
    }

    private URL getURL(final String endPointUrl) {
        try {
            return new URL(endPointUrl);
        } catch (MalformedURLException  e) {
            throw new RuntimeException("Invalid endpoint url", e);
        }
    }

    /**
     * @since 1.0.0
     */
    public final URL getEndPointUrl() {
        return this.endPointUrl;
    }

    /**
     * @since 1.0.0
     */
    public final void setEndPointUrl(final String endPointUrl) {
        this.endPointUrl = this.getURL(endPointUrl);
    }

    public final String getLogin() {
        return this.login;
    }

    /**
     * @since 1.0.0
     */
    public final void setLogin(final String login) {
        this.login = login;
    }

    /**
     * @since 1.0.0
     */
    public final String getPassword() {
        return this.password;
    }

    /**
     * @since 1.0.0
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @since 1.0.0
     */
    public final boolean isEnableExtensions() {
        return this.enableExtensions;
    }

    /**
     * @since 1.0.0
     */
    public final void setEnableExtensions(final boolean enableExtensions) {
        this.enableExtensions = enableExtensions;
    }

    /**
     * @since 1.0.0
     */
    public final int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    /**
     * @since 1.0.0
     */
    public final void setConnectionTimeout(final int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    /**
     * @since 1.0.0
     */
    public final int getReplyTimeout() {
        return this.replyTimeout;
    }

    /**
     * @since 1.0.0
     */
    public final void setReplyTimeout(final int replyTimeout) {
        this.replyTimeout = replyTimeout;
    }
}