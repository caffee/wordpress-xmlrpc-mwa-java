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

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import wp.xmlrpc.mwa.enums.UsersBlogElement;

/*
 * UsersBlog class test case 
 * 
 * author  Lee
 * version 1.0.0
 * since   1.0.0
 */
public class UsersBlogTest {

    //static test data
    private final static String BLOG_ID     = "1";
    private final static String URL         = "http://localhost/wordpress";
    private final static String BLOG_NAME   = "wp-test-blog";
    private final static boolean IS_ADMIN   = Boolean.TRUE;
    private final static String END_POINT   = "http://localhost/wordpress/xmlrpc.php";
    private final static String INVALID_KEY = "KEY";

    private UsersBlog target;

    @Before
    public void setUp() throws Exception {
        this.target = new UsersBlog();
    }

    @After
    public void tearDown() throws Exception {
        this.target = null;
    }

    @Test
    public void testValueOfObjectArray() {
        //populate test data
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(UsersBlogElement.BLOG_ID.toString(),   BLOG_ID);
        map.put(UsersBlogElement.URL.toString(),       URL);
        map.put(UsersBlogElement.BLOG_NAME.toString(), BLOG_NAME);
        map.put(UsersBlogElement.IS_ADMIN.toString(),  IS_ADMIN);
        map.put(UsersBlogElement.ENDPOINT.toString(),  END_POINT);

        Object[] obj = new Object[1];
        obj[0] = map;

        UsersBlog[] usersBlogs = UsersBlog.valueOf(obj);

        assertEquals(1, usersBlogs.length);

        //test valueOf()
        this.target = usersBlogs[0];

        assertEquals(BLOG_ID,   this.target.getBlogId());
        assertEquals(URL,       this.target.getUrl());
        assertEquals(BLOG_NAME, this.target.getBlogName());
        assertEquals(IS_ADMIN,  this.target.isAdmin());
        assertEquals(END_POINT, this.target.getEndPoint());

        //object comparator test
        UsersBlog other = new UsersBlog();
        assertFalse(this.target.hashCode() == other.hashCode());
        assertFalse(this.target.equals(other));
    }

    @Test
    public void testValueOfObjectArrayBranchEmptyArray() {
        Object[] obj = new Object[]{};
        assertNull(UsersBlog.valueOf(obj));
    }

    @Test
    public void testValueOfObjectArrayBranchNullPointer() {
        Object[] obj = null;
        assertNull(UsersBlog.valueOf(obj));
    }

    @Test
    public void testValueOfBranch() {
        //populate test data
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(INVALID_KEY, null);

        this.target = UsersBlog.valueOf(map);

        assertNull(this.target.getBlogId());
        assertNull(this.target.getUrl());
        assertNull(this.target.getBlogName());
        assertFalse(this.target.isAdmin());
        assertNull(this.target.getEndPoint());

        //object comparator test
        UsersBlog other = new UsersBlog();
        assertTrue(this.target.hashCode() == other.hashCode());
        assertTrue(this.target.equals(other));
    }

    @Test
    public void testValueOfBranchEmptyInstance() { 
        assertNull(UsersBlog.valueOf(new HashMap<String, Object>()));
    }

    @Test
    public void testValueOfBranchNullPointer() {
        Map<String, Object> map = null;
        assertNull(UsersBlog.valueOf(map));
    }
}
