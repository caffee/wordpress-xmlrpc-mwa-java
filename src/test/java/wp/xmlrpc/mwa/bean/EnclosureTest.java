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

import wp.xmlrpc.mwa.enums.EnclosureElement;

/*
 * Enclosure class test case 
 * 
 * author  Lee
 * version 1.0.0
 * since   1.0.0
 */
public class EnclosureTest {

    //static test data
    private final static String URL         = "http://localhost/podcast/channel-test.mp3";
    private final static int LENGTH         = 1334255;
    private final static String TYPE        = "MP3"; 
    private final static String INVALID_KEY = "KEY";

    private Enclosure target;

    @Before
    public void setUp() throws Exception {
        this.target = new Enclosure();
    }

    @After
    public void tearDown() throws Exception {
        this.target = null;
    }

    @Test
    public void testParseStruct() {
        //populate test data
        this.target.setUrl(URL);
        this.target.setLength(LENGTH);
        this.target.setType(TYPE);

        Map<String, Object > map = Enclosure.parseStruct(this.target);

        assertEquals(URL,    (String)map.get(EnclosureElement.URL.toString()));
        assertEquals(LENGTH, (int)map.get(EnclosureElement.LENGTH.toString()));
        assertEquals(TYPE,   (String)map.get(EnclosureElement.TYPE.toString()));
    }

    @Test
    public void testParseStructBranchEmptyInstance() {
        //populate test data
        this.target.setUrl("");
        this.target.setLength(0);
        this.target.setType("");
        Map<String, Object> map = Enclosure.parseStruct(this.target);

        assertEquals(0, map.size());
    }

    @Test
    public void testParseStructBranchNullPointer() {
        //populate test data
        this.target.setUrl(null);
        this.target.setType(null);
        Map<String, Object> map = Enclosure.parseStruct(this.target);

        assertEquals(0, map.size());
        assertNull(Enclosure.parseStruct(null));
    }

    @Test
    public void testValueOf() {
        //populate test data
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EnclosureElement.URL.toString(),    URL);
        map.put(EnclosureElement.LENGTH.toString(), LENGTH);
        map.put(EnclosureElement.TYPE.toString(),   TYPE);

        this.target = Enclosure.valueOf(map);

        assertEquals(URL,    this.target.getUrl());
        assertEquals(LENGTH, this.target.getLength());
        assertEquals(TYPE,   this.target.getType());

        //object comparator test
        Enclosure other = new Enclosure();
        assertFalse(this.target.hashCode() == other.hashCode());
        assertFalse(this.target.equals(other));
    }

    @Test
    public void testValueOfBranch() {
        //populate test data
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(INVALID_KEY, null);

        this.target = Enclosure.valueOf(map);

        assertNull(this.target.getUrl());
        assertNull(this.target.getType());
        assertEquals(0, this.target.getLength());

        //object comparator test
        Enclosure other = new Enclosure();
        assertTrue(this.target.hashCode() == other.hashCode());
        assertTrue(this.target.equals(other));
    }

    @Test
    public void testValueOfBranchEmptyInstance() {
        assertNull(Enclosure.valueOf(new HashMap<String, Object>()));
    }

    @Test
    public void testValueOfBranchNullPointer() {
        assertNull(Enclosure.valueOf(null));
    }
}