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

import wp.xmlrpc.mwa.enums.MediaElement;

/*
 * Media class test case 
 * 
 * author  Lee
 * version 1.0.0
 * since   1.0.0
 */
public class MediaTest {

    //static test data
    private final static String ID          = "2013";
    private final static String FILE_NAME   = "testImage.png";
    private final static String URL         = "http://localhost/wp-content/png/testImage.png";
    private final static String TYPE        = "PNG";
    private final static String INVALID_KEY = "KEY";

    private Media target;

    @Before
    public void setUp() throws Exception {
        this.target = new Media();
    }

    @After
    public void tearDown() throws Exception {
        this.target = null;
    }

    @Test
    public void testValueOf() {
        //populate test data
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(MediaElement.ID.toString(),        ID);
        map.put(MediaElement.FILE_NAME.toString(), FILE_NAME);
        map.put(MediaElement.URL.toString(),       URL);
        map.put(MediaElement.TYPE.toString(),      TYPE);

        this.target = Media.valueOf(map);

        assertEquals(ID,        this.target.getId());
        assertEquals(FILE_NAME, this.target.getFileName());
        assertEquals(URL,       this.target.getUrl());
        assertEquals(TYPE,      this.target.getType());

        //object comparator test
        Media other = new Media();
        assertFalse(this.target.hashCode() == other.hashCode());
        assertFalse(this.target.equals(other));
    }

    @Test
    public void testValueOfBranch() {
        //populate test data
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(INVALID_KEY, null);

        this.target = Media.valueOf(map);

        assertNull(this.target.getId());
        assertNull(this.target.getFileName());
        assertNull(this.target.getUrl());
        assertNull(this.target.getType());

        //object comparator test
        Media other = new Media();
        assertTrue(this.target.hashCode() == other.hashCode());
        assertTrue(this.target.equals(other));
    }

    @Test
    public void testValueOfBranchEmptyInstance() { 
        assertNull(Media.valueOf(new HashMap<String, Object>()));
    }

    @Test
    public void testValueOfBranchNullPointer() {
        assertNull(Media.valueOf(null));
    }
}
