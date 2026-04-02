package com.LibrarySystem.model;
	
public class IssueRequest {

    private int bookId;
    private String requester;

    public IssueRequest(int bookId, String requester) {
        this.bookId = bookId;
        this.requester = requester;
    }

    public int getBookId() {
        return bookId;
    }

    public String getRequester() {
        return requester;
    }

    @Override
    public String toString() {
        return requester + " requested Book ID " + bookId;
    }
}
