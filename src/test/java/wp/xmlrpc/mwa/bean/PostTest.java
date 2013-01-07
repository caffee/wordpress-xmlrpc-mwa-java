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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import wp.xmlrpc.mwa.enums.PostElement;
import wp.xmlrpc.mwa.enums.PostType;

/*
 * Post class test case 
 * 
 * author  Lee
 * version 1.0.0
 * since   1.0.0
 */
public class PostTest {

    //static test data
    private final static int POST_ID                   = 1;
    private final static String TITLE                  = "Post Testcase";
    private final static String DESCRIPTION            = "Test Post class method";
    private final static PostType POST_TYPE            = PostType.POST;
    private final static String LINK                   = "http://localhost/wordpress/testcase";
    private final static String USER_ID                = "1";
    private final static Date DATE_CREATED             = new Date(1357367670049L);
    private final static Date DATE_CREATED_GMT         = new Date(1357367670049L);
    private final static Date DATE_MODIFIED            = new Date(1357367670049L);
    private final static Date DATE_MODIFIED_GMT        = new Date(1357367670049L);
    private final static String WP_POST_THUMBNAIL      = "http://localhost/wordpress/testcase/thumbnail";
    private final static String PERMA_LINK             = "http://localhost/wordpress/testcase";
    private final static String[] CATEGORIES           = new String[]{"news", "sports", "travel"};
    private final static String MT_KEYWORDS            = "MT_KEYWORDS";
    private final static String MT_EXCERPT             = "MT_EXCERPT";
    private final static String MT_TEXT_MORE           = "MT_TEXT_MORE";
    private final static String WP_MORE_TEXT           = "WP_MORE_TEXT";
    private final static Integer MT_ALLOW_COMMENTS     = 0;
    private final static Integer MT_ALLOW_PINGS        = 0;
    private final static String WP_SLUG                = "Post Testcase";
    private final static String WP_PASSWORD            = "magic123";
    private final static String WP_AUTHOR_ID           = "1";
    private final static String WP_AUTHOR_DISPLAY_NAME = "wpEditor";
    private final static String POST_STATUS            = "publish";
    private final static String WP_POST_FORMAT         = "post";
    private final static Boolean STICKY                = Boolean.TRUE;
    private final static CustomField[] CUSTOM_FIELDS   = new CustomField[1];
    private final static Enclosure ENCLOSURE           = new Enclosure();
    private final static String INVALID_KEY            = "KEY";

    private Post target;

    @Before
    public void setUp() throws Exception {
        this.target = new Post();
    }

    @After
    public void tearDown() throws Exception {
        this.target = null;
    }

    private void prePopulate() {
        //pre-populate test data
        ENCLOSURE.setUrl("http://localhost/podcast/channel-test.mp3");
        ENCLOSURE.setLength(1334255);
        ENCLOSURE.setType("MP3");

        CustomField customField = new CustomField();
        customField.setKey("custom_key");
        customField.setValue("custom_value");
        CUSTOM_FIELDS[0] = customField;
    }

    private void reset() {
        //reset pre-populate test data
        ENCLOSURE.setUrl(null);
        ENCLOSURE.setLength(0);
        ENCLOSURE.setType(null);

        CUSTOM_FIELDS[0] = null;
    }

