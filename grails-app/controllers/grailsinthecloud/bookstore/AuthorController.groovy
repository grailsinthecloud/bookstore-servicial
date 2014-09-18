package grailsinthecloud.bookstore

import grails.converters.JSON
import grails.converters.XML

class AuthorController {

	def authorService

	static allowedMethods = [index: "GET", save: 'POST', delete: 'DELETE']

    def index() {

		def map = [ count: Author.count(), list: Author.list(), otra: 'labla' ]

    	render map as XML

    }

    def save() {

    	def authorName = params.name

    	def author = new Author(name: authorName)

    	author.save()

    	def nuevoAuthor = authorService.obtenerAuthor(author.id)

    	render nuevoAuthor as JSON

    }

    def delete() {

    	render 'estoy en delete'

    }

}