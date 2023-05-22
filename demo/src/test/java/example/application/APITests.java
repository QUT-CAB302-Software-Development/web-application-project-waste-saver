package example.application;


import static org.junit.jupiter.api.Assertions.assertEquals;

/*
@SpringBootTest
class APITests {

    private DummyFetcher fetcher;

    @BeforeEach
    void setUp() {
        fetcher = new DummyFetcher();
    }

    @Test
    void contextLoads() {
    }

	@Test
	void testFetchCommentID() {
        DummyComment comment = fetcher.fetchDummyComment(1);
		assertEquals(1, comment.getId());
	}

    @Test
    void testFetchCommentBody(){
        DummyComment comment = fetcher.fetchDummyComment(3);
        assertEquals("You are an amazing writer!", comment.getBody());
    }

    @Test
    void testFetchCommentsSize(){
        DummyComment[] comments = fetcher.fetchDummyComments();
        assertEquals(30, comments.length);
    }

    @Test
    void testFetchCommentsUser(){
        DummyComment[] comments = fetcher.fetchDummyComments();
        DummyUser user = comments[3].getUser();
        assertEquals("bleveragei", user.getUsername());
    }
}

 */