    @Test
    public void testParseStruct() {
        //pre-populate test data
        this.prePopulate();
        //populate test data
        this.target.setTitle(TITLE);
        this.target.setDescription(DESCRIPTION);
        this.target.setPostType(POST_TYPE);
        this.target.setDateCreated(DATE_CREATED);
        this.target.setDateCreatedGmt(DATE_CREATED_GMT);
        this.target.setCategories(CATEGORIES);
        this.target.setMtKeywords(MT_KEYWORDS);
        this.target.setMtExcerpt(MT_EXCERPT);
        this.target.setMtTextMore(MT_TEXT_MORE);
        this.target.setMtAllowComments(MT_ALLOW_COMMENTS);
        this.target.setMtAllowPings(MT_ALLOW_PINGS);
        this.target.setWpSlug(WP_SLUG);
        this.target.setWpPassword(WP_PASSWORD);
        this.target.setWpAuthorId(WP_AUTHOR_ID);
        this.target.setWpAuthorDisplayName(WP_AUTHOR_DISPLAY_NAME);
        this.target.setPostStatus(POST_STATUS);
        this.target.setWpPostFormat(WP_POST_FORMAT);
        this.target.setSticky(STICKY);
        this.target.setCustomFields(CUSTOM_FIELDS);
        this.target.setEnclosure(ENCLOSURE);

        Map<String, Object> map = Post.parseStruct(this.target);

        assertEquals(TITLE,                  (String)map.get(PostElement.TITLE.toString()));
        assertEquals(DESCRIPTION,            (String)map.get(PostElement.DESCRIPTION.toString()));
        assertEquals(POST_TYPE.toString(),   (String)map.get(PostElement.POST_TYPE.toString()));
        assertEquals(DATE_CREATED,           (Date)map.get(PostElement.DATE_CREATED.toString()));
        assertEquals(DATE_CREATED_GMT,       (Date)map.get(PostElement.DATE_CREATED_GMT.toString()));
        assertEquals(MT_KEYWORDS,            (String)map.get(PostElement.MT_KEYWORDS.toString()));
        assertEquals(MT_EXCERPT,             (String)map.get(PostElement.MT_EXCERPT.toString()));
        assertEquals(MT_TEXT_MORE,           (String)map.get(PostElement.MT_TEXT_MORE.toString()));
        assertEquals(MT_ALLOW_COMMENTS,      (Integer)map.get(PostElement.MT_ALLOW_COMMENTS.toString()));
        assertEquals(MT_ALLOW_PINGS,         (Integer)map.get(PostElement.MT_ALLOW_PINGS.toString()));
        assertEquals(WP_SLUG,                (String)map.get(PostElement.WP_SLUG.toString()));
        assertEquals(WP_PASSWORD,            (String)map.get(PostElement.WP_PASSWORD.toString()));
        assertEquals(WP_AUTHOR_ID,           (String)map.get(PostElement.WP_AUTHOR_ID.toString()));
        assertEquals(WP_AUTHOR_DISPLAY_NAME, (String)map.get(PostElement.WP_AUTHOR_DISPLAY_NAME.toString()));
        assertEquals(POST_STATUS,            (String)map.get(PostElement.POST_STATUS.toString()));
        assertEquals(WP_POST_FORMAT,         (String)map.get(PostElement.WP_POST_FORMAT.toString()));
        assertEquals(STICKY,                 (Boolean)map.get(PostElement.STICKY.toString()));

        assertTrue(ENCLOSURE.equals(Enclosure.valueOf((Object)map.get(PostElement.ENCLOSURE.toString()))));

        assertEquals(Arrays.hashCode(CATEGORIES),
                     Arrays.hashCode((Object[])map.get(PostElement.CATEGORIES.toString())));
        assertEquals(Arrays.hashCode(CUSTOM_FIELDS),
                     Arrays.hashCode(CustomField.valueOf((Object[])map.get(PostElement.CUSTOM_FIELDS.toString()))));

        //reset pre-populate test data
        this.reset();
    }

    @Test
    public void testParseStructBranchEmptyInstance() {
        //populate test data
        this.target.setTitle("");
        this.target.setDescription("");
        this.target.setCategories(new String[]{});
        this.target.setMtKeywords("");
        this.target.setMtExcerpt("");
        this.target.setMtTextMore("");
        this.target.setWpSlug("");
        this.target.setWpPassword("");
        this.target.setWpAuthorId("");
        this.target.setWpAuthorDisplayName("");
        this.target.setPostStatus("");
        this.target.setWpPostFormat("");
        this.target.setCustomFields(new CustomField[]{});

        Map<String, Object> map = Post.parseStruct(this.target);

        assertEquals(0, map.size());
    }

