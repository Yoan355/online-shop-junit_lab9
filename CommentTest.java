
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest 


{
   
    private Comment comment;
    
    
    
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    
    {
           
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
            comment = new Comment("Yoan", "Great item", 5);
            //creating new Comment object with Author,text,rating,ensures each test starts with 
            //fresh comment


    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {

        comment= null; // it clears the comment variable to clean up memory.

    }

   @Test
   public void testAuthorStoredCorrectly() {
        assertEquals("Yoan" , comment.getAuthor());
        //should return "Yoan"
    

}




@Test
public void testRatingStoredCorrectly(){



assertEquals(5, comment.getRating());


}



@Test
public void testInitialVoteCountIsZero(){

assertEquals(0,comment.getVoteCount());

}



@Test
public void testUpVote(){

comment.upvote();
assertEquals(1,comment.getVoteCount()); //this tests that calling upvote() increases the vote count by 1.



}


@Test
public void testDownvoteDecreasesVoteCount()

{
    

comment.downvote();
assertEquals(-1,comment.getVoteCount());

}
}