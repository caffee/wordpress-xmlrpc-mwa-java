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

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import wp.xmlrpc.mwa.bean.Category;
import wp.xmlrpc.mwa.bean.Media;
import wp.xmlrpc.mwa.bean.MediaData;
import wp.xmlrpc.mwa.bean.Post;
import wp.xmlrpc.mwa.bean.UsersBlog;
import wp.xmlrpc.mwa.enums.MetaWeblogMethod;
import wp.xmlrpc.mwa.enums.Publish;
import wp.xmlrpc.mwa.exception.MetaWeblogException;

/**
 * <p>XML-RPC MetaWeblog API Client</p>
 * <p>WordPress supports the metaWeblog XML-RPC API,
 * augmented with additional WordPress-specific functionality.
 * This support was added in WordPress 1.5.0.</p>
 * 
 * <p>http://codex.wordpress.org/XML-RPC_MetaWeblog_API</p>
 * 
 * <p>Supported API list-</p>
 * <ul>
 * <li>metaWeblog.getPost</li>
 * <li>metaWeblog.getRecentPosts</li>
 * <li>metaWeblog.newPost</li>
 * <li>metaWeblog.editPost</li>
 * <li>metaWeblog.deletePost</li>
 * <li>metaWeblog.getCategories</li>
 * <li>metaWeblog.newMediaObject</li>
 * <li>metaWeblog.getUsersBlogs</li>
 * </ul>
 * 
 * <p>Not supported API-</p>
 * <ul>
 * <li>metaWeblog.getTemplate</li>
 * <li>metaWeblog.setTemplate</li>
 * </ul>
 * 
 * @author  Lee
 * @version 1.0.0
 */
public final class MetaWeblogClient implements MetaWeblog {

    private MetaWeblogConfig metaWeblogConfig;
    private XmlRpcClient xmlRpcClient;

    /**
     * Constructs a {@code MetaWeblogClient} with {@code metaWeblogConfig} settings.
     * 
     * @param metaWeblogConfig XML-RPC client configuration
     * 
     * @since 1.0.0
     */
    public MetaWeblogClient(final MetaWeblogConfig metaWeblogConfig) {
        this.metaWeblogConfig = metaWeblogConfig;
        this.initXmlRpcClient();
    }

    private final void initXmlRpcClient(){
        XmlRpcClientConfigImpl xmlRpcClientConfig = new XmlRpcClientConfigImpl();
        xmlRpcClientConfig.setServerURL(this.metaWeblogConfig.getEndPointUrl());
        xmlRpcClientConfig.setEnabledForExtensions(this.metaWeblogConfig.isEnableExtensions());
        xmlRpcClientConfig.setConnectionTimeout(this.metaWeblogConfig.getConnectionTimeout());
        xmlRpcClientConfig.setReplyTimeout(this.metaWeblogConfig.getReplyTimeout());

        this.xmlRpcClient = new XmlRpcClient();
        this.xmlRpcClient.setConfig(xmlRpcClientConfig);
    }

    private final Object execute (MetaWeblogMethod metaWeblogMethod, Object[] params) throws MetaWeblogException {
        try {
            return this.xmlRpcClient.execute(metaWeblogMethod.toString(), params);
        } catch (XmlRpcException e) {
            throw new MetaWeblogException(e.code,e.getMessage(),e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Post getPost(final int postId) throws MetaWeblogException {
        Object[] params = new Object[]{postId,                               // int postid
                                       this.metaWeblogConfig.getLogin(),     // String username
                                       this.metaWeblogConfig.getPassword()}; // String password 

        Object object = this.execute(MetaWeblogMethod.GET_POST, params);

        return Post.valueOf(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Post[] getRecentPosts(final int numberOfPosts) throws MetaWeblogException {

        Object[] params = new Object[(numberOfPosts > 0) ? 4 : 3];

        params[0] = -1;                                  // int blogid: Not applicable will be ignored.
        params[1] = this.metaWeblogConfig.getLogin();    // String username
        params[2] = this.metaWeblogConfig.getPassword(); // String password 

        if(numberOfPosts > 0) { 
            params[3] = numberOfPosts;                   // int numberOfPosts: Optional.
        }

        Object[] object = (Object[])this.execute(MetaWeblogMethod.GET_RECENT_POSTS, params);

        return Post.valueOf(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String newPost(final Post post, final Publish publish) throws MetaWeblogException {
        Object[] params = new Object[]{-1,                                  // int blogid: Not applicable will be ignored.
                                       this.metaWeblogConfig.getLogin(),    // String username
                                       this.metaWeblogConfig.getPassword(), // String password 
                                       Post.parseStruct(post),              // Struct post
                                       publish.getBooleanValue()};          // boolean publish the post or leave it as draft

        return (String)this.execute(MetaWeblogMethod.NEW_POST, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean editPost(final int postId, final Post post, final Publish publish) throws MetaWeblogException {
        Object[] params = new Object[]{postId,                              // int postid
                                       this.metaWeblogConfig.getLogin(),    // String username
                                       this.metaWeblogConfig.getPassword(), // String password
                                       Post.parseStruct(post),              // Struct post
                                       publish.getBooleanValue()};          // boolean publish the post or leave it as draft

        return (Boolean)this.execute(MetaWeblogMethod.EDIT_POST, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean deletePost(final int postId) throws MetaWeblogException {
        Object[] params = new Object[]{"appkey",                            // String appkey: Not applicable will be ignored.
                                       postId,                              // int postid
                                       this.metaWeblogConfig.getLogin(),    // String username
                                       this.metaWeblogConfig.getPassword(), // String password
                                       Boolean.TRUE};                       // bool publish: Will be ignored

        return (Boolean)this.execute(MetaWeblogMethod.DELETE_POST, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Category[] getCategories(final int blogId) throws MetaWeblogException {
        Object[] params = new Object[]{blogId,                               // int blogid
                                       this.metaWeblogConfig.getLogin(),     // String username
                                       this.metaWeblogConfig.getPassword()}; // String password

        Object[] object = (Object[])this.execute(MetaWeblogMethod.GET_CATEGORIES, params);

        return Category.valueOf(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Media newMediaObject(final int blogId, final MediaData mediaData) throws MetaWeblogException {
        Object[] params = new Object[]{blogId,                              // int blogid
                                       this.metaWeblogConfig.getLogin(),    // String username
                                       this.metaWeblogConfig.getPassword(), // String password
                                       MediaData.parseStruct(mediaData)};   // Media data struct

        Object object = this.execute(MetaWeblogMethod.NEW_MEDIA_OBJECT, params);

        return Media.valueOf(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final UsersBlog[] getUsersBlogs() throws MetaWeblogException {
        Object[] params = new Object[]{"appkey",                             // String appkey: Not applicable will be ignored.
                                       this.metaWeblogConfig.getLogin(),     // String username
                                       this.metaWeblogConfig.getPassword()}; // String password 

        Object[] object = (Object[])this.execute(MetaWeblogMethod.GET_USERS_BLOGS, params);

        return UsersBlog.valueOf(object);
    }
}
