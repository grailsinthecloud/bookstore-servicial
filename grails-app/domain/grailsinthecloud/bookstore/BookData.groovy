package grailsinthecloud.bookstore

class BookData {

	Integer numberOfPages
	Integer numberOfChapters
	Byte[] coverPicture

	static hasOne = [ book : Book ]

    static constraints = {
    	numberOfPages nullable: true, min: 0
    	numberOfChapters nullable: true, min: 0
    	coverPicture nullable: true
    }

}