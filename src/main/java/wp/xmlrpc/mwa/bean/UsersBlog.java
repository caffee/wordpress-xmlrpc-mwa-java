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

import wp.xmlrpc.mwa.enums.UsersBlogElement;

/**
 * The class {@code UsersBlog} is a bean class 
 * 
 * @author  Lee
 * @version 1.0.0
 * @since   1.0.0
 */
public final class UsersBlog {

    private String blogId;
    private String url;
    private String blogName;
    private boolean isAdmin;
    private String endPoint;

    public UsersBlog() {}

    public final String getBlogId() {
        return this.blogId;
    }

    public final void setBlogId(final String blogId) {
        this.blogId = blogId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(final String url) {
        this.url = url;
    }

    public final String getBlogName() {
        return this.blogName;
    }

    public final void setBlogName(final String blogName) {
        this.blogName = blogName;
    }

    public final boolean isAdmin() {
        return this.isAdmin;
    }

    public final void setAdmin(final boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public final String getEndPoint() {
        return this.endPoint;
    }

    public final void setEndPoint(final String endPoint) {
        this.endPoint = endPoint;
    }

    public final static UsersBlog[] valueOf(final Object[] object) {

        if (object == null || object.length == 0) {
            return null;
        }

        UsersBlog[] usersBlog = new UsersBlog[object.length];

        for (int i=0; i<object.length; i++) {
            usersBlog [i] = valueOf(object[i]);
        }

        return usersBlog ;
    }

    public final static UsersBlog valueOf(final Object object) {

        @SuppressWarnings("unchecked")
        Map<String, Object> map = (HashMap<String, Object>)object;

        UsersBlog usersBlog = new UsersBlog();

        if(map.containsKey(UsersBlogElement.BLOG_ID.toString())) {
            usersBlog.setBlogId((String)map.get(UsersBlogElement.BLOG_ID.toString()));
        }

        if(map.containsKey(UsersBlogElement.URL.toString())) {
            usersBlog.setUrl((String)map.get(UsersBlogElement.URL.toString()));
        }

        if(map.containsKey(UsersBlogElement.BLOG_NAME.toString())) {
            usersBlog.setBlogName((String)map.get(UsersBlogElement.BLOG_NAME.toString()));
        }

        if(map.containsKey(UsersBlogElement.IS_ADMIN.toString())) {
            usersBlog.setAdmin((Boolean)map.get(UsersBlogElement.IS_ADMIN.toString()));
        }

        if(map.containsKey(UsersBlogElement.ENDPOINT.toString())) {
            usersBlog.setEndPoint((String)map.get(UsersBlogElement.ENDPOINT.toString()));
        }

        return usersBlog;
    }
}
