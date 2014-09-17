package grailsinthecloud.bookstore

import grails.converters.JSON

class BookController {

    static allowedMethods = [index: "GET", save: 'POST', delete: 'DELETE']

    def index() {

		//def map = [ count: Author.count(), list: Author.list(), otra: 'labla' ]

    	//render map as XML

    }

    def save() {

    	def bookName = params.title

    	def authorId = params.authorId

    	def author = Author.get(authorId)

    	def book = new Book(title: bookName, author: author, description: params.description, isbn: params.isbn)

    	book.save()

    	render book as JSON

    }

}