    @Test
    public void testParseStructBranchNullPointer() {
        //populate test data
        this.target.setTitle(null);
        this.target.setDescription(null);
        this.target.setPostType(null);
        this.target.setDateCreated(null);
        this.target.setDateCreatedGmt(null);
        this.target.setCategories(null);
        this.target.setMtKeywords(null);
        this.target.setMtExcerpt(null);
        this.target.setMtTextMore(null);
        this.target.setMtAllowComments(null);
        this.target.setMtAllowPings(null);
        this.target.setWpSlug(null);
        this.target.setWpPassword(null);
        this.target.setWpAuthorId(null);
        this.target.setWpAuthorDisplayName(null);
        this.target.setPostStatus(null);
        this.target.setWpPostFormat(null);
        this.target.setSticky(null);
        this.target.setCustomFields(null);
        this.target.setEnclosure(null);

        Map<String, Object> map = Post.parseStruct(this.target); 

        assertEquals(0, map.size());
        assertNull(Post.parseStruct(null));
    }

    @Test
    public void testValueOfObjectArray() {
        //pre-populate test data
        this.prePopulate();
        //populate test data
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(PostElement.POST_ID.toString(),                POST_ID);
        map.put(PostElement.TITLE.toString(),                  TITLE);
        map.put(PostElement.DESCRIPTION.toString(),            DESCRIPTION);
        map.put(PostElement.LINK.toString(),                   LINK);
        map.put(PostElement.USER_ID.toString(),                USER_ID);
        map.put(PostElement.DATE_CREATED.toString(),           DATE_CREATED);
        map.put(PostElement.DATE_CREATED_GMT.toString(),       DATE_CREATED_GMT);
        map.put(PostElement.DATE_MODIFIED.toString(),          DATE_MODIFIED);
        map.put(PostElement.DATE_MODIFIED_GMT.toString(),      DATE_MODIFIED_GMT);
        map.put(PostElement.WP_POST_THUMBNAIL.toString(),      WP_POST_THUMBNAIL);
        map.put(PostElement.PERMA_LINK.toString(),             PERMA_LINK);
        map.put(PostElement.CATEGORIES.toString(),             Category.parseNameStruct(CATEGORIES));
        map.put(PostElement.MT_KEYWORDS.toString(),            MT_KEYWORDS);
        map.put(PostElement.MT_EXCERPT.toString(),             MT_EXCERPT);
        map.put(PostElement.MT_TEXT_MORE.toString(),           MT_TEXT_MORE);
        map.put(PostElement.WP_MORE_TEXT.toString(),           WP_MORE_TEXT);
        map.put(PostElement.MT_ALLOW_COMMENTS.toString(),      MT_ALLOW_COMMENTS);
        map.put(PostElement.MT_ALLOW_PINGS.toString(),         MT_ALLOW_PINGS);
        map.put(PostElement.WP_SLUG.toString(),                WP_SLUG);
        map.put(PostElement.WP_PASSWORD.toString(),            WP_PASSWORD);
        map.put(PostElement.WP_AUTHOR_ID.toString(),           WP_AUTHOR_ID);
        map.put(PostElement.WP_AUTHOR_DISPLAY_NAME.toString(), WP_AUTHOR_DISPLAY_NAME);
        map.put(PostElement.POST_STATUS.toString(),            POST_STATUS);
        map.put(PostElement.WP_POST_FORMAT.toString(),         WP_POST_FORMAT);
        map.put(PostElement.STICKY.toString(),                 STICKY);
        map.put(PostElement.CUSTOM_FIELDS.toString(),          CustomField.parseStruct(CUSTOM_FIELDS));
        map.put(PostElement.ENCLOSURE.toString(),              Enclosure.parseStruct(ENCLOSURE));

        Object[] obj = new Object[1];
        obj[0] = map;

        Post[] posts = Post.valueOf(obj);

        assertEquals(1, posts.length);

        this.target = posts[0];

        assertEquals(POST_ID,                this.target.getPostId());
        assertEquals(TITLE,                  this.target.getTitle());
        assertEquals(DESCRIPTION,            this.target.getDescription());
        assertEquals(LINK,                   this.target.getLink());
        assertEquals(USER_ID,                this.target.getUserId());
        assertEquals(DATE_CREATED,           this.target.getDateCreated());
        assertEquals(DATE_CREATED_GMT,       this.target.getDateCreatedGmt());
        assertEquals(DATE_MODIFIED,          this.target.getDateModified());
        assertEquals(DATE_MODIFIED_GMT,      this.target.getDateModifiedGmt());
        assertEquals(WP_POST_THUMBNAIL,      this.target.getWpPostThumbnail());
        assertEquals(PERMA_LINK,             this.target.getPermaLink());
        assertEquals(MT_KEYWORDS,            this.target.getMtKeywords());
        assertEquals(MT_EXCERPT,             this.target.getMtExcerpt());
        assertEquals(MT_TEXT_MORE,           this.target.getMtTextMore());
        assertEquals(WP_MORE_TEXT,           this.target.getWpMoreText());
        assertEquals(MT_ALLOW_COMMENTS,      this.target.getMtAllowComments());
        assertEquals(MT_ALLOW_PINGS,         this.target.getMtAllowPings());
        assertEquals(WP_SLUG,                this.target.getWpSlug());
        assertEquals(WP_PASSWORD,            this.target.getWpPassword());
        assertEquals(WP_AUTHOR_ID,           this.target.getWpAuthorId());
        assertEquals(WP_AUTHOR_DISPLAY_NAME, this.target.getWpAuthorDisplayName());
        assertEquals(POST_STATUS,            this.target.getPostStatus());
        assertEquals(WP_POST_FORMAT,         this.target.getWpPostFormat());
        assertEquals(STICKY,                 this.target.isSticky());

        assertTrue(ENCLOSURE.equals(this.target.getEnclosure()));

        assertEquals(Arrays.hashCode(CATEGORIES),    Arrays.hashCode(this.target.getCategories()));
        assertEquals(Arrays.hashCode(CUSTOM_FIELDS), Arrays.hashCode(this.target.getCustomFields()));

        //object comparator test
        Post other = new Post();
        assertFalse(this.target.hashCode() == other.hashCode());
        assertFalse(this.target.equals(other));

        //reset pre-populate test data
        this.reset();
    }

