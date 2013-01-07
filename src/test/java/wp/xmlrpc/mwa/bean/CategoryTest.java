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

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import wp.xmlrpc.mwa.enums.CategoryElement;

/*
 * Category class test case
 * 
 * author  Lee
 * version 1.0.0
 * since   1.0.0
 */
public class CategoryTest {

    //static test data
    private final static String CATEGORY_ID          = "1";
    private final static String PARENT_ID            = "3";
    private final static String CATEGORY_NAME        = "media";
    private final static String CATEGORY_DESCRIPTION = "latest media news";
    private final static String DESCRIPTION          = "media";
    private final static String HTML_URL             = "http://localhost/wordpress/category";
    private final static String RSS_URL              = "http://localhost/wordpress/category-rss";
    private final static String INVALID_KEY          = "KEY";
    private final static String CATEGORY_NAME_NEWS   = "news";
    private final static String CATEGORY_NAME_SPORTS = "sports";

    private Category target;

    @Before
    public void setUp() throws Exception {
        this.target = new Category();
    }

    @After
    public void tearDown() throws Exception {
        this.target = null;
    }

    @Test
    public void testValueOfObjectArray() {
        //populate test data
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(CategoryElement.CATEGORY_ID.toString(),          CATEGORY_ID);
        map.put(CategoryElement.PARENT_ID.toString(),            PARENT_ID);
        map.put(CategoryElement.CATEGORY_NAME.toString(),        CATEGORY_NAME);
        map.put(CategoryElement.CATEGORY_DESCRIPTION.toString(), CATEGORY_DESCRIPTION);
        map.put(CategoryElement.DESCRIPTION.toString(),          DESCRIPTION);
        map.put(CategoryElement.HTML_URL.toString(),             HTML_URL);
        map.put(CategoryElement.RSS_URL.toString(),              RSS_URL);

        Object[] obj = new Object[1];
        obj[0] = map;

        Category[] categories = Category.valueOf(obj);

        assertEquals(1, categories.length);

        //test valueOf()
        this.target = categories[0];

        assertEquals(CATEGORY_ID,          this.target.getCategoryId());
        assertEquals(PARENT_ID,            this.target.getParentId());
        assertEquals(CATEGORY_NAME,        this.target.getCategoryName());
        assertEquals(CATEGORY_DESCRIPTION, this.target.getCategoryDescription());
        assertEquals(DESCRIPTION,          this.target.getDescription());
        assertEquals(HTML_URL,             this.target.getHtmlUrl());
        assertEquals(RSS_URL,              this.target.getRssUrl());

        //object comparator test
        Category other = new Category();
        assertFalse(this.target.hashCode() == other.hashCode());
        assertFalse(this.target.equals(other));
    }

    @Test
    public void testValueOfObjectArrayBranchEmptyArray() {
        Object[] obj = new Object[]{};
        assertNull(Category.valueOf(obj));
    }

    @Test
    public void testValueOfObjectArrayBranchNullPointer() {
        Object[] obj = null;
        assertNull(Category.valueOf(obj));
    }

    @Test
    public void testValueOfBranch() {
        //populate test data
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(INVALID_KEY, null);

        this.target = Category.valueOf(map);

        assertNull(this.target.getCategoryId());
        assertNull(this.target.getParentId());
        assertNull(this.target.getCategoryName());
        assertNull(this.target.getCategoryDescription());
        assertNull(this.target.getDescription());
        assertNull(this.target.getHtmlUrl());
        assertNull(this.target.getRssUrl());

        //object comparator test
        Category other = new Category();
        assertTrue(this.target.hashCode() == other.hashCode());
        assertTrue(this.target.equals(other));
    }

    @Test
    public void testValueOfBranchEmptyInstance() { 
        assertNull(Category.valueOf(new HashMap<String, Object>()));
    }

    @Test
    public void testValueOfBranchNullPointer() {
        Map<String, Object> map = null;
        assertNull(Category.valueOf(map));
    }

    @Test
    public void testNameOf() {
        //populate test data
        Object[] object = new Object[] {CATEGORY_NAME_NEWS, CATEGORY_NAME_SPORTS};
        String[] categories = Category.nameOf(object);

        assertEquals(Arrays.hashCode(object), Arrays.hashCode(categories));

        assertEquals(CATEGORY_NAME_NEWS,   categories[0]);
        assertEquals(CATEGORY_NAME_SPORTS, categories[1]);
    }

    @Test
    public void testNameOfBranchEmptyInstance() {
        assertNull(Category.nameOf(new Object[]{}));
    }

    @Test
    public void testNameOfBranchNullPointer() {
        assertNull(Category.nameOf(null));
    }

    @Test
    public void testParseNameStruct() {
        //populate test data
        String[] categories = new String[] {CATEGORY_NAME_NEWS, CATEGORY_NAME_SPORTS};
        Object[] object = Category.parseNameStruct(categories);

        assertEquals(Arrays.hashCode(categories), Arrays.hashCode(object));

        assertEquals(CATEGORY_NAME_NEWS,   (String)object[0]);
        assertEquals(CATEGORY_NAME_SPORTS, (String)object[1]);
    }

    @Test
    public void testParseNameStructBranchEmptyInstance() {
        assertNull(Category.parseNameStruct(new String[]{}));
    }

    @Test
    public void testParseNameStructBranchNullPointer() {
        assertNull(Category.parseNameStruct(null));
    }
}