package grailsinthecloud.bookstore

class Category {

	String name

	Date dateCreated
   	Date lastUpdated

   	static hasMany = [ books : Book ]

   	static belongsTo = Book

    static constraints = {
    }

    static mapping = {
    	table 'genre'
    	autoTimestamp false
    }

}