    @Test
    public void testValueOfObjectArrayBranchEmptyArray() {
        Object[] obj = new Object[]{};
        assertNull(Post.valueOf(obj));
    }

    @Test
    public void testValueOfObjectArrayBranchNullPointer() {
        Object[] obj = null;
        assertNull(Post.valueOf(obj));
    }

    @Test
    public void testValueOfBranch() {
        //populate test data
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(INVALID_KEY, null);

        this.target = Post.valueOf(map);

        assertEquals(0, this.target.getPostId());

        assertNull(this.target.getTitle());
        assertNull(this.target.getDescription());
        assertNull(this.target.getLink());
        assertNull(this.target.getUserId());
        assertNull(this.target.getDateCreated());
        assertNull(this.target.getDateCreatedGmt());
        assertNull(this.target.getDateModified());
        assertNull(this.target.getDateModifiedGmt());
        assertNull(this.target.getWpPostThumbnail());
        assertNull(this.target.getPermaLink());
        assertNull(this.target.getCategories());
        assertNull(this.target.getMtKeywords());
        assertNull(this.target.getMtExcerpt());
        assertNull(this.target.getMtTextMore());
        assertNull(this.target.getMtAllowComments());
        assertNull(this.target.getMtAllowPings());
        assertNull(this.target.getWpSlug());
        assertNull(this.target.getWpPassword());
        assertNull(this.target.getWpAuthorId());
        assertNull(this.target.getWpAuthorDisplayName());
        assertNull(this.target.getPostStatus());
        assertNull(this.target.getWpPostFormat());
        assertNull(this.target.isSticky());
        assertNull(this.target.getCustomFields());
        assertNull(this.target.getEnclosure());

        //object comparator test
        Post other = new Post();
        assertTrue(this.target.hashCode() == other.hashCode());
        assertTrue(this.target.equals(other));
    }

    @Test
    public void testValueOfBranchEmptyInstance() { 
        assertNull(Post.valueOf(new HashMap<String, Object>()));
    }

    @Test
    public void testValueOfBranchNullPointer() {
        Object obj = null;
        assertNull(Post.valueOf(obj));
    }
}