package grailsinthecloud.bookstore

class Book {

	String title
	String description
	String isbn
	String website
	BigDecimal rating
	BookData data

	static belongsTo = [ author : Author ]

	static hasMany = [ categories : Category ]

    static constraints = {
    	title maxSize: 100, unique: true
    	website url: true
    	rating range: 1..5, scale: 1
    	data nullable: true
    }

}