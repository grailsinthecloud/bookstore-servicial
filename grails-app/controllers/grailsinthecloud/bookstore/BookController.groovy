package grailsinthecloud.bookstore

import grails.converters.JSON

class BookController {

	def authorService

    static allowedMethods = [index: "GET", save: 'POST', delete: 'DELETE']

    def index() {

		def map = [ count: Book.count(), list: Book.list() ]

    	render map as JSON

    }

    def save() {

    	def bookName = params.title

    	def authorId = params.authorId

    	def author = authorService.obtenerAuthor(authorId)

    	def book = new Book(title: bookName, author: author, description: params.description, isbn: params.isbn)

    	book.save()

    	render book as JSON

    }

    //también funciona, mapeando los params con los fields del domain

    def saveWithParam(Book book) {

        book.save()

        render book as JSON

    }

}
