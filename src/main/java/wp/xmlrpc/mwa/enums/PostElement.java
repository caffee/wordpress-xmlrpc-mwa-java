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
 * The enum {@code PostElement} defined members of post struct. 
 *
 * @author  Lee
 * @version 1.0.0
 * @since   1.0.0
 */
public enum PostElement {

    POST_ID                ("postid"),
    TITLE                  ("title"),
    DESCRIPTION            ("description"),
    LINK                   ("link"),
    USER_ID                ("userid"),
    DATE_CREATED           ("dateCreated"),
    DATE_CREATED_GMT       ("date_created_gmt"),
    DATE_MODIFIED          ("date_modified"),
    DATE_MODIFIED_GMT      ("date_modified_gmt"),
    WP_POST_THUMBNAIL      ("wp_post_thumbnail"),
    PERMA_LINK             ("permaLink"),
    CATEGORIES             ("categories"),
    MT_KEYWORDS            ("mt_keywords"),
    MT_EXCERPT             ("mt_excerpt"),
    MT_TEXT_MORE           ("mt_text_more"),
    WP_MORE_TEXT           ("wp_more_text"),
    MT_ALLOW_COMMENTS      ("mt_allow_comments"),
    MT_ALLOW_PINGS         ("mt_allow_pings"),
    WP_SLUG                ("wp_slug"),
    WP_PASSWORD            ("wp_password"),
    WP_AUTHOR_ID           ("wp_author_id"),
    WP_AUTHOR_DISPLAY_NAME ("wp_author_display_name"),
    POST_STATUS            ("post_status"),
    WP_POST_FORMAT         ("wp_post_format"),
    STICKY                 ("sticky"),
    CUSTOM_FIELDS          ("custom_fields"),
    ENCLOSURE              ("enclosure");

    private final String value;

    private PostElement (final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
