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

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import wp.xmlrpc.mwa.enums.MediaDataElement;
import wp.xmlrpc.mwa.enums.Overwrite;

/*
 * MediaData class test case 
 * 
 * author  Lee
 * version 1.0.0
 * since   1.0.0
 */
public class MediaDataTest {

    //static test data
    private final static String FILE_NAME     = "testImage.png";
    private final static String MINE_TYPE     = "PNG";
    private final static byte[] BASE64_BINARY = new byte[] {1, 3, 5, 7, 13};
    private final static Overwrite OVERWRITE  = Overwrite.TRUE;

    private MediaData target;

    @Before
    public void setUp() throws Exception {
        this.target = new MediaData();
    }

    @After
    public void tearDown() throws Exception {
        this.target = null;
    }

    @Test
    public void testParseStruct() {
        //populate test data
        this.target.setFileName(FILE_NAME);
        this.target.setMineType(MINE_TYPE);
        this.target.setBase64Binary(BASE64_BINARY);
        this.target.setOverwrite(OVERWRITE);

        Map<String, Object> map = MediaData.parseStruct(this.target);

        assertEquals(FILE_NAME,     (String)map.get(MediaDataElement.FILE_NAME.toString()));
        assertEquals(MINE_TYPE,     (String)map.get(MediaDataElement.MIME_TYPE.toString()));
        assertEquals(BASE64_BINARY, (byte[])map.get(MediaDataElement.BASE64_BINARY.toString()));

        assertTrue((Boolean)map.get(MediaDataElement.OVERWRITE.toString()));

        //object comparator test
        MediaData other = new MediaData();
        assertFalse(this.target.hashCode() == other.hashCode());
        assertFalse(this.target.equals(other));
    }

    @Test
    public void testParseStructBranchEmptyInstance() {
        //populate test data
        this.target.setFileName("");
        this.target.setMineType("");
        this.target.setBase64Binary(new byte[]{});
        Map<String, Object> map = MediaData.parseStruct(this.target);

        assertEquals(0, map.size());
    }

    @Test
    public void testParseStructBranchNullPointer() {
        //populate test data
        this.target.setFileName(null);
        this.target.setMineType(null);
        this.target.setBase64Binary(null);
        this.target.setOverwrite(null);

        Map<String, Object> map = MediaData.parseStruct(this.target);

        assertEquals(0, map.size());
        assertNull(MediaData.parseStruct(null));

        //object comparator test
        MediaData other = new MediaData();
        assertTrue(this.target.hashCode() == other.hashCode());
        assertTrue(this.target.equals(other));
    }
}
