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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import wp.xmlrpc.mwa.enums.PostElement;

/**
 * The class {@code Post} is a bean class 
 * 
 * @author  Lee
 * @version 1.0.0
 * @since   1.0.0
 */
public final class Post {

    private int postId;
    private String title;
    private String description;
    private String link;
    private String userId;
    private Date dateCreated;
    private Date dateCreatedGmt;
    private Date dateModified;
    private Date dateModifiedGmt;
    private String wpPostThumbnail;
    private String permaLink;
    private String[] categoriesName;
    private String mtKeywords;
    private String mtExcerpt;
    private String mtTextMore;
    private String wpMoreText;
    private Integer mtAllowComments;
    private Integer mtAllowPings;
    private String wpSlug;
    private String wpPassword;
    private String wpAuthorId;
    private String wpAuthorDisplayName;
    private String postStatus;
    private String wpPostFormat;
    private Boolean sticky;
    private CustomField[] customFields;
    private Enclosure enclosure;

    public Post() {}

    public final int getPostId() {
        return this.postId;
    }

    public final void setPostId(final int postId) {
        this.postId = postId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(final String description) {
        this.description = description;
    }

    public final String getLink() {
        return this.link;
    }

    public final void setLink(final String link) {
        this.link = link;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    public final Date getDateCreated() {
        return this.dateCreated;
    }

    public final void setDateCreated(final Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public final Date getDateCreatedGmt() {
        return this.dateCreatedGmt;
    }

    public final void setDateCreatedGmt(final Date dateCreatedGmt) {
        this.dateCreatedGmt = dateCreatedGmt;
    }

    public final Date getDateModified() {
        return this.dateModified;
    }

    public final void setDateModified(final Date dateModified) {
        this.dateModified = dateModified;
    }

    public final Date getDateModifiedGmt() {
        return this.dateModifiedGmt;
    }

    public final void setDateModifiedGmt(final Date dateModifiedGmt) {
        this.dateModifiedGmt = dateModifiedGmt;
    }

    public final String getWpPostThumbnail() {
        return this.wpPostThumbnail;
    }

    public final void setWpPostThumbnail(final String wpPostThumbnail) {
        this.wpPostThumbnail = wpPostThumbnail;
    }

    public final String getPermaLink() {
        return this.permaLink;
    }

    public final void setPermaLink(final String permaLink) {
        this.permaLink = permaLink;
    }

    public final String[] getCategoriesName() {
        return this.categoriesName;
    }

    public final void setCategories(final String[] categoriesName) {
        this.categoriesName = categoriesName;
    }

    public final String getMtKeywords() {
        return this.mtKeywords;
    }

    public final void setMtKeywords(final String mtKeywords) {
        this.mtKeywords = mtKeywords;
    }

    public final String getMtExcerpt() {
        return this.mtExcerpt;
    }

    public final void setMtExcerpt(final String mtExcerpt) {
        this.mtExcerpt = mtExcerpt;
    }

    public final String getMtTextMore() {
        return this.mtTextMore;
    }

    public final void setMtTextMore(final String mtTextMore) {
        this.mtTextMore = mtTextMore;
    }

    public final String getWpMoreText() {
        return this.wpMoreText;
    }

    public final void setWpMoreText(final String wpMoreText) {
        this.wpMoreText = wpMoreText;
    }

    public final Integer getMtAllowComments() {
        return this.mtAllowComments;
    }

    public final void setMtAllowComments(final Integer mtAllowComments) {
        this.mtAllowComments = mtAllowComments;
    }

    public final Integer getMtAllowPings() {
        return this.mtAllowPings;
    }

    public final void setMtAllowPings(final Integer mtAllowPings) {
        this.mtAllowPings = mtAllowPings;
    }

    public final String getWpSlug() {
        return this.wpSlug;
    }

    public final void setWpSlug(final String wpSlug) {
        this.wpSlug = wpSlug;
    }

    public final String getWpPassword() {
        return this.wpPassword;
    }

    public final void setWpPassword(final String wpPassword) {
        this.wpPassword = wpPassword;
    }

    public final String getWpAuthorId() {
        return this.wpAuthorId;
    }

    public final void setWpAuthorId(final String wpAuthorId) {
        this.wpAuthorId = wpAuthorId;
    }

    public final String getWpAuthorDisplayName() {
        return this.wpAuthorDisplayName;
    }

    public final void setWpAuthorDisplayName(final String wpAuthorDisplayName) {
        this.wpAuthorDisplayName = wpAuthorDisplayName;
    }

    public final String getPostStatus() {
        return this.postStatus;
    }

    public final void setPostStatus(final String postStatus) {
        this.postStatus = postStatus;
    }

    public final String getWpPostFormat() {
        return this.wpPostFormat;
    }

    public final void setWpPostFormat(final String wpPostFormat) {
        this.wpPostFormat = wpPostFormat;
    }

    public final Boolean isSticky() {
        return this.sticky;
    }

    public final void setSticky(final Boolean sticky) {
        this.sticky = sticky;
    }

    public final CustomField[] getCustomFields() {
        return this.customFields;
    }

    public final void setCustomFields(final CustomField[] customFields) {
        this.customFields = customFields;
    }

    public final Enclosure getEnclosure() {
        return this.enclosure;
    }

    public final void setEnclosure(final Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public final static Map<String, Object > parseStruct(final Post post) {

        Map<String, Object > map = new HashMap<String, Object> ();

        if(post.getPostId() > 0) {
            map.put(PostElement.POST_ID.toString(), post.getPostId());
        }

        if(post.getTitle() != null && !post.getTitle().isEmpty()) {
            map.put(PostElement.TITLE.toString(), post.getTitle());
        }

        if(post.getDescription() != null && !post.getDescription().isEmpty()) {
            map.put(PostElement.DESCRIPTION.toString(), post.getDescription());
        }

        if(post.getLink() != null && !post.getLink().isEmpty()) {
            map.put(PostElement.LINK.toString(), post.getLink());
        }

        if(post.getUserId() != null && !post.getUserId().isEmpty()) {
            map.put(PostElement.USER_ID.toString(), post.getUserId());
        }

        if(post.getDateCreated() != null) {
            map.put(PostElement.DATE_CREATED.toString(), post.getDateCreated());
        }

        if(post.getDateCreatedGmt() != null) {
            map.put(PostElement.DATE_CREATED_GMT.toString(), post.getDateCreatedGmt());
        }

        if(post.getDateModified() != null) {
            map.put(PostElement.DATE_MODIFIED.toString(), post.getDateModified());
        }

        if(post.getDateModifiedGmt() != null) {
            map.put(PostElement.DATE_MODIFIED_GMT.toString(), post.getDateModifiedGmt());
        }

        if(post.getWpPostThumbnail() != null && !post.getWpPostThumbnail().isEmpty()) {
            map.put(PostElement.WP_POST_THUMBNAIL.toString(), post.getWpPostThumbnail());
        }

        if(post.getPermaLink() != null && !post.getPermaLink().isEmpty()) {
            map.put(PostElement.PERMA_LINK.toString(), post.getPermaLink());
        }

        if(post.getCategoriesName() != null && post.getCategoriesName().length > 0) {
            map.put(PostElement.CATEGORIES.toString(), post.getCategoriesName());
        }

        if(post.getMtKeywords() != null && !post.getMtKeywords().isEmpty()) {
            map.put(PostElement.MT_KEYWORDS.toString(), post.getMtKeywords());
        }

        if(post.getMtExcerpt() != null && !post.getMtExcerpt().isEmpty()) {
            map.put(PostElement.MT_EXCERPT.toString(), post.getMtExcerpt());
        }

        if(post.getWpMoreText() != null && !post.getWpMoreText().isEmpty()) {
            map.put(PostElement.WP_MORE_TEXT.toString(), post.getWpMoreText());
        }

        if(post.getMtAllowComments() != null) {
            map.put(PostElement.MT_ALLOW_COMMENTS.toString(), post.getMtAllowComments());
        }

        if(post.getMtAllowPings() != null)  {
            map.put(PostElement.MT_ALLOW_PINGS.toString(), post.getMtAllowPings());
        }

        if(post.getWpSlug() != null && !post.getWpSlug().isEmpty()) {
            map.put(PostElement.WP_SLUG.toString(), post.getWpSlug());
        }

        if(post.getWpPassword() != null && !post.getWpPassword().isEmpty()) {
            map.put(PostElement.WP_PASSWORD.toString(), post.getWpPassword());
        }

        if(post.getWpAuthorId() != null && !post.getWpAuthorId().isEmpty()) {
            map.put(PostElement.WP_AUTHOR_ID.toString(), post.getWpAuthorId());
        }

        if(post.getWpAuthorDisplayName() != null && !post.getWpAuthorDisplayName().isEmpty()) {
            map.put(PostElement.WP_AUTHOR_DISPLAY_NAME.toString(), post.getWpAuthorDisplayName());
        }

        if(post.getPostStatus() != null && !post.getPostStatus().isEmpty()) {
            map.put(PostElement.POST_STATUS.toString(), post.getPostStatus());
        }

        if(post.getWpPostFormat() != null && !post.getWpPostFormat().isEmpty()) {
            map.put(PostElement.WP_POST_FORMAT.toString(), post.getWpPostFormat());
        }

        if(post.isSticky() != null) {
            map.put(PostElement.STICKY.toString(), post.isSticky());
        }

        if(post.getCustomFields() != null && post.getCustomFields().length > 0) {
            map.put(PostElement.CUSTOM_FIELDS.toString(), CustomField.parseStruct(post.getCustomFields()));
        }

        if(post.getEnclosure() != null) {
            map.put(PostElement.ENCLOSURE.toString(), Enclosure.parseStruct(post.getEnclosure()));
        }

        return map;
    }

    public final static Post[] valueOf(final Object[] object) {

        if (object == null || object.length == 0) {
            return null;
        }

        Post[] post = new Post[object.length];

        for (int i=0; i<object.length; i++) {
            post[i] = valueOf(object[i]);
        }

        return post;
    }

    public final static Post valueOf(final Object object) {

        @SuppressWarnings("unchecked")
        Map<String, Object> map = (HashMap<String, Object>)object;

        Post post = new Post();

        if(map.containsKey(PostElement.POST_ID.toString())) {
            post.parsePostId(map.get(PostElement.POST_ID.toString()));
        }

        if(map.containsKey(PostElement.TITLE.toString())) {
            post.setTitle((String)map.get(PostElement.TITLE.toString()));
        }

        if(map.containsKey(PostElement.DESCRIPTION.toString())) {
            post.setDescription((String)map.get(PostElement.DESCRIPTION.toString()));
        }

        if(map.containsKey(PostElement.LINK.toString())) {
            post.setLink((String)map.get(PostElement.LINK.toString()));
        }

        if(map.containsKey(PostElement.USER_ID.toString())) {
            post.setUserId((String)map.get(PostElement.USER_ID.toString()));
        }

        if(map.containsKey(PostElement.DATE_CREATED.toString())) {
            post.setDateCreated((Date)map.get(PostElement.DATE_CREATED.toString()));
        }

        if(map.containsKey(PostElement.DATE_CREATED_GMT.toString())) {
            post.setDateCreatedGmt((Date)map.get(PostElement.DATE_CREATED_GMT.toString()));
        }

        if(map.containsKey(PostElement.DATE_MODIFIED.toString())) {
            post.setDateModified((Date)map.get(PostElement.DATE_MODIFIED.toString()));
        }

        if(map.containsKey(PostElement.DATE_MODIFIED_GMT.toString())) {
            post.setDateModifiedGmt((Date)map.get(PostElement.DATE_MODIFIED_GMT.toString()));
        }

        if(map.containsKey(PostElement.WP_POST_THUMBNAIL.toString())) {
            post.setWpPostThumbnail((String)map.get(PostElement.WP_POST_THUMBNAIL.toString()));
        }

        if(map.containsKey(PostElement.PERMA_LINK.toString())) {
            post.setPermaLink((String)map.get(PostElement.PERMA_LINK.toString()));
        }

        if(map.containsKey(PostElement.CATEGORIES.toString())) {
            post.setCategories(Category.nameOf((Object[])map.get(PostElement.CATEGORIES.toString())));
        }

        if(map.containsKey(PostElement.MT_KEYWORDS.toString())) {
            post.setMtKeywords((String)map.get(PostElement.MT_KEYWORDS.toString()));
        }

        if(map.containsKey(PostElement.MT_EXCERPT.toString())) {
            post.setMtExcerpt((String)map.get(PostElement.MT_EXCERPT.toString()));
        }

        if(map.containsKey(PostElement.MT_TEXT_MORE.toString())) {
            post.setMtTextMore((String)map.get(PostElement.MT_TEXT_MORE.toString()));
        }

        if(map.containsKey(PostElement.WP_MORE_TEXT.toString())) {
            post.setWpMoreText((String)map.get(PostElement.WP_MORE_TEXT.toString()));
        }

        if(map.containsKey(PostElement.MT_ALLOW_COMMENTS.toString())) {
            post.setMtAllowComments((Integer)map.get(PostElement.MT_ALLOW_COMMENTS.toString()));
        }

        if(map.containsKey(PostElement.MT_ALLOW_PINGS.toString())) {
            post.setMtAllowPings((Integer)map.get(PostElement.MT_ALLOW_PINGS.toString()));
        }

        if(map.containsKey(PostElement.WP_SLUG.toString())) {
            post.setWpSlug((String)map.get(PostElement.WP_SLUG.toString()));
        }

        if(map.containsKey(PostElement.WP_PASSWORD.toString())) {
            post.setWpPassword((String)map.get(PostElement.WP_PASSWORD.toString()));
        }

        if(map.containsKey(PostElement.WP_AUTHOR_ID.toString())) {
            post.setWpAuthorId((String)map.get(PostElement.WP_AUTHOR_ID.toString()));
        }

        if(map.containsKey(PostElement.WP_AUTHOR_DISPLAY_NAME.toString())) {
            post.setWpAuthorDisplayName((String)map.get(PostElement.WP_AUTHOR_DISPLAY_NAME.toString()));
        }

        if(map.containsKey(PostElement.POST_STATUS.toString())) {
            post.setPostStatus((String)map.get(PostElement.POST_STATUS.toString()));
        }

        if(map.containsKey(PostElement.WP_POST_FORMAT.toString())) {
            post.setWpPostFormat((String)map.get(PostElement.WP_POST_FORMAT.toString()));
        }

        if(map.containsKey(PostElement.STICKY.toString())) {
            post.setSticky((Boolean)map.get(PostElement.STICKY.toString()));
        }

        if(map.containsKey(PostElement.CUSTOM_FIELDS.toString())) {
            post.setCustomFields(CustomField.valueOf((Object[])map.get(PostElement.CUSTOM_FIELDS.toString())));
        }

        if(map.containsKey(PostElement.ENCLOSURE.toString())) {
            post.setEnclosure(Enclosure.valueOf((Object)map.get(PostElement.ENCLOSURE.toString())));
        }

        return post;
    }

    private final void parsePostId(final Object object) {
        this.postId = (object instanceof String) ? Integer.parseInt((String)object) : (Integer)object;
    }
}
