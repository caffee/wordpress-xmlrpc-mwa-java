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

import wp.xmlrpc.mwa.bean.Category;
import wp.xmlrpc.mwa.bean.Media;
import wp.xmlrpc.mwa.bean.MediaData;
import wp.xmlrpc.mwa.bean.Post;
import wp.xmlrpc.mwa.bean.UsersBlog;
import wp.xmlrpc.mwa.enums.Publish;
import wp.xmlrpc.mwa.exception.MetaWeblogException;

/**
 * <p>XML-RPC MetaWeblog API</p>
 * <p>WordPress supports the metaWeblog XML-RPC API,
 * augmented with additional WordPress-specific functionality.
 * This support was added in WordPress 1.5.0.</p>
 * 
 * <p>Supported API-</p>
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
 * 
 * @see <a href="http://codex.wordpress.org/XML-RPC_MetaWeblog_API">http://codex.wordpress.org/XML-RPC_MetaWeblog_API</a>
 */
public interface MetaWeblog {

    /**
     * <p>Retrieve a post.</p>
     * <code>metaWeblog.getPost</code>
     * 
     * @param postId Blog post unique id number
     * @return Post object as defined members of struct
     * @throws MetaWeblogException Response enhanced or standard exception message
     * 
     * @since 1.0.0
     */
    Post getPost(final int postId) throws MetaWeblogException;

    /**
     * <p>Retrieve a list of recent posts.</p>
     * <code>metaWeblog.getRecentPosts</code>
     *
     * @param numberOfPosts Optional - set number of recent post record(s) to fetch.
     *                      Fetch all record(s) if value less than or equal to 0
     * @return Collection of Post object as defined members of struct
     * @throws MetaWeblogException Response enhanced or standard exception message
     * 
     * @since 1.0.0
     */
    Post[] getRecentPosts(final int numberOfPosts) throws MetaWeblogException;

    /**
     * <p>Create a new post.</p>
     * <code>metaWeblog.newPost</code>
     *
     * @param post Post object as defined members of struct
     * @param publish Publish the post or leave it as draft.
     *                <strong>Note:</strong> This value will be overridden by Post object,
     *                if postStatus is defined
     * @return Blog post unique id number
     * @throws MetaWeblogException Response enhanced or standard exception message
     * 
     * @since 1.0.0
     */
    String newPost(final Post post, final Publish publish) throws MetaWeblogException;

    /**
     * <p>Edit an existing post.</p>
     * <code>metaWeblog.editPost</code>
     *
     * @param postId Blog post unique id number
     * @param post Post object as defined members of struct
     * @param publish Publish the post or leave it as draft.
     *                <strong>Note:</strong> This value will be overridden by Post object,
     *                if postStatus is defined
     * @return Boolean values as action indicator
     * @throws MetaWeblogException Response enhanced or standard exception message
     * 
     * @since 1.0.0
     */
    boolean editPost(final int postId, final Post post, final Publish publish) throws MetaWeblogException;

    /**
     * <p>Delete an existing post. Equivalent to blogger.deletePost.</p>
     * <code>metaWeblog.deletePost</code>
     *
     * @param postId Blog post unique id number
     * @return Boolean values as action indicator
     * @throws MetaWeblogException Response enhanced or standard exception message
     * 
     * @since 1.0.0
     */
    boolean deletePost(final int postId) throws MetaWeblogException;

    /**
     * <p>Retrieve list of categories.</p>
     * <code>metaWeblog.getCategories</code>
     * 
     * @param blogId Blog unique id number
     * @return Collection of Category object as defined members of struct
     * @throws MetaWeblogException Response enhanced or standard exception message
     * 
     * @since 1.0.0
     */
    Category[] getCategories(final int blogId) throws MetaWeblogException;

    /**
     * <p>Upload a media file.</p>
     * <code>metaWeblog.newMediaObject</code>
     * 
     * @param blogId Blog unique id number
     * @param mediaData Data object as defined members of struct
     * @return Media object as defined members of struct
     * @throws MetaWeblogException Response enhanced or standard exception message
     * 
     * @since 1.0.0
     */
    Media newMediaObject(final int blogId, final MediaData mediaData) throws MetaWeblogException;

    /**
     * <p>Returns information about all the blogs a given user is a member of.
     * Equivalent to blogger.getUsersBlogs.</p>
     * <code>metaWeblog.getUsersBlogs</code>
     * 
     * @return Collection of UsersBlog object as defined members of struct
     * @throws MetaWeblogException Response enhanced or standard exception message
     * 
     * @since 1.0.0
     */
    UsersBlog[] getUsersBlogs() throws MetaWeblogException;
}
