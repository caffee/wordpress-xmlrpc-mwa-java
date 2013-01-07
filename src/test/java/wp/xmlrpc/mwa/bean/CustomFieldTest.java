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

import wp.xmlrpc.mwa.enums.CustomFieldElement;

/*
 * CustomField class test case 
 * 
 * author  Lee
 * version 1.0.0
 * since   1.0.0
 */
public class CustomFieldTest {

    //static test data
    private final static String ID          = "2012";
    private final static String KEY         = "custom_key";
    private final static String VALUE       = "custom_value";
    private final static String INVALID_KEY = "KEY";

    private CustomField target;

    @Before
    public void setUp() throws Exception {
        this.target = new CustomField();
    }

    @After
    public void tearDown() throws Exception {
        this.target = null;
    }

    @Test
    public void testParseStructCustomFieldArray() {
        //populate test data
        this.target.setId(ID);
        this.target.setKey(KEY);
        this.target.setValue(VALUE);

        CustomField[] customFields = new CustomField[1];
        customFields[0] = this.target;

        Object[] obj = CustomField.parseStruct(customFields);

        @SuppressWarnings("unchecked")
        Map<String, Object> map = (HashMap<String, Object>)obj[0];

        assertEquals(1, obj.length);

        assertEquals(KEY,   (String)map.get(CustomFieldElement.KEY.toString()));
        assertEquals(VALUE, (String)map.get(CustomFieldElement.VALUE.toString()));

        assertFalse(map.containsKey(CustomFieldElement.ID.toString()));
    }

    @Test
    public void testParseStructCustomFieldArrayBranchEmptyArray() {
        CustomField[] customFields = new CustomField[]{};
        assertEquals(0, CustomField.parseStruct(customFields).length);
    }

    @Test
    public void testParseStructCustomFieldArrayBranchNullPointer() {
        CustomField[] customFields = null;
        assertNull(CustomField.parseStruct(customFields));
    }

    @Test
    public void testParseStruct() {
        //populate test data
        this.target.setId(ID);
        this.target.setKey(KEY);
        this.target.setValue(VALUE);

        Map<String, Object> map = CustomField.parseStruct(this.target);

        assertEquals(KEY,   (String)map.get(CustomFieldElement.KEY.toString()));
        assertEquals(VALUE, (String)map.get(CustomFieldElement.VALUE.toString()));

        assertFalse(map.containsKey(CustomFieldElement.ID.toString()));
    }

    @Test
    public void testParseStructBranchEmptyInstance() {
        //populate test data
        this.target.setId("");
        this.target.setKey("");
        this.target.setValue("");

        Map<String, Object> map = CustomField.parseStruct(this.target);

        assertFalse(map.containsKey(CustomFieldElement.ID.toString()));
        assertFalse(map.containsKey(CustomFieldElement.KEY.toString()));
        assertFalse(map.containsKey(CustomFieldElement.VALUE.toString()));

        assertEquals(0, map.size());
    }

    @Test
    public void testParseStructBranchNullPointer() {
        //populate test data
        this.target.setId(null);
        this.target.setKey(null);
        this.target.setValue(null);

        Map<String, Object> map = CustomField.parseStruct(this.target);

        assertFalse(map.containsKey(CustomFieldElement.ID.toString()));
        assertFalse(map.containsKey(CustomFieldElement.KEY.toString()));
        assertFalse(map.containsKey(CustomFieldElement.VALUE.toString()));

        this.target = null;
        assertNull(CustomField.parseStruct(this.target));
    }

    @Test
    public void testValueOfObjectArray() {
        //populate test data
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(CustomFieldElement.ID.toString(),    ID);
        map.put(CustomFieldElement.KEY.toString(),   KEY);
        map.put(CustomFieldElement.VALUE.toString(), VALUE);

        Object[] obj = new Object[1];
        obj[0] = map;

        CustomField[] customFields = CustomField.valueOf(obj);

        assertEquals(1, customFields.length);

        //test valueOf()
        this.target = customFields[0];

        assertEquals(ID,    this.target.getId());
        assertEquals(KEY,   this.target.getKey());
        assertEquals(VALUE, this.target.getValue());

        //object comparator test
        CustomField other = new CustomField();
        assertFalse(this.target.hashCode() == other.hashCode());
        assertFalse(this.target.equals(other));
    }

    @Test
    public void testValueOfObjectArrayBranchEmptyArray() {
        Object[] obj = new Object[]{};
        assertNull(CustomField.valueOf(obj));
    }

    @Test
    public void testValueOfObjectArrayBranchNullPointer() {
        Object[] obj = null;
        assertNull(CustomField.valueOf(obj));
    }

    @Test
    public void testValueOfBranch() {
        //populate test data
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(INVALID_KEY, null);

        this.target = CustomField.valueOf(map);

        assertNull(this.target.getId());
        assertNull(this.target.getKey());
        assertNull(this.target.getValue());

        //object comparator test
        CustomField other = new CustomField();
        assertTrue(this.target.hashCode() == other.hashCode());
        assertTrue(this.target.equals(other));
    }

    @Test
    public void testValueOfBranchEmptyInstance() {
        assertNull(CustomField.valueOf(new HashMap<String, Object>()));
    }

    @Test
    public void testValueOfBranchNullPointer() {
        Object obj = null;
        assertNull(CustomField.valueOf(obj));
    }
}