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

import wp.xmlrpc.mwa.enums.CategoryElement;

/**
 * The class {@code Category} is a bean class 
 * 
 * @author  Lee
 * @version 1.0.0
 * @since   1.0.0
 */
public final class Category {

    private String categoryId;
    private String parentId;
    private String categoryName;
    private String categoryDescription;
    private String description;
    private String htmlUrl;
    private String rssUrl;

    public Category() {}

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final void setParentId(final String parentId) {
        this.parentId = parentId;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    public final String getCategoryDescription() {
        return this.categoryDescription;
    }

    public final void setCategoryDescription(final String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(final String description) {
        this.description = description;
    }

    public final String getHtmlUrl() {
        return this.htmlUrl;
    }

    public final void setHtmlUrl(final String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public final String getRssUrl() {
        return this.rssUrl;
    }

    public final void setRssUrl(final String rssUrl) {
        this.rssUrl = rssUrl;
    }

    public final static Category[] valueOf(final Object[] object) {

        if (object == null || object.length == 0) {
            return null;
        }

        Category[] categories = new Category[object.length];

        for (int i=0; i<object.length; i++) {
            categories [i] = valueOf(object[i]);
        }

        return categories ;
    }

    public final static Category valueOf(final Object object) {

        @SuppressWarnings("unchecked")
        Map<String, Object> map = (HashMap<String, Object>)object;

        Category category = new Category();

        if(map.containsKey(CategoryElement.CATEGORY_ID.toString())) {
            category.setCategoryId((String)map.get(CategoryElement.CATEGORY_ID.toString()));
        }

        if(map.containsKey(CategoryElement.PARENT_ID.toString())) {
            category.setParentId((String)map.get(CategoryElement.PARENT_ID.toString()));
        }

        if(map.containsKey(CategoryElement.CATEGORY_NAME.toString())) {
            category.setCategoryName((String)map.get(CategoryElement.CATEGORY_NAME.toString()));
        }

        if(map.containsKey(CategoryElement.CATEGORY_DESCRIPTION.toString())) {
            category.setCategoryDescription((String)map.get(CategoryElement.CATEGORY_DESCRIPTION.toString()));
        }

        if(map.containsKey(CategoryElement.DESCRIPTION.toString())) {
            category.setDescription((String)map.get(CategoryElement.DESCRIPTION.toString()));
        }

        if(map.containsKey(CategoryElement.HTML_URL.toString())) {
            category.setHtmlUrl((String)map.get(CategoryElement.HTML_URL.toString()));
        }

        if(map.containsKey(CategoryElement.RSS_URL.toString())) {
            category.setRssUrl((String)map.get(CategoryElement.RSS_URL.toString()));
        }

        return category;
    }

    public final static String[] nameOf(final Object[] object) {

        if (object == null || object.length == 0) {
            return null;
        }

        String[] categories = new String[object.length];

        for (int i=0; i<object.length; i++) {
            categories[i] = (String)object[i];
        }

        return categories;
    }

    public final static String[] parseNameStruct(final String... categories) {

        if(categories != null && categories.length < 0) {
            return null;
        }

        return categories;
    }
}
