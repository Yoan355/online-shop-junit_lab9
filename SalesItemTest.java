import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    
    private SalesItem item;
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        item = new SalesItem("Iphone",3000);
    }
    
    
    @Test 
    public void testFindMostHelpfulCommentWithNoComments(){
    
    Comment result = item.findMostHelpfulComment();
    assertNull(result); //expecting null
    
    
    }
    
    
        @Test
    public void testFindMostHelpfulCommentWithOneComment() {
        item.addComment("Yoan", "Great laptop", 5);
        Comment result = item.findMostHelpfulComment();
        assertNotNull(result); // Should not be null
        assertEquals("Yoan", result.getAuthor()); // Should be Yoan's comment
    }
    
    
    
    @Test
    public void testFindMostHelpfulCommentWithMultipleComments() {
        item.addComment("Yoan", "Great laptop!", 5);       // votes = 0
        item.addComment("Bob", "Decent value.", 4);         // votes = 0
        item.addComment("Charlie", "Not impressed.", 2);    // votes = 0

        // Upvote Bob's comment twice
        item.upvoteComment(1);
        item.upvoteComment(1);

        // Upvote Yoan's comment once
        item.upvoteComment(0);

        // Downvote Charlie's comment once
        item.downvoteComment(2);

        Comment result = item.findMostHelpfulComment();
        assertNotNull(result); // Should return a comment
        assertEquals("Bob", result.getAuthor()); // Bob has highest vote count (2)
    }




    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }
}
