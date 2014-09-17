package grailsinthecloud.bookstore

class Review {

	Book book

	String text

	Date dateCreated
   	Date lastUpdated

	static belongsTo = [ reviewer : User ]

    static constraints = {
    	text size: 20..500
    }

}