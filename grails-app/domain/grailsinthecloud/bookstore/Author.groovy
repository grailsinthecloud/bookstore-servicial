package grailsinthecloud.bookstore

class Author {

	String name

	static hasMany = [ books : Book ]

    static constraints = {

    }